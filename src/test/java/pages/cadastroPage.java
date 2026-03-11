package pages;

import org.openqa.selenium.By;

public class cadastroPage {

    public static By criarContaLink =
            By.xpath("//a[contains(text(),'Criar Conta')]");

    public static By nomeInput =
            By.xpath("//input[@placeholder='Informe seu nome ou apelido']");

    public static By emailInput =
            By.cssSelector("input[type='email']");

    public static By senhaInput =
            By.cssSelector("input[placeholder='Insira uma senha']");

    public static By confirmarSenhaInput =
            By.cssSelector("input[placeholder='Confirmar Senha']");

    public static By criarContaButton =
            By.xpath("//button[contains(text(),'Criar Conta')]");
}