package com.zhoubian.table;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * NewInformation entity. @author MyEclipse Persistence Tools
 */

public class NewInformation implements java.io.Serializable {

	// Fields

	private int id;
	private String member_id;
	private int category_id;
	private String content;
	private Date uptime;
	private int type;
	private int zanCount;
	private int resendCount;
	private int commentCount;
	private int seeCount;
	private int isDelete;
	private String imgUrl;
	
	public NewInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewInformation(int id, String memberId, int categoryId,
			String content, Date uptime, int type, int zanCount,
			int resendCount, int commentCount, int seeCount, int isDelete,
			String imgUrl) {
		super();
		this.id = id;
		member_id = memberId;
		category_id = categoryId;
		this.content = content;
		this.uptime = uptime;
		this.type = type;
		this.zanCount = zanCount;
		this.resendCount = resendCount;
		this.commentCount = commentCount;
		this.seeCount = seeCount;
		this.isDelete = isDelete;
		this.imgUrl = imgUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String memberId) {
		member_id = memberId;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int categoryId) {
		category_id = categoryId;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getZanCount() {
		return zanCount;
	}

	public void setZanCount(int zanCount) {
		this.zanCount = zanCount;
	}

	public int getResendCount() {
		return resendCount;
	}

	public void setResendCount(int resendCount) {
		this.resendCount = resendCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getSeeCount() {
		return seeCount;
	}

	public void setSeeCount(int seeCount) {
		this.seeCount = seeCount;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "NewInformation [category_id=" + category_id + ", commentCount="
				+ commentCount + ", content=" + content + ", id=" + id
				+ ", imgUrl=" + imgUrl + ", isDelete=" + isDelete
				+ ", member_id=" + member_id + ", resendCount=" + resendCount
				+ ", seeCount=" + seeCount + ", type=" + type + ", uptime="
				+ uptime + ", zanCount=" + zanCount + "]";
	}

	
}