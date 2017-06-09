package cn.edu.nju.model;

import java.util.List;

public class CinemaAndPrice {
	
	private String cinema_id;
	private String cinema_name;
	private String cinema_address;
	private List<Price> lowestPriceForEachPlatform;
	private String price1;
	private String price2;
	private String price3;
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
		this.price1 = lowestPriceForEachPlatform.get(0).getPrice()+"元起";
		this.price2 = lowestPriceForEachPlatform.get(1).getPrice()+"元起";
		this.price3 = lowestPriceForEachPlatform.get(2).getPrice()+"元起";
		this.lowestPriceForEachPlatform = lowestPriceForEachPlatform;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	public String getPrice2() {
		return price2;
	}
	public void setPrice2(String price2) {
		this.price2 = price2;
	}
	public String getPrice3() {
		return price3;
	}
	public void setPrice3(String price3) {
		this.price3 = price3;
	}
	
	
}
