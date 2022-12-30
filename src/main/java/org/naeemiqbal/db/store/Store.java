package org.naeemiqbal.db.store;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.jboss.logging.Logger;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long storeID;
	private String storeCode;
	private String storeName;
	private String location;
	private long capacity;
	private Date created;
	
	Logger LOG = Logger.getLogger(getClass());
	
	public Store() {
		super();
		this.created = new Date();
	}	
	
	public Store(String storeCode, String storeName, String location, long capacity) {
		super();
		this.storeCode = storeCode;
		this.storeName = storeName;
		this.location = location;
		this.capacity = capacity;
		this.created = new Date();
	}

	public long getStoreID() {
		return storeID;
	}
	public void setStoreID(long storeID) {
		this.storeID = storeID;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		if (created!=null && this.created==null)
			this.created = created;
		else
			LOG.warn("Prevented update of created to null");			
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
}
