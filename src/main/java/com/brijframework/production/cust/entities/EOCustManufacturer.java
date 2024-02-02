package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.BRAND;
import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.EOCUST_MANUFACTURER;
import static com.brijframework.production.contants.Constants.GTIN;
import static com.brijframework.production.contants.Constants.MPN;
import static com.brijframework.production.contants.Constants.NAME;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.brijframework.production.entities.EOEntityObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_MANUFACTURER, uniqueConstraints = { @UniqueConstraint(columnNames = { NAME }) })
public class EOCustManufacturer extends EOEntityObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = BRAND)
	private String brand;

	@Column(name = GTIN)
	private String gtin; // Global Trade Item Number (GTIN) of the item

	@Column(name = MPN)
	private String mpn; // Manufacturer Part Number (MPN) of the item

	@Column(name = NAME)
	private String name;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGtin() {
		return gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	public String getMpn() {
		return mpn;
	}

	public void setMpn(String mpn) {
		this.mpn = mpn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
