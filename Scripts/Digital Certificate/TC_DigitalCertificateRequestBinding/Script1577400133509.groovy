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
import internal.GlobalVariable as GlobalVariable
import utilities.CommonUtilities



WebUI.callTestCase(findTestCase('Login/TC_Login'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'pages.HomePage.cllickOnLnkDigitalCertificate'()

CustomKeywords.'pages.DigitalCertificatePage.clickOnBtnCloseAlert'()
 
CustomKeywords.'pages.DigitalCertificatePage.clickOnBtnCertificateRequest'()

CustomKeywords.'pages.DigitalCertificateRequestPage.enterCompanyData'(id, names, lastname, company, city, address, mobile, mail, code)

CustomKeywords.'pages.DigitalCertificateRequestPage.clickOnBtnNext'()

CustomKeywords.'pages.DigitalCertificateRequestPage.clickOnBtnConfirm'()

CustomKeywords.'pages.DigitalCertificateRequestPage.verifyDataAttachmentInterface'()

CommonUtilities.Intance().endScenario()