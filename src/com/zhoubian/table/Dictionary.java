package com.zhoubian.table;

import java.util.HashSet;
import java.util.Set;

/**
 * Dictionary entity. @author MyEclipse Persistence Tools
 */

public class Dictionary implements java.io.Serializable {

	// Fields

	private int id;
	private String name;
	private int code;
	private int order;
	
	public Dictionary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dictionary(int id, String name, int code, int order) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.order = order;
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Dictionary [code=" + code + ", id=" + id + ", name=" + name
				+ ", order=" + order + "]";
	}
	
}