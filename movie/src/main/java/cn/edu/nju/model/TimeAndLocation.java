package cn.edu.nju.model;

import java.sql.Timestamp;

public class TimeAndLocation {
	
	private String location;
	private String hall;
	private String price;
	private String platform;
	private Timestamp time;
	private String remain_seat;
	private String cinema_name;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getRemain_seat() {
		return remain_seat;
	}
	public void setRemain_seat(String remain_seat) {
		this.remain_seat = remain_seat;
	}
	public String getCinema_name() {
		return cinema_name;
	}
	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}

	
}
