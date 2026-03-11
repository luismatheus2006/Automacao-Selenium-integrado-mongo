package actions;

import org.framework.driver.DriverFactory;
import org.framework.utils.MongoUtils;
import org.framework.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.PerfilPage;

public class perfilAction {

    private final WebDriver driver = DriverFactory.getDriver();
    private static final Logger log = LoggerFactory.getLogger(perfilAction.class);

    public void acessarMeuPerfil() {
        log.info("Acessando Meu Perfil");
        WaitUtils.waitElement(driver, PerfilPage.meuPerfilLink).click();
    }

    public void validarNomeDoPerfil() {
        String expectedName = MongoUtils.getField("name");

        WebElement titulo = WaitUtils.waitElement(driver, PerfilPage.nomePerfilTitulo);
        String actualName = titulo.getText();

        log.info("Nome esperado: {}", expectedName);
        log.info("Nome exibido: {}", actualName);

        if (!actualName.equals(expectedName)) {
            throw new RuntimeException(
                    "Nome do perfil divergente. Esperado: " + expectedName + " | Atual: " + actualName
            );
        }
    }
}