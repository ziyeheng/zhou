package com.zhoubian.table;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ModulCategory entity. @author MyEclipse Persistence Tools
 */

public class ModulCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private int category_id;
	private String name;
	private int type;
	private int order;
	private Date uptime;
	private int isDelete;
	
	public ModulCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModulCategory(Integer id, int categoryId, String name, int type,
			int order, Date uptime, int isDelete) {
		super();
		this.id = id;
		category_id = categoryId;
		this.name = name;
		this.type = type;
		this.order = order;
		this.uptime = uptime;
		this.isDelete = isDelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int categoryId) {
		category_id = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Date getUptime() {
		return uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "ModulCategory [category_id=" + category_id + ", id=" + id
				+ ", isDelete=" + isDelete + ", name=" + name + ", order="
				+ order + ", type=" + type + ", uptime=" + uptime + "]";
	}
	
	
	}