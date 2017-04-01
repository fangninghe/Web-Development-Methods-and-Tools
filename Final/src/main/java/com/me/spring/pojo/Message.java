package com.me.spring.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messagetable")
public class Message {

	public Message() {
		String pattern = "mm/dd/yyyy HH:mm:ss";
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		time = sf.format(new Date());
	}
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "time")
	private String time;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="buyer")
	private BuyerUser buyer;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="seller")
	private SellerUser seller;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BuyerUser getBuyer() {
		return buyer;
	}
	public void setBuyer(BuyerUser buyer) {
		this.buyer = buyer;
	}
	public SellerUser getSeller() {
		return seller;
	}
	public void setSeller(SellerUser seller) {
		this.seller = seller;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
