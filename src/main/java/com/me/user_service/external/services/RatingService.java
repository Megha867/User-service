package com.me.user_service.external.services;

import java.util.List;
import com.me.user_service.entities.Rating;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	@GetMapping("/rating")
	List<Rating> getListOfRatings();
	
	@PostMapping("/rating")
	Rating createRating(Rating rating);
}
