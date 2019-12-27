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

public class DigitalCertificatePage {

	private TestObject btnCertificateRequest = findTestObject('Digital Certificate/btnCertificateRequest')
	private TestObject btnAceptAlert = findTestObject('Digital Certificate/btnAceptAlert')
	private TestObject btnCloseAlert = findTestObject('Object Repository/Digital Certificate/btnCloseAlert')


	@Keyword
	def clickOnBtnCloseAlert(){
		WebUI.click(btnCloseAlert)
		WebUI.waitForPageLoad(2)
	}

	@Keyword
	def clickOnBtnCertificateRequest(){
		WebUI.waitForElementClickable(btnCertificateRequest, 5)
		WebUI.click(btnCertificateRequest)
		aceptAlert()
	}

	@Keyword
	def aceptAlert(){
		boolean alert =  WebUI.verifyElementPresent(btnAceptAlert, 5, FailureHandling.OPTIONAL)
		if(alert){
			WebUI.waitForElementClickable(btnAceptAlert, 5)
			WebUI.click(btnAceptAlert)
			Thread.sleep(1000)
			WebUI.click(btnCertificateRequest)
		}
	}
}
