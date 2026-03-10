package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import actions.loginAction;

public class LoginSteps {

    loginAction loginActions = new loginAction();

    @Given("que acesso o site")
    public void que_acesso_o_site() {

        loginActions.openSite();

    }

    @When("realizo login dinamico")
    public void realizo_login_dinamico() {

        String email = loginAction.getEmail();
        String password = loginAction.getPassword();

        loginActions.login(email, password);

    }

}

