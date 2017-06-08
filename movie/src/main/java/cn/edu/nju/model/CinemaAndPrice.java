package cn.edu.nju.model;

import java.util.List;

public class CinemaAndPrice {
	
	private String cinema_id;
	private String cinema_name;
	private String cinema_address;
	private List<Price> lowestPriceForEachPlatform;
	public String getCinema_id() {
		return cinema_id;
	}
	public void setCinema_id(String cinema_id) {
		this.cinema_id = cinema_id;
	}
	public String getCinema_name() {
		return cinema_name;
	}
	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}
	public String getCinema_address() {
		return cinema_address;
	}
	public void setCinema_address(String cinema_address) {
		this.cinema_address = cinema_address;
	}
	public List<Price> getLowestPriceForEachPlatform() {
		return lowestPriceForEachPlatform;
	}
	public void setLowestPriceForEachPlatform(List<Price> lowestPriceForEachPlatform) {
		this.lowestPriceForEachPlatform = lowestPriceForEachPlatform;
	}
	
	
}
