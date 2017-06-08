package cn.edu.nju.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CinemaEntity
 *
 */
@Entity
@Table(name = "cinema_info", schema = "movie", catalog = "")
public class CinemaEntity implements Serializable {

	@GeneratedValue
    @Id
    @Column(name = "id", nullable = false)
	private int id;
	@Basic
    @Column(name = "name", nullable = false)
	private String name;
	@Basic
    @Column(name = "address", nullable = false)
	private String address;

	public CinemaEntity() {
		
	}
	
	
	
	public CinemaEntity(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
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
		CinemaEntity other = (CinemaEntity) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
   
}
