package be.odisee.jzzz.domain;

import java.util.Date;


public class Autosoort {

	private int id;
	private String merk;
	private String model;
	private int bouwjaar;
	private String kenteken;
	private double dagtarief;
	private Date createdAt;
	private Date updatedAt;
	private double prijs;
	private String type;

	public Autosoort() {}

	public Autosoort(String merk, String model, int bouwjaar) {
		this.merk = merk;
		this.model = model;
		this.bouwjaar = bouwjaar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getKenteken() {
		return kenteken;
	}

	public void setKenteken(String kenteken) {
		this.kenteken = kenteken;
	}

	public String getMerk() {
		return merk;
	}

	public void setMerk(String merk) {
		this.merk = merk;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getBouwjaar() {
		return bouwjaar;
	}

	public void setBouwjaar(int bouwjaar) {
		this.bouwjaar = bouwjaar;
	}

	public double getDagtarief() {
		return dagtarief;
	}
	public void setDagtarief(double dagtarief) {
		this.dagtarief = dagtarief;
	}
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public double getPrijs() {return prijs;
	}
	public void setPrijs(double prijs){this.prijs = prijs;}

	public String getType() { return type;
	}
	public void setType(String type){this.type = type;}
}