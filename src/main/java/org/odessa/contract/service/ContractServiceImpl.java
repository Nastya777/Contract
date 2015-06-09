package org.odessa.contract.service;
 
import java.util.List;
 



import org.odessa.contract.dao.ContractDAO;
import org.odessa.contract.entities.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

 
@Service
public class ContractServiceImpl implements ContractService {
 
    @Autowired
    private ContractDAO contractDAO;
 
    @Transactional
    public void addContract(Contract contract) {
        contractDAO.addContract(contract);
    }
    
    @Transactional
	public Contract getContract(Integer id) {
        return contractDAO.getContract(id);
	}
 
    @Transactional
    public List<Contract> listContract() {
 
        return contractDAO.listContract();
    }
 
    @Transactional
	public void updateContract(Contract contract) {
		contractDAO.updateContract(contract);		
	}
    
    @Transactional
    public void removeContract(Integer id) {
        contractDAO.removeContract(id);
    }


}
