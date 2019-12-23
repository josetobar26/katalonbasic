package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class LoginPage {

	private TestObject inputUsername = findTestObject('Login/inputUserName')
	private TestObject inputPassword = findTestObject('Login/inputPassword')
	private TestObject btnLogin = findTestObject('Login/buttonLogin')

	def navigateToLoginPage(){
		WebUI.openBrowser(GlobalVariable.URL)
	}

	def enterUserName(def userName){
		WebUI.setText(inputUsername, userName)
	}

	def enterPassword(def password){
		WebUI.setText(inputPassword, password)
	}

	def enterCredentials(def userName, def password){
		enterUserName(userName)
		enterPassword(password)
	}

	def clickOnLoginButton(){
		WebUI.click(btnLogin)
	}
}
