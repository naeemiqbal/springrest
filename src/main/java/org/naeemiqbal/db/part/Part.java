package org.naeemiqbal.db.part;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Part {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long partId;
	
	private String partCode;
	private String partName;
	private String partDesc;
	private Double price;
	private Date created;
	public Long getPartId() {
		return partId;
	}
	public void setPartId(Long partId) {
		this.partId = partId;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartDesc() {
		return partDesc;
	}
	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Part() {
		super();
		this.created= new Date();
	}
	public Part(String partCode, String partName, String partDesc, Double price) {
		super();
		this.partCode = partCode;
		this.partName = partName;
		this.partDesc = partDesc;
		this.price = price;
		this.created= new Date();
	}

	
	
	
	
	
}
