package com.zhoubian.table;

import java.sql.Timestamp;
import java.util.Date;

/**
 * MemberInformation entity. @author MyEclipse Persistence Tools
 */

public class MemberInformation implements java.io.Serializable {

	// Fields

	private Long id;
	private String members;
	private int newInformation;
	private String commentContent;
	private int isZan;
	private int isRescend;
	private Date commentTime;
	
	public MemberInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberInformation(Long id, String members, int newInformation,
			String commentContent, int isZan, int isRescend, Date commentTime) {
		super();
		this.id = id;
		this.members = members;
		this.newInformation = newInformation;
		this.commentContent = commentContent;
		this.isZan = isZan;
		this.isRescend = isRescend;
		this.commentTime = commentTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public int getNewInformation() {
		return newInformation;
	}

	public void setNewInformation(int newInformation) {
		this.newInformation = newInformation;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getIsZan() {
		return isZan;
	}

	public void setIsZan(int isZan) {
		this.isZan = isZan;
	}

	public int getIsRescend() {
		return isRescend;
	}

	public void setIsRescend(int isRescend) {
		this.isRescend = isRescend;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	@Override
	public String toString() {
		return "MemberInformation [commentContent=" + commentContent
				+ ", commentTime=" + commentTime + ", id=" + id
				+ ", isRescend=" + isRescend + ", isZan=" + isZan
				+ ", members=" + members + ", newInformation=" + newInformation
				+ "]";
	}

}