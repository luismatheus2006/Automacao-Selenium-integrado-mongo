package steps;

import actions.cadastroFlowAction;
import actions.cadastroAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class cadastroSteps {

    private final cadastroFlowAction cadastroFlowAction = new cadastroFlowAction();

    @When("acesso a tela de criacao de conta")
    public void acesso_a_tela_de_criacao_de_conta() {
        cadastroFlowAction.acessarTelaCadastro();
    }

    @When("gero e preencho os dados dinamicos do cadastro")
    public void gero_e_preencho_os_dados_dinamicos_do_cadastro() {
        cadastroAction.ensureUserData();
        cadastroFlowAction.preencherCadastroComDadosDoMongo();
    }

    @When("confirmo a criacao da conta")
    public void confirmo_a_criacao_da_conta() {
        cadastroFlowAction.clicarCriarConta();
    }

    @Then("a api de cadastro deve responder com sucesso")
    public void a_api_de_cadastro_deve_responder_com_sucesso() {
        cadastroFlowAction.validarSignupComSucesso();
    }
}