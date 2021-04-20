package com.vuongltw.SneakerStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productid;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "productname")
	private String productName;
	
	@Column(name = "image")
	private String image;
	
	@Column
	private String type;
	
	@Column
	private String color;
	
	@Column
	private float price;
	
	@Column(columnDefinition = "TEXT")
	private String description;
}
