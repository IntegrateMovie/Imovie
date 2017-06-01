package cn.edu.nju.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CommentEntity
 *
 */
@Entity
@Table(name = "comment", schema = "movie", catalog = "")
public class CommentEntity implements Serializable {

	private int comment_id;
	private String movie_name;
	private String comment;
	private double grade;
	private Timestamp time;
	private String resource;
	

	public CommentEntity() {
	
	}


	public CommentEntity(String movie_name, String comment, double grade, Timestamp time, String resource) {
		super();
		this.movie_name = movie_name;
		this.comment = comment;
		this.grade = grade;
		this.time = time;
		this.resource = resource;
	}

	@GeneratedValue
    @Id
    @Column(name = "id", nullable = false)
	public int getComment_id() {
		return comment_id;
	}


	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	@Basic
    @Column(name = "movie_name", nullable = false)
	public String getMovie_name() {
		return movie_name;
	}


	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	 @Basic
	 @Column(name = "comment", nullable = false)
	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}

	@Basic
    @Column(name = "grade", nullable = false)
	public double getGrade() {
		return grade;
	}


	public void setGrade(double grade) {
		this.grade = grade;
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
	@Column(name = "resource", nullable = false)
	public String getResource() {
		return resource;
	}


	public void setResource(String resource) {
		this.resource = resource;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + comment_id;
		long temp;
		temp = Double.doubleToLongBits(grade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((movie_name == null) ? 0 : movie_name.hashCode());
		result = prime * result + ((resource == null) ? 0 : resource.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		CommentEntity other = (CommentEntity) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (comment_id != other.comment_id)
			return false;
		if (Double.doubleToLongBits(grade) != Double.doubleToLongBits(other.grade))
			return false;
		if (movie_name == null) {
			if (other.movie_name != null)
				return false;
		} else if (!movie_name.equals(other.movie_name))
			return false;
		if (resource == null) {
			if (other.resource != null)
				return false;
		} else if (!resource.equals(other.resource))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	
	
   
}
