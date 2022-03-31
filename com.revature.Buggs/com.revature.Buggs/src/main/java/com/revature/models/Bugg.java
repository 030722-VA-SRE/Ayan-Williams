package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "buggs")
public class Bugg {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String kind;
	
	@Column
	private String fam;
	
	@Column
	private String hab;
	
	@Column (name = "mlevel")
	private String mlevel;
	
	@Column
	private int price;
	
	@Column
	private String unit;
	
	@Column
	private boolean islegal;
	
	@Column
	private boolean needpermit;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "seller_id")
	private User seller;

	//REFACTOR HAB & mLEVEL TO BE ENUMS
	//RESEARCH @ ANNOTATINOS TO USE
	
	
	public Bugg() {
		super();

	}


	public int getid() {
		return id;
	}


	public void setid(int id) {
		this.id = id;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getFam() {
		return fam;
	}


	public void setFam(String fam) {
		this.fam = fam;
	}


	public String getHab() {
		return hab;
	}


	public void setHab(String hab) {
		this.hab = hab;
	}


	public String getmLevel() {
		return mlevel;
	}


	public void setmLevel(String mLevel) {
		this.mlevel = mLevel;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public boolean isIslegal() {
		return islegal;
	}


	public void setIslegal(boolean islegal) {
		this.islegal = islegal;
	}


	public boolean isNeedpermit() {
		return needpermit;
	}


	public void setNeedpermit(boolean needpermit) {
		this.needpermit = needpermit;
	}


	public User getSeller() {
		return seller;
	}


	public void setSeller(User seller) {
		this.seller = seller;
	}


	@Override
	public int hashCode() {
		return Objects.hash(fam, hab, id, islegal, kind, mlevel, needpermit, price, seller, unit);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bugg other = (Bugg) obj;
		return Objects.equals(fam, other.fam) && Objects.equals(hab, other.hab) && id == other.id
				&& islegal == other.islegal && Objects.equals(kind, other.kind) && Objects.equals(mlevel, other.mlevel)
				&& needpermit == other.needpermit && price == other.price && Objects.equals(seller, other.seller)
				&& Objects.equals(unit, other.unit);
	}


	@Override
	public String toString() {
		return "Bugg [id=" + id + ", kind=" + kind + ", fam=" + fam + ", hab=" + hab + ", mlevel=" + mlevel + ", price="
				+ price + ", unit=" + unit + ", islegal=" + islegal + ", needpermit=" + needpermit + ", seller="
				+ seller + "]";
	}






	}


	


	