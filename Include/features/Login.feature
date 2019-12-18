Feature: Login

  Scenario: Test Login con credenciales correctas
    Given El usuario navega a la pagina de login
    When El usuario ingresa las credenciales correctas
    And Da click en el botón de login
    Then El usuario debería ver la página de inicio

  Scenario: Test Login con credenciales incorrectas
    Given El usuario navega a la pagina de login
    When El usuario ingresa las credenciales incorrectas
    And Da click en el botón de login
    Then El usuario debería ver la página de inicio

  Scenario Outline: Test Login con credenciales incorrectas con examples
    Given El usuario navega a la pagina de login
    When El usuario ingresa usuario <Username> y contraseña <Password>
    And Da click en el botón de login
    Then El usuario debería ver la página de inicio

    Examples: 
      | Username       | Password |
      | siigo@tech.com |     1111 |
      | tech@siigo.com |     3333 |
