package actions;

import org.framework.driver.DriverFactory;
import org.framework.utils.MongoUtils;
import org.framework.utils.NetworkUtils;
import org.framework.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.cadastroPage;
import pages.LoginPage;

public class cadastroFlowAction {

    private final WebDriver driver = DriverFactory.getDriver();
    private static final Logger log = LoggerFactory.getLogger(cadastroFlowAction.class);

    public void acessarTelaCadastro() {
        log.info("Abrindo home");
        driver.get("https://qualeagiria.com.br/");

        log.info("Clicando em Login");
        WaitUtils.waitElement(driver, LoginPage.loginButton).click();

        log.info("Clicando em Criar Conta");
        WaitUtils.waitElement(driver, cadastroPage.criarContaLink).click();
    }

    public void preencherCadastroComDadosDoMongo() {
        String name = MongoUtils.getField("name");
        String email = MongoUtils.getField("email");
        String password = MongoUtils.getField("password");

        log.info("Preenchendo cadastro com usuario: {}", email);

        WaitUtils.waitElement(driver, cadastroPage.nomeInput).sendKeys(name);
        WaitUtils.waitElement(driver, cadastroPage.emailInput).sendKeys(email);
        WaitUtils.waitElement(driver, cadastroPage.senhaInput).sendKeys(password);
        WaitUtils.waitElement(driver, cadastroPage.confirmarSenhaInput).sendKeys(password);
    }

    public void clicarCriarConta() {
        log.info("Confirmando criacao da conta");
        WaitUtils.waitElement(driver, cadastroPage.criarContaButton).click();
    }

    public void validarSignupComSucesso() {
        boolean responseOk = NetworkUtils.waitForResponseStatus(
                driver,
                "https://api.qualeagiria.com.br/auth/signup",
                201,
                120
        );

        if (!responseOk) {
            throw new RuntimeException("A API de signup nao retornou status 201 dentro do tempo esperado");
        }

        log.info("API de signup respondeu 201 com sucesso");
    }


}