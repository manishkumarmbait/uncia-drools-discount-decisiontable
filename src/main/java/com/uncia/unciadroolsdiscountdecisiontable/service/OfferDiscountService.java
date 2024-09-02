package com.uncia.unciadroolsdiscountdecisiontable.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uncia.unciadroolsdiscountdecisiontable.model.Customer;
import com.uncia.unciadroolsdiscountdecisiontable.model.Offer;

@Service
public class OfferDiscountService {

	@Autowired
	private KieContainer kieContainer;

	public Offer getDiscount(Customer customer) {
		Offer offer = new Offer();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("offer", offer);
//		kieSession.insert(offer);
		kieSession.insert(customer);
		kieSession.fireAllRules();
		kieSession.dispose();
		return offer;
	}

}
