package com.me.user_service.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.me.user_service.entities.Hotel;
import com.me.user_service.entities.Rating;
import com.me.user_service.entities.User;
import com.me.user_service.external.services.HotelService;
import com.me.user_service.repositories.UserRepository;
import com.me.user_service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User user) {
		String user_id = UUID.randomUUID().toString();
		user.setUserId(user_id);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String user_id) {
		
		 User user = userRepository.findById(user_id).get();
		 Rating[] ratings=restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user_id, Rating[].class);
		 List<Rating> ratings1=Arrays.stream(ratings).toList();
		 List<Rating> ratings2= new ArrayList<>();
			
			  for(Rating rating:ratings1) { 
//				  Hotel hotel=restTemplate.getForObject("http://HOTEL-SERVICE/hotel/"+rating.getHotelId()
//			  ,Hotel.class); 
				  Hotel hotel = hotelService.getHotel(rating.getHotelId());
				 rating.setHotel(hotel);
				 ratings2.add(rating); 
				 }
			 
		 user.setRatings(ratings2);
		 System.out.println("rating="+user.getRatings());
		 return user;
	}

}
