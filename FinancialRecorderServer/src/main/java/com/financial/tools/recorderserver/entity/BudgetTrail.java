package com.financial.tools.recorderserver.entity;

import java.io.Serializable;
import java.util.Date;

public class BudgetTrail implements Serializable {

	private static final long serialVersionUID = -176942430634908634L;

	private String userName;

	private String type;

	private Date createdTime;

	private float amount;

	public BudgetTrail() {

	}

	public BudgetTrail(String userName, String type, Date createdTime, float amount) {
		super();
		this.userName = userName;
		this.type = type;
		this.createdTime = createdTime;
		this.amount = amount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
