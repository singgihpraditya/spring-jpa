package com.bca.omniservice.rest.simple.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bca.omniservice.rest.simple.entity.Customer;
import com.bca.omniservice.rest.simple.request.customer.Filter;
import com.bca.omniservice.rest.simple.request.customer.PagingRequest;

@Repository
public class CustomerCriteriaRepository {
	@Autowired
	private EntityManager entityManager;

	public List<Customer> findByFilter(PagingRequest request) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> criteriaQuery = cb.createQuery(Customer.class);

		Root<Customer> root = criteriaQuery.from(Customer.class);

		if(request.getSortOrder().equalsIgnoreCase("asc"))
			criteriaQuery.orderBy(cb.asc(root.get(request.getSortField())));
		else
			criteriaQuery.orderBy(cb.desc(root.get(request.getSortField())));
				
	    List<Predicate> predicatesList = new ArrayList<>();
	    
	    List<Filter> filterList = request.getFilters();
	    for (Filter filter : filterList) {
	    	 predicatesList.add(cb.like(root.get(filter.getName()), "%"+filter.getValue()+"%"));
		}
	    
	    Predicate[] finalPredicates = new Predicate[predicatesList.size()];
	    predicatesList.toArray(finalPredicates);
	    criteriaQuery.where(finalPredicates);
	
		List<Customer> result = entityManager.createQuery(criteriaQuery)
				.setMaxResults(request.getSize())
				.setFirstResult(request.getSize() * (request.getPage()-1)).getResultList();

		return result;
	}
	
	public Long countAll(PagingRequest request){ 	
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
	    Root<Customer> root = criteriaQuery.from(Customer.class);
	    
    List<Predicate> predicatesList = new ArrayList<>();
	    
	    List<Filter> filterList = request.getFilters();
	    for (Filter filter : filterList) {
	    	 predicatesList.add(cb.like(root.get(filter.getName()), "%"+filter.getValue()+"%"));
		}
	    Predicate[] finalPredicates = new Predicate[predicatesList.size()];
	    predicatesList.toArray(finalPredicates);
	    criteriaQuery.select(cb.count(root));
	    criteriaQuery.where(finalPredicates);
	    
	    Long result = entityManager.createQuery(criteriaQuery).getSingleResult();
		return result;
	}
}
