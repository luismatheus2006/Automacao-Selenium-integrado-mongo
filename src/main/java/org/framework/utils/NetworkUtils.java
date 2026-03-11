package org.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.time.Duration;
import java.time.Instant;

public class NetworkUtils {

    public static boolean waitForResponseStatus(WebDriver driver,
                                                String urlFragment,
                                                int expectedStatus,
                                                int timeoutSeconds) {
        Instant end = Instant.now().plus(Duration.ofSeconds(timeoutSeconds));

        while (Instant.now().isBefore(end)) {
            LogEntries logs = driver.manage().logs().get(LogType.PERFORMANCE);

            for (LogEntry entry : logs) {
                String message = entry.getMessage();

                boolean hasUrl = message.contains(urlFragment);
                boolean hasStatus = message.contains("\"status\":" + expectedStatus);

                if (hasUrl && hasStatus && message.contains("Network.responseReceived")) {
                    return true;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrompida ao aguardar resposta da API", e);
            }
        }

        return false;
    }
}