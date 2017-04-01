package com.me.spring.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="sellerusertable")
public class SellerUser {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id; 
	
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="name")
	private String name;
	@Column(name="gender")
	private String gender;
	@Column(name="ssn")
	private String ssn;
	@Column(name="phonenumber")
	private String phoneNumber;
	@Column(name="address")
	private String address;
	@Column(name="email")
	private String email;
	@Column(name="aboutme")
	private String aboutMe;
	@Column(name="catagory")
	private String catagory;
	@Column(name="photoname")
	private String photoName;
	
	
	@Column(name="price")
	private String price;
	@Column(name="total")
	private int total;
	
	@Column(name="checkstatus")
	private String checkstatus;
	@Column(name="availblestatus")
	private String availablestatus;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="seller")
	private Set<Message> messages = new HashSet();


	public SellerUser() {
		checkstatus = "Initial";
		availablestatus = "Available";
		total = 0;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	

	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public String getCheckstatus() {
		return checkstatus;
	}

	public void setCheckstatus(String checkstatus) {
		this.checkstatus = checkstatus;
	}

	public String getAvailablestatus() {
		return availablestatus;
	}

	public void setAvailablestatus(String availablestatus) {
		this.availablestatus = availablestatus;
	}
	
	public Set<Message> getMessages() {
		return messages;
	}


	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	
}
