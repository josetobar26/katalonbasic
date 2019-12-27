import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Login/TC_Login'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.click(findTestObject('HomePage/lnkDigitalCertificate'))

CustomKeywords.'pages.HomePage.cllickOnLnkDigitalCertificate'()

WebUI.click(findTestObject('Digital Certificate/btnCloseAlert'))

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Digital Certificate/btnCertificateRequest'))

Thread.sleep(1000)

boolean alert =  WebUI.verifyElementPresent(findTestObject('Digital Certificate/btnAceptAlert'), 5, FailureHandling.OPTIONAL)

if(alert){
	WebUI.waitForElementClickable(findTestObject('Digital Certificate/btnAceptAlert'), 2)
	WebUI.click(findTestObject('Digital Certificate/btnAceptAlert'))
	Thread.sleep(1000)
	WebUI.click(findTestObject('Digital Certificate/btnCertificateRequest'))
}

WebUI.selectOptionByLabel(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/selectId'), 
	findTestData('Digital Certificate/DD_DigitalCertificateRequest').getValue("XLS_Identification", 1), false)

WebUI.clearText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputName'))

WebUI.setText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputName'), 
	findTestData('Digital Certificate/DD_DigitalCertificateRequest').getValue("XLS_Names", 1))

WebUI.clearText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputLastName'))

WebUI.setText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputLastName'),
	findTestData('Digital Certificate/DD_DigitalCertificateRequest').getValue("XLS_LastName", 1))

WebUI.clearText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputCompanyName'))
WebUI.setText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputCompanyName'), 
	findTestData('Digital Certificate/DD_DigitalCertificateRequest').getValue("XLS_CompanyName", 1))

WebUI.click(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/iconRemoveCity'))
WebUI.setText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputCity'), 
	findTestData('Digital Certificate/DD_DigitalCertificateRequest').getValue("XLS_City", 1))
Thread.sleep(3000)

WebUI.sendKeys(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputCity'), Keys.chord(Keys.TAB))

WebUI.clearText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputaddress'))
WebUI.setText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputaddress'), 
	findTestData('Digital Certificate/DD_DigitalCertificateRequest').getValue("XLS_Address", 1))

WebUI.clearText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputMobile'))
WebUI.setText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputMobile'), 
	findTestData('Digital Certificate/DD_DigitalCertificateRequest').getValue("XLS_Mobile", 1))

WebUI.clearText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputMail'))
WebUI.setText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputMail'), 
	findTestData('Digital Certificate/DD_DigitalCertificateRequest').getValue("XLS_MailCompany", 1))

WebUI.clearText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputPostalCode'))
WebUI.setText(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/inputPostalCode'), 
	findTestData('Digital Certificate/DD_DigitalCertificateRequest').getValue("XLS_PostalCode", 1))

WebUI.waitForElementClickable(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/btnNext'), 2)

WebUI.click(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/btnNext'))

Thread.sleep(1000)

WebUI.click(findTestObject('Digital Certificate/Digital Certificate Request/Company Data/PopUp/btnConfirm'))

Thread.sleep(1000)

WebUI.verifyElementPresent(findTestObject('Digital Certificate/Digital Certificate Request/Attach Documentation/btnSendDocumentation'), 0)

CustomKeywords.'utilities.CommonUtilities.endScenario'()
