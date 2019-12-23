import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import pages.HomePage
import pages.LoginPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class LoginSteps {
	
	private TestData xlsLogin = findTestData('Login/DD_Login')
	private TestData xlsLogOff = findTestData('Login/DD_LogOff')
	
	LoginPage loginPage = new LoginPage()
	HomePage homePage = new HomePage()

	@Given("El usuario navega a la pagina de login")
	def navigateToLoginPage(){
		loginPage.navigateToLoginPage()
	}

	@When("El usuario ingresa las credenciales correctas")
	def enterCorrectCredentials(){
		loginPage.enterCredentials(xlsLogin.getValue(2, 1), xlsLogin.getValue(3, 1))
	}

	@When("El usuario ingresa las credenciales incorrectas")
	def enterIncorrectCredentials(){
		loginPage.enterCredentials(xlsLogOff.getValue(1, 1), xlsLogOff.getValue(2, 1))
	}

	@When("El usuario ingresa usuario (.*) y contraseña (.*)")
	def enterCredentials(String username, String password){
		loginPage.enterCredentials(username, password)
	}

	@And("Da click en el botón de login")
	def clickOnLoginButton(){
		loginPage.clickOnLoginButton()
	}

	@Then("El usuario debería ver la página de inicio")
	def verifyHomePage(){
		homePage.verifyHomePage()
	}
}