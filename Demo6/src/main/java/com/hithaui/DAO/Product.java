package com.hithaui.DAO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Products")
public class Product {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "title")
	@Nationalized
	private String title;
	
	@Column(name = "image_link")
	private String imageLink;
	
	@UpdateTimestamp
	private Timestamp updateAt;
	
	@CreationTimestamp
	private Timestamp createAt;

	public Product(Integer productId, String title, String imageLink, Timestamp updateAt, Timestamp createAt) {
		super();
		this.productId = productId;
		this.title = title;
		this.imageLink = imageLink;
		this.updateAt = updateAt;
		this.createAt = createAt;
	}

	public Product() {

	}

	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	
	
	

	
	
}	