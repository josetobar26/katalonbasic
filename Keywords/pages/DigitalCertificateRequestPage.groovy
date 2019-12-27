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
import org.openqa.selenium.Keys

import internal.GlobalVariable

public class DigitalCertificateRequestPage {

	private TestObject selectId = findTestObject('Digital Certificate/Digital Certificate Request/Company Data/selectId')
	private TestObject inputNames = findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputName')
	private TestObject inputLastName = findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputLastName')
	private TestObject inputCompanyName = findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputCompanyName')
	private TestObject iconRemoveCity = findTestObject('Object Repository/Digital Certificate/Digital Certificate Request/Company Data/iconRemoveCity')
	private TestObject inputCity = findTestObject('Object Repository/Digital Certificate/Digital Certificate Request/Company Data/inputCity')
	private TestObject inputAddress = findTestObject('Object Repository/Digital Certificate/Digital Certificate Request/Company Data/inputaddress')
	private TestObject inputMobile = findTestObject('Object Repository/Digital Certificate/Digital Certificate Request/Company Data/inputMobile')
	private TestObject inputMail = findTestObject('Object Repository/Digital Certificate/Digital Certificate Request/Company Data/inputMail')
	private TestObject inputPostalCode = findTestObject('Object Repository/Digital Certificate/Digital Certificate Request/Company Data/inputPostalCode')

	private TestObject btnNext = findTestObject('Digital Certificate/Digital Certificate Request/Company Data/btnNext')
	private TestObject btnConfirm = findTestObject('Digital Certificate/Digital Certificate Request/Company Data/PopUp/btnConfirm')
	private TestObject btnSendDoc = findTestObject('Digital Certificate/Digital Certificate Request/Attach Documentation/btnSendDocumentation')

	def selectIdentification(def item){
		WebUI.selectOptionByLabel(selectId, item, false)
	}

	def enterNames(def names){
		WebUI.clearText(inputNames)
		WebUI.setText(inputNames, names)
	}

	def enterLastName(def lastName){
		WebUI.clearText(inputLastName)
		WebUI.setText(inputLastName, lastName)
	}
	
	def enterCompanyName(def company){
		WebUI.clearText(inputCompanyName)
		WebUI.setText(inputCompanyName, company)
	}
	
	def enterCity(def city){
		if(WebUI.verifyElementPresent(iconRemoveCity, 5, FailureHandling.OPTIONAL)){
			WebUI.click(iconRemoveCity)
		}
		WebUI.setText(inputCity, city)
		Thread.sleep(3000)
		WebUI.sendKeys(inputCity, Keys.chord(Keys.TAB))
	}
	
	def enterAddress(def address){
		WebUI.clearText(inputAddress)
		WebUI.setText(inputAddress, address)
	}
	
	def enterMobile(def mobile){
		WebUI.clearText(inputMobile)
		WebUI.setText(inputMobile, mobile)
	}
	
	def enterMail(def mail){
		WebUI.clearText(inputMail)
		WebUI.setText(inputMail, mail)
	}
	
	def enterPostalCode(def code){
		WebUI.clearText(inputPostalCode)
		WebUI.setText(inputPostalCode, code)
	}

	@Keyword
	def enterCompanyData(def item, def names, def lastName, def company, def city, def address, def mobile, def mail, def code){
		selectIdentification(item)
		enterNames(names)
		enterLastName(lastName)
		enterCompanyName(company)
		enterCity(city)
		enterAddress(address)
		enterMobile(mobile)
		enterMail(mail)
		enterPostalCode(code)
	}

	@Keyword
	def clickOnBtnNext(){
		WebUI.waitForElementClickable(btnNext, 3)
		WebUI.click(btnNext)
		Thread.sleep(1000)
	}

	@Keyword
	def clickOnBtnConfirm(){
		WebUI.waitForElementClickable(btnConfirm, 3)
		WebUI.click(btnConfirm)
		Thread.sleep(1000)
	}

	@Keyword
	def verifyDataAttachmentInterface(){
		WebUI.verifyElementPresent(btnSendDoc, 5)
	}
}
