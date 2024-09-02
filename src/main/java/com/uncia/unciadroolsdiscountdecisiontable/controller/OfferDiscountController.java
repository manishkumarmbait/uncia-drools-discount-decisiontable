package com.uncia.unciadroolsdiscountdecisiontable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uncia.unciadroolsdiscountdecisiontable.model.Customer;
import com.uncia.unciadroolsdiscountdecisiontable.model.Offer;
import com.uncia.unciadroolsdiscountdecisiontable.service.OfferDiscountService;

@RestController
@RequestMapping("/ruleservice")
public class OfferDiscountController {

	@Autowired
	private OfferDiscountService offerDiscountService;

	@PostMapping("/getOfferDiscount")
	public ResponseEntity<Offer> getDiscount(@RequestBody Customer customer) {
		Offer discount = offerDiscountService.getDiscount(customer);
		return new ResponseEntity<>(discount, HttpStatus.OK);
	}
}
