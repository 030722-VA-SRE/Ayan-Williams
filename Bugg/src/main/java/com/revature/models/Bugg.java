package com.revature.models;

//import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class Bugg {

	//fields 
	private int id;
	private int price;
	private String kind;
	private String habitat;
	

	//constructor
	public Bugg() {
		super();
	}
	
		public Bugg(String kind, int price, String habitat) {
			this();
			this.kind = kind;
			this.price = price;
			this.habitat = habitat;
			
			
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
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	
	@Override
	public String toString() {
		return "Bugg [id=" + id + ", kind=" + kind + ", price=" + price + ", habitat=" + habitat + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(habitat, id, kind, price);
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
		return Objects.equals(habitat, other.habitat) && id == other.id && Objects.equals(kind, other.kind)
				&& price == other.price;
	}

	
	
}
