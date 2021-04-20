package com.vuongltw.SneakerStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_db")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderid;

	@OneToOne
	@JoinColumn(name = "cart_id", nullable = false, referencedColumnName = "cartid", insertable = true, updatable = true)
	private Cart cart;

	@OneToOne
	@JoinColumn(name = "shipment_id", nullable = false, referencedColumnName = "shipmentid", insertable = true, updatable = true)
	private Shipment shipment;

	@OneToOne
	@JoinColumn(name = "payment_id", nullable = false, referencedColumnName = "paymentid", insertable = true, updatable = true)
	private Payment payment;

	@Column(name = "status")
	private Integer status;

	@Column
	private float subtotal;
	@Column
	private float totalprice;

}
