package org.odessa.contract.dao;

import java.util.List;

import org.odessa.contract.entities.Contract;

public interface ContractDAO {

	public void addContract(Contract contract);

	public Contract getContract(Integer id);
	
	public List<Contract> listContract();
	
	public void updateContract(Contract contract);

	public void removeContract(Integer id);
}