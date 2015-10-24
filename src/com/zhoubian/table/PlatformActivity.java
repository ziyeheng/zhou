package com.zhoubian.table;

import java.sql.Timestamp;
import java.util.Date;

/**
 * PlatformActivity entity. @author MyEclipse Persistence Tools
 */

public class PlatformActivity implements java.io.Serializable {

	// Fields

	private int id;
	private int category_id;
	private String title;
	private String content;
	private String imgUrl;
	private int order;
	private Date stratTime;
	private Date endTime;
	private Date uptime;
	private int isDelete;
	
	public PlatformActivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlatformActivity(int id, int categoryId, String title,
			String content, String imgUrl, int order, Date stratTime,
			Date endTime, Date uptime, int isDelete) {
		super();
		this.id = id;
		category_id = categoryId;
		this.title = title;
		this.content = content;
		this.imgUrl = imgUrl;
		this.order = order;
		this.stratTime = stratTime;
		this.endTime = endTime;
		this.uptime = uptime;
		this.isDelete = isDelete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int categoryId) {
		category_id = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Date getStratTime() {
		return stratTime;
	}

	public void setStratTime(Date stratTime) {
		this.stratTime = stratTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
		return "PlatformActivity [category_id=" + category_id + ", content="
				+ content + ", endTime=" + endTime + ", id=" + id + ", imgUrl="
				+ imgUrl + ", isDelete=" + isDelete + ", order=" + order
				+ ", stratTime=" + stratTime + ", title=" + title + ", uptime="
				+ uptime + "]";
	}

    
}