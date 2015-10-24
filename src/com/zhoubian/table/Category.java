package com.zhoubian.table;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private int id;
	private String name;
	private int modul;
	private int type;
	private int order;
	private int state;
	private String picUrl;
	private String content;
	private Date uptime;
	private int isDelete;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, int modul, int type, int order,
			int state, String picUrl, String content, Date uptime, int isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.modul = modul;
		this.type = type;
		this.order = order;
		this.state = state;
		this.picUrl = picUrl;
		this.content = content;
		this.uptime = uptime;
		this.isDelete = isDelete;
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

	public int getModul() {
		return modul;
	}

	public void setModul(int modul) {
		this.modul = modul;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "Category [content=" + content + ", id=" + id + ", isDelete="
				+ isDelete + ", modul=" + modul + ", name=" + name + ", order="
				+ order + ", picUrl=" + picUrl + ", state=" + state + ", type="
				+ type + ", uptime=" + uptime + "]";
	}
	
}