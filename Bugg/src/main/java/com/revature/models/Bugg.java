package com.revature.models;

import java.util.Objects;

public class Bugg {

	//fields 
	private int id;
	private int price;
	private String fam;
	private String kind;
	private String hab;
	

	//constructor
	public Bugg() {
		super();
	}
	
	//getters & setters
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getHab() {
		return hab;
	}
	public void setHab(String hab) {
		this.hab = hab;
	}
	
	public String getFam() {
		return fam;
	}
	public void setFam(String fam) {
		this.fam = fam;
	}
	
	@Override
	public String toString() {
		return "Bugg [id=" + id + ", kind=" + kind + ", price=" + price + ", hab=" + hab + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hab, id, kind, price);
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
		return Objects.equals(hab, other.hab) && id == other.id && Objects.equals(kind, other.kind)
				&& price == other.price;
	}

	

	
	
}
