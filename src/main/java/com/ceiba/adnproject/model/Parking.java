package com.ceiba.adnproject.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "Parking")
public class Parking implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MAX_CARS = 20;
	public static final int MAX_MOTORCYCLES = 10;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_parking", unique = true, nullable = false)
	private int idParking;

	@Column(name = "status", nullable = false)
	private boolean status;

	@Column(name = "type", nullable = false)
	private String type;

	@Column(name = "dateIn", nullable = false, length = 500)
	private Date dateIn;

	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true,orphanRemoval = true)
	@JoinColumn(name = "id_vehicle",nullable =false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Vehicle vehicle;

	public Parking() {
		super();
	}

	public Parking(boolean status, String type, Vehicle vehicle) {
		super();
		this.status = status;
		this.type = type;
		this.dateIn = new Date();
		this.vehicle = vehicle;
	}

	public int getIdParking() {
		return idParking;
	}

	public void setIdParking(int idParking) {
		this.idParking = idParking;
	}

	public boolean isStatus() {
		return status;
	}

	public String getType() {
		return type;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

}
