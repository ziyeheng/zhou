package com.zhoubian.table;

import java.sql.Timestamp;
import java.util.Date;

/**
 * MemberYongjin entity. @author MyEclipse Persistence Tools
 */

public class MemberYongjin implements java.io.Serializable {

	// Fields

	private int id;
	private String member_id;
	private int yongjin_id;
	private int isComplete;
	private Date startTime;
	private String endTime;
	private int isDelete;
	private int isPay;
	private Date payTime;
	
	public MemberYongjin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberYongjin(int id, String memberId, int yongjinId,
			int isComplete, Date startTime, String endTime, int isDelete,
			int isPay, Date payTime) {
		super();
		this.id = id;
		member_id = memberId;
		yongjin_id = yongjinId;
		this.isComplete = isComplete;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isDelete = isDelete;
		this.isPay = isPay;
		this.payTime = payTime;
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

	public int getYongjin_id() {
		return yongjin_id;
	}

	public void setYongjin_id(int yongjinId) {
		yongjin_id = yongjinId;
	}

	public int getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(int isComplete) {
		this.isComplete = isComplete;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getIsPay() {
		return isPay;
	}

	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	@Override
	public String toString() {
		return "MemberYongjin [endTime=" + endTime + ", id=" + id
				+ ", isComplete=" + isComplete + ", isDelete=" + isDelete
				+ ", isPay=" + isPay + ", member_id=" + member_id
				+ ", payTime=" + payTime + ", startTime=" + startTime
				+ ", yongjin_id=" + yongjin_id + "]";
	}
	
	
}