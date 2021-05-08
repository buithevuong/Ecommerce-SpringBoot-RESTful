package com.vuongltw.SneakerStore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartid;
	
	@OneToMany(mappedBy = "cart" , fetch = FetchType.LAZY , targetEntity = Item.class , cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Item> listItem;
	
	
	@OneToOne
	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "userid", insertable = true, updatable = true)
	private UserEntity user;
	
	@Column
	private float subtotal;
	
	
	
	@Column(name = "totalprice")
	private float totalPrice;
}
