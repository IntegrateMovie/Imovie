package cn.edu.nju.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotelbill", schema = "hotel", catalog = "")
public class HotelmanagementEntity {
	private int id;
    private String name;
    private int hotelid;
    private String manager;
    private double monthly_revenue;
    private int frequency;
    
	public HotelmanagementEntity() {
		
	}

	public HotelmanagementEntity(String name, int hotelid, String manager, double monthly_revenue, int frequency) {
		super();
		this.name = name;
		this.hotelid = hotelid;
		this.manager = manager;
		this.monthly_revenue = monthly_revenue;
		this.frequency = frequency;
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
   @Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	  @Basic
	    @Column(name = "hotelid", nullable = false)
	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	  @Basic
	    @Column(name = "manager", nullable = false)
	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	  @Basic
	    @Column(name = "monthly_revenue", nullable = false)
	public double getMonthly_revenue() {
		return monthly_revenue;
	}

	public void setMonthly_revenue(double monthly_revenue) {
		this.monthly_revenue = monthly_revenue;
	}

	  @Basic
	    @Column(name = "frequency", nullable = false)
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + frequency;
		result = prime * result + hotelid;
		result = prime * result + id;
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		long temp;
		temp = Double.doubleToLongBits(monthly_revenue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelmanagementEntity other = (HotelmanagementEntity) obj;
		if (frequency != other.frequency)
			return false;
		if (hotelid != other.hotelid)
			return false;
		if (id != other.id)
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (Double.doubleToLongBits(monthly_revenue) != Double.doubleToLongBits(other.monthly_revenue))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    
	
    
}
