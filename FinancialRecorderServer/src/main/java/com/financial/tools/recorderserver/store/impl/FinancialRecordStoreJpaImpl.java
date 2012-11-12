package com.financial.tools.recorderserver.store.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.financial.tools.recorderserver.entity.FinancialRecord;
import com.financial.tools.recorderserver.store.FinancialRecordStore;

@Transactional
public class FinancialRecordStoreJpaImpl implements FinancialRecordStore {

	private EntityManager entityManager;

	@Override
	public long createFinancialRecord(FinancialRecord financialRecord) {
		entityManager.persist(financialRecord);
		return financialRecord.getId();
	}

	@Override
	public FinancialRecord getFinancialRecord(long financialRecordId) {
		Query query = entityManager.createQuery("SELECT f FROM FinancialRecord f where f.status = 1",
				FinancialRecord.class);
		try {
			FinancialRecord result = (FinancialRecord) query.getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void updateFinancialRecord(FinancialRecord financialRecord) {
		entityManager.clear();
		entityManager.merge(financialRecord);
	}

	@Override
	public List<FinancialRecord> listFinancialRecords() {
		Query query = entityManager.createQuery("SELECT f FROM FinancialRecord f", FinancialRecord.class);
		query.setMaxResults(10);
		return query.getResultList();
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
