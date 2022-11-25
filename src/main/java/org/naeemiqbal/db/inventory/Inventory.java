package org.naeemiqbal.db.inventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	Long invId;
	
	private String partCode;
	private String storeCode;
	private Long count;
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getInvId() {
		return invId;
	}
	public void setInvId(Long invId) {
		this.invId = invId;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Inventory(String partCode, String storeCode, Long count) {
		super();
		this.partCode = partCode;
		this.storeCode = storeCode;
		this.count = count;
	}	
}
