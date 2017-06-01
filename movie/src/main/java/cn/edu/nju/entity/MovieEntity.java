package cn.edu.nju.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MoiveEntity
 *
 */
@Entity
@Table(name = "moive_info", schema = "movie", catalog = "")
public class MovieEntity implements Serializable {

	
	private String moive_name;
	private String director;
	private String roles;
	private String time_length;
	private String nation;
	private String intro;
	private String type;
	
	public MovieEntity() {
		
	}
	
    @Id
    @Column(name = "movie_name", nullable = false)
	public String getMoive_name() {
		return moive_name;
	}

	public void setMoive_name(String moive_name) {
		this.moive_name = moive_name;
	}
	@Basic
    @Column(name = "director", nullable = false)
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	@Basic
    @Column(name = "roles", nullable = false)
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Basic
    @Column(name = "time_length", nullable = false)
	public String getTime_length() {
		return time_length;
	}

	public void setTime_length(String time_length) {
		this.time_length = time_length;
	}
	@Basic
    @Column(name = "nation", nullable = false)
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	@Basic
    @Column(name = "intro", nullable = false)
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Basic
    @Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
		result = prime * result + ((moive_name == null) ? 0 : moive_name.hashCode());
		result = prime * result + ((nation == null) ? 0 : nation.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((time_length == null) ? 0 : time_length.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		MovieEntity other = (MovieEntity) obj;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (intro == null) {
			if (other.intro != null)
				return false;
		} else if (!intro.equals(other.intro))
			return false;
		if (moive_name == null) {
			if (other.moive_name != null)
				return false;
		} else if (!moive_name.equals(other.moive_name))
			return false;
		if (nation == null) {
			if (other.nation != null)
				return false;
		} else if (!nation.equals(other.nation))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (time_length == null) {
			if (other.time_length != null)
				return false;
		} else if (!time_length.equals(other.time_length))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
   
}
