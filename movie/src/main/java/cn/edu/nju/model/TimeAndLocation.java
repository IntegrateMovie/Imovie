package cn.edu.nju.model;

import java.sql.Timestamp;

public class TimeAndLocation {
	/**
	 * 影院地址
	 */
	private String location;
	/**
	 * 放映厅
	 */
	private String hall;
	/**
	 * 本场次票价
	 */
	private String price1;
	
	/**
	 * 平台
	 */
	private String platform;
	/**
	 * 放映开始时间
	 */
	private Timestamp time;
	/**
	 * 余座
	 */
	private String remain_seat;
	/**
	 * 电影院名
	 */
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
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price) {
		this.price1 = price;
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
