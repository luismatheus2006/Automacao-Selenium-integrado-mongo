Feature: Cadastro


  Scenario: Criar conta com dados persistidos por execution id
    Given que acesso o site
    When acesso a tela de criacao de conta
    And gero e preencho os dados dinamicos do cadastro
    And confirmo a criacao da conta
    Then a api de cadastro deve responder com sucesso

  Scenario: Validar nome do usuario criado
    Given que acesso o site
    When realizo login com os dados persistidos
    And acesso meu perfil
    Then devo visualizar o nome salvo no mongo no perfil