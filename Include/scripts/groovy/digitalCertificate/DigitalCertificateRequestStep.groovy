package digitalCertificate

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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import internal.GlobalVariable
import pages.DigitalCertificatePage
import pages.DigitalCertificateRequestPage

public class DigitalCertificateRequestStep {

	DigitalCertificatePage digitalCertificatePage = new DigitalCertificatePage()
	DigitalCertificateRequestPage certificateRequestPage = new DigitalCertificateRequestPage()
	private TestData xlsData = findTestData('Digital Certificate/DD_DigitalCertificateRequest')

	@And("cerrar alerta")
	def clickOnBtnCloseAlert(){
		digitalCertificatePage.clickOnBtnCloseAlert()
	}

	@And("Seleccionar la opción de solicitud de certificado digital")
	def clickOnBtnDigitalCertificateRequest(){
		digitalCertificatePage.clickOnBtnCertificateRequest()
	}

	@And("Ingresar la información de Datos de la empresa")
	def enterCompanyData(){
		certificateRequestPage.enterCompanyData(xlsData.getValue(2, 1), xlsData.getValue(3, 1), xlsData.getValue(4, 1), xlsData.getValue(5, 1), 
			xlsData.getValue(6, 1), xlsData.getValue(7, 1), xlsData.getValue(8, 1), xlsData.getValue(9, 1), xlsData.getValue(10, 1),)
	}
	
	@And("Ingresar la información de Datos de la empresa (.*)")
	def enterCompanyDataFeature(def it){
		for (def i = 1; i <= xlsData.getRowNumbers(); i++){
			if (it == xlsData.getValue(1, i)){
				certificateRequestPage.enterCompanyData(xlsData.getValue(2, i), xlsData.getValue(3, i), xlsData.getValue(4, i), xlsData.getValue(5, i),
					xlsData.getValue(6, i), xlsData.getValue(7, i), xlsData.getValue(8, i), xlsData.getValue(9, i), xlsData.getValue(10, i),)
			}			
		}		
	}

	@And("Seleccionar la opción siguiente")
	def clickOnBtnNext(){
		certificateRequestPage.clickOnBtnNext()
	}

	@And("Confirmar los datos ingresados")
	def clickOnBtnConfirm(){
		certificateRequestPage.clickOnBtnConfirm()
	}

	@Then("Debería pasar a la interfaz de adjuntar documentación")
	def verifyDataAttachmentInterface(){
		certificateRequestPage.verifyDataAttachmentInterface()
	}
}
