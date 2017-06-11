package cn.edu.nju.entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "userbill", schema = "hotel", catalog = "")
public class BillEntity {

//primary key
private int id;
//the date of last consume
private int condate;
// the sum of cosumes
private double sum;
// the total number of consumes
private int frequency;
// the avergae amount of money of consumes
private double avg;

private int HotelId;

@GeneratedValue
@Id
@Column(name = "id", nullable = false)
public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public BillEntity(int condate, double sum, int frequency, double avg) {
	super();
	this.condate = condate;
	this.sum = sum;
	this.frequency = frequency;
	this.avg = avg;
}

public BillEntity(){}

@Basic
@Column(name = "condate", nullable = true)
public int getCondate() {
	return condate;
}

public void setCondate(int condate) {
	this.condate = condate;
}
@Basic
@Column(name = "sum", nullable = true)
public double getSum() {
	return sum;
}

public void setSum(double sum) {
	this.sum = sum;
}

@Basic
@Column(name = "frequency", nullable = true)
public int getFrequency() {
	return frequency;
}

public void setFrequency(int frequency) {
	this.frequency = frequency;
}

@Basic
@Column(name = "avg", nullable = true)
public double getAvg() {
	return avg;
}


@Basic
@Column(name = "HotelID", nullable = true)
public int getHotelId() {
	return HotelId;
}

public void setHotelId(int hotelId) {
	HotelId = hotelId;
}

public BillEntity(int condate, double sum, int frequency, double avg, int hotelId) {
	super();
	this.condate = condate;
	this.sum = sum;
	this.frequency = frequency;
	this.avg = avg;
	HotelId = hotelId;
}

public void setAvg(double avg) {
	this.avg = avg;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BillEntity other = (BillEntity) obj;
	if (HotelId != other.HotelId)
		return false;
	if (Double.doubleToLongBits(avg) != Double.doubleToLongBits(other.avg))
		return false;
	if (condate != other.condate)
		return false;
	if (frequency != other.frequency)
		return false;
	if (id != other.id)
		return false;
	if (Double.doubleToLongBits(sum) != Double.doubleToLongBits(other.sum))
		return false;
	return true;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + HotelId;
	long temp;
	temp = Double.doubleToLongBits(avg);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + condate;
	result = prime * result + frequency;
	result = prime * result + id;
	temp = Double.doubleToLongBits(sum);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}

}
