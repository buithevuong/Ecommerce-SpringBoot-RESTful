package com.vuongltw.SneakerStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemid;
	@Column(name = "productname")
	private String productName;
	
	private String image;
	
	@Column
	private int quantity;
	@Column
	private float price;
	
	
	
	@ManyToOne(targetEntity = Cart.class)
	@JoinColumn(name = "cart_id" , nullable = false, referencedColumnName = "cartid" , insertable = true , updatable = true)
	private Cart cart;
}
