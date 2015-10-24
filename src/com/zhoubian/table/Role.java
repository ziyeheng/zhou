package com.zhoubian.table;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private int id;
	private String name;
	private int state;
	private Date uptime;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String name, int state, Date uptime) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.uptime = uptime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getUptime() {
		return uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", state=" + state
				+ ", uptime=" + uptime + "]";
	}
	
	
}