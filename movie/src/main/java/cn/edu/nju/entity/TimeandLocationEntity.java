package cn.edu.nju.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TimeandLocationEntity
 *
 */
@Entity
@Table(name = "timeandlocation", schema = "movie", catalog = "")
public class TimeandLocationEntity {

	
	private int id;
	private String movie_name;
	private String resource;
	private String Location;
	private Timestamp time;
	private double price;
	private int remain_seat;
	

	public TimeandLocationEntity() {

	}

	public TimeandLocationEntity(String movie_name, String resource, String location, Timestamp time, double price,
			int remain_seat) {
		super();
		this.movie_name = movie_name;
		this.resource = resource;
		Location = location;
		this.time = time;
		this.price = price;
		this.remain_seat = remain_seat;
	}

	@GeneratedValue
    @Id
    @Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Basic
    @Column(name = "movie", nullable = false)
	public String getMovie_name() {
		return movie_name;
	}


	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	@Basic
    @Column(name = "resource", nullable = false)
	public String getResource() {
		return resource;
	}


	public void setResource(String resource) {
		this.resource = resource;
	}

	@Basic
    @Column(name = "location", nullable = false)
	public String getLocation() {
		return Location;
	}


	public void setLocation(String location) {
		Location = location;
	}

	@Basic
    @Column(name = "time", nullable = false)
	public Timestamp getTime() {
		return time;
	}


	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Basic
    @Column(name = "price", nullable = false)
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	@Basic
    @Column(name = "remain_seat", nullable = false)
	public int getRemain_seat() {
		return remain_seat;
	}


	public void setRemain_seat(int remain_seat) {
		this.remain_seat = remain_seat;
	}
	
	
   
}

