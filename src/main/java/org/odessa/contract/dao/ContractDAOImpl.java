package org.odessa.contract.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.odessa.contract.entities.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDAOImpl implements ContractDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContract(Contract contract) {
		sessionFactory.getCurrentSession().save(contract);
	}

	@SuppressWarnings("unchecked")
	public List<Contract> listContract() {

		return sessionFactory.getCurrentSession().createQuery("from Contract")
			.list();
	}
	
	public void removeContract(Integer id) {
		Contract contract = (Contract) sessionFactory.getCurrentSession().load(
				Contract.class, id);
		if (null != contract) {
			sessionFactory.getCurrentSession().delete(contract);
			sessionFactory.getCurrentSession().flush();
		}

	}
}
