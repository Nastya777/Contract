package org.odessa.contract.controllers;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import org.odessa.contract.entities.Contract;
import org.odessa.contract.entities.NBU;
import org.odessa.contract.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractService;

	@RequestMapping("/index")
	public String listContracts(Map<String, Object> map) {

		map.put("contract", new Contract());
		map.put("contractList", contractService.listContract());

		return "contract";
		
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContract(@ModelAttribute("contract") Contract contract,
			BindingResult result) {
		
		contract.setCurrency(new NBU().getCurrency());
		Double nbu = contract.getCurrency()*contract.getSumma();
		nbu = new BigDecimal(nbu).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		contract.setSumma_nbu(nbu);
		
		contractService.addContract(contract);

		return "redirect:/index";
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public String showContact(@PathVariable("id") Integer id, 
			Map<String, Object> map) {
		Contract contract = contractService.getContract(id);

		map.put("contract", contract);
		
        return "getContract";
	}
	
	
	/*@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editContract(@ModelAttribute("contract") Contract contract,
			BindingResult result) {
		
		Double nbu = contract.getCurrency()*contract.getSumma();
		nbu = new BigDecimal(nbu).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		contract.setSumma_nbu(nbu);
		
		contractService.updateContract(contract);

		return "redirect:/index";
	}*/
	
	@RequestMapping("/delete/{contractId}")
	public String deleteContract(@PathVariable("contractId") Integer contractId) {

		contractService.removeContract(contractId);

		return "redirect:/index";
	}
	
	@RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
	public ModelAndView downloadPDF() {

		return new ModelAndView("pdfView");
	}
}
