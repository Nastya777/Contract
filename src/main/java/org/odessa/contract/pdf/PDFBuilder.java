package org.odessa.contract.pdf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFBuilder extends AbstractPdfView {
	//@Autowired
	//private ContractService contractService;
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

		//User user = (User) model.get("user");
		//map.put("contractList", contractService.listContract());
		
		//List<Contract> contracts = new ArrayList<Contract>();
		//contracts = contractService.listContract();
		
		//for (Contract contract : contracts) {
          //  System.out.println(contract.getFirstname());
            //doc.add(new Paragraph(contract.getFirstname()));
        //}    
		doc.add(new Paragraph("Contracts"));
		//doc.add(new Paragraph(user.getPassword()));

	}

}