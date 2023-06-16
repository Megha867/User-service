package com.me.user_service.entities;

public class Rating {
	
	private String rating_id;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	private Hotel hotel;
	
	
	public Rating() {
		super();
	}
	
	
	public Rating(String rating_id, String userId, String hotelId, int rating, String feedback,Hotel hotel) {
		super();
		this.rating_id = rating_id;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedback = feedback;
		this.hotel = hotel;
	}


	public String getRating_id() {
		return rating_id;
	}
	public void setRating_id(String rating_id) {
		this.rating_id = rating_id;
	}
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getHotelId() {
		return hotelId;
	}


	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}


	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
	

}
