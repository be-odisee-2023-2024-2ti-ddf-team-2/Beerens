package be.odisee.jzzz.domain;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Factuur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private Date factuurdatum;
	private double bedrag;
	private boolean betaald;
	private Date updatedDate;

	public Factuur(Date datum, double bedrag) {
		this.factuurdatum = datum;
		this.bedrag = bedrag;
	}

	public Factuur() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFactuurdatum() {
		return factuurdatum;
	}

	public void setFactuurdatum(Date datum) {
		this.factuurdatum = datum;
	}

	public double getBedrag() {
		return bedrag;
	}

	public void setBedrag(double bedrag) {
		this.bedrag = bedrag;
	}

	public boolean isBetaald() {
		return betaald;
	}

	public void setBetaald(boolean betaald) {
		this.betaald = betaald;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@PrePersist
	protected void onCreate() {
		if (factuurdatum == null) {
			factuurdatum = new Date();
		}
		updatedDate = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		updatedDate = new Date();
	}
}
