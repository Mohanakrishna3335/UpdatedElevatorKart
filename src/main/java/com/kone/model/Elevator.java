package com.kone.model;

/*
 * This class contains getter and setter methods and override the hashCode and equals method
 */
public class Elevator {
    private int eid;
    private String name;
    private int price;
    private int stock;
    private String features;
    
   public Elevator (int eid, String name, int price, int stock,String features) {
        this.eid = eid; 
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.setFeatures(features);
    }

public Elevator() {
	// TODO Auto-generated constructor stub
}

/**
 * @return the eid
 */
public int getEid() {
	return eid;
}

/**
 * @param eid the eid to set
 */
public void setEid(int eid) {
	this.eid = eid;
}

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the price
 */
public int getPrice() {
	return price;
}

/**
 * @param price the price to set
 */
public void setPrice(int price) {
	this.price = price;
}

/**
 * @return the stock
 */
public int getStock() {
	return stock;
}

/**
 * @param stock the stock to set
 */
public void setStock(int stock) {
	this.stock = stock;
}

/**
 * @return the features
 */
public String getFeatures() {
	return features;
}

/**
 * @param features the features to set
 */
public void setFeatures(String features) {
	this.features = features;
}

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + eid;
	result = prime * result + ((features == null) ? 0 : features.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + price;
	result = prime * result + stock;
	return result;
}

/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Elevator other = (Elevator) obj;
	if (eid != other.eid)
		return false;
	if (features == null) {
		if (other.features != null)
			return false;
	} else if (!features.equals(other.features))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (price != other.price)
		return false;
	if (stock != other.stock)
		return false;
	return true;
}
    
}

