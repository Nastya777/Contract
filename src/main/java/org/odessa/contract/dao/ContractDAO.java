package org.odessa.contract.dao;

import java.util.List;

import org.odessa.contract.entities.Contract;

public interface ContractDAO {

	public void addContract(Contract contract);

	public List<Contract> listContract();

	public void removeContract(Integer id);
}