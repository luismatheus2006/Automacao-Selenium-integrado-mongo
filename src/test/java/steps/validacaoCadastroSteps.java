package steps;

import actions.perfilAction;
import actions.loginAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.framework.utils.MongoUtils;

public class validacaoCadastroSteps {

    private final loginAction loginActions = new loginAction();
    private final perfilAction perfilAction = new perfilAction();

    @When("realizo login com os dados persistidos")
    public void realizo_login_com_os_dados_persistidos() {
        String email = MongoUtils.getField("email");
        String password = MongoUtils.getField("password");

        loginActions.login(email, password);
    }

    @When("acesso meu perfil")
    public void acesso_meu_perfil() {
        perfilAction.acessarMeuPerfil();
    }

    @Then("devo visualizar o nome salvo no mongo no perfil")
    public void devo_visualizar_o_nome_salvo_no_mongo_no_perfil() {
        perfilAction.validarNomeDoPerfil();
    }
}