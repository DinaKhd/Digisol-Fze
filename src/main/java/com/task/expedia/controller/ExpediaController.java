package com.task.expedia.controller;

import com.task.expedia.service.ExpediaService;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/expedia/offers")
@CrossOrigin(origins = "*") // Allow frontend requests
public class ExpediaController {

	@Autowired
	private ExpediaService expediaService;

	@GetMapping
	public String getExpediaOffers(@RequestParam String origin, @RequestParam String destination,@RequestParam String filter) {
		return expediaService.fetchOffers(origin, destination,filter);
	}
	@GetMapping("/search")
	public Map<String, Object> searchPackages(
			@RequestParam String origin,
			@RequestParam String destination,@RequestParam String filter) {
		return expediaService.getPackageDeals(origin, destination,filter);
	}

	public static void main(String[] args) {
		ExpediaController expediaController = new ExpediaController();
		System.out.println(expediaController.getExpediaOffers("New York", "San Francisco","highDiscount"));
	}
}
