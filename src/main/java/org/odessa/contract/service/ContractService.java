package org.odessa.contract.service;

import java.util.List;

import org.odessa.contract.entities.Contract;

public interface ContractService {

	public void addContract(Contract contract);

	public List<Contract> listContract();

	public void removeContract(Integer id);
}
