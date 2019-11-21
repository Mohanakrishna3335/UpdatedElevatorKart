package com.kone.model;

/*
 * This class contains getter and setter methods and override the hashCode and equals method
 */
public class Elevator {
	private int eno;
	private String name;
	private int price;
	private int stock;
	private String features;
	private String etype;

	public Elevator(int eno, String name, int price, int stock, String features, String etype) {
		this.eno = eno;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.features = features;
		this.etype = etype;
		// this.setFeatures(features);
	}

	public Elevator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the eid
	 */
	public int getEno() {
		return eno;
	}

	/**
	 * @param eid
	 *            the eid to set
	 */
	public void setEno(int eno) {
		this.eno = eno;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
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
	 * @param price
	 *            the price to set
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
	 * @return the etype
	 */
	public String getEtype() {
		return etype;
	}

	/**
	 * @param etype
	 *            the etype to set
	 */
	public void setEtype(String etype) {
		this.etype = etype;
	}

	/**
	 * @param stock
	 *            the stock to set
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
	 * @param features
	 *            the features to set
	 */
	public void setFeatures(String features) {
		this.features = features;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eno;
		result = prime * result + ((etype == null) ? 0 : etype.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + stock;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		if (eno != other.eno)
			return false;
		if (etype == null) {
			if (other.etype != null)
				return false;
		} else if (!etype.equals(other.etype))
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
