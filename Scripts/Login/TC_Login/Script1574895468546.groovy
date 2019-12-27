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

WebUI.openBrowser(findTestData('Login/DD_Login').getValue(1, 1))

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Login/inputUserName'), findTestData('Login/DD_Login').getValue(2, 1))

WebUI.setText(findTestObject('Login/inputPassword'), findTestData('Login/DD_Login').getValue(3, 1))

WebUI.click(findTestObject('Login/buttonLogin'))

WebUI.waitForElementPresent(findTestObject('HomePage/ImgLogo'), 5)

//WebUI.click(findTestObject('HomePage/spanList'))

//WebUI.click(findTestObject('HomePage/a_Cerrar Sesin'))

//WebUI.verifyElementPresent(findTestObject('Login/inputUserName'), 5)

//WebUI.closeBrowser()

