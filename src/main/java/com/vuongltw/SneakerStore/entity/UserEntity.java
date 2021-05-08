package com.vuongltw.SneakerStore.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	@Column(unique = true)
	private String username;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
	@Column
	private Integer active;
	@Column
	private String role;
	
	
	
	@ManyToAny(fetch = FetchType.LAZY, metaColumn = @Column)
	@JoinTable(name = "users_roles" , joinColumns = @JoinColumn(name = "user_id") , 
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	
	
	
	
	
	@OneToMany(mappedBy = "user" , fetch = FetchType.LAZY , targetEntity = Order.class , cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Order> listOrder;


	
	
	
	
	UserEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
