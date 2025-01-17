package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.other.EnumStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Order_Id")
	private int orderId;
	
	@Column(name="Date_Of_Order")
	private final LocalDate doo = LocalDate.now();
	
	@Column(name="Order_Status",length =10)
	@Enumerated(EnumType.STRING)
	private EnumStatus status = EnumStatus.PENDING;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_email")
	@JsonIgnore
	private User user;
	
	@Column(name="address")
	private String address;
	
	@Column(name="total")
	private double total;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY ,mappedBy="order",cascade=CascadeType.ALL)
	private List<OrderProduct> products = new ArrayList<>();

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDate getDoo() {
		return doo;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", doo=" + doo + ", status=" + status + ", email=" + user + ", total="
				+ total + "]";
	}
	
	public void addProduct(OrderProduct product){
		products.add(product);
		product.setOrder(this);
	}
}
