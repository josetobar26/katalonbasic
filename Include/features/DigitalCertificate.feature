Feature: Digital Certificate

  Scenario: Diligenciar una solicitud de certificado digital
    Given El usuario navega a la pagina de login
    When El usuario ingresa las credenciales correctas
    And Da click en el botón de login
    And Ingresar a la interfaz de certificado digital
    And cerrar alerta
    And Seleccionar la opción de solicitud de certificado digital
    And Ingresar la información de Datos de la empresa
    And Seleccionar la opción siguiente
    And Confirmar los datos ingresados
    Then Debería pasar a la interfaz de adjuntar documentación
    And Finalizar Escenario
    
    
  Scenario Outline: Diligenciar una solicitud de certificado digital
    Given El usuario navega a la pagina de login
    When El usuario ingresa las credenciales correctas
    And Da click en el botón de login
    And Ingresar a la interfaz de certificado digital
    And cerrar alerta
    And Seleccionar la opción de solicitud de certificado digital
    And Ingresar la información de Datos de la empresa <id>
    And Seleccionar la opción siguiente
    And Confirmar los datos ingresados
    Then Debería pasar a la interfaz de adjuntar documentación
    And Finalizar Escenario
    
    Examples:
    | id |
    | 1	 |
    | 2  |
    
    
