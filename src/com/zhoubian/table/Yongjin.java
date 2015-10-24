package com.zhoubian.table;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Yongjin entity. @author MyEclipse Persistence Tools
 */

public class Yongjin implements java.io.Serializable {

	// Fields

	private Long id;
	private int city;
	private String member_id;
	private int first_mcid;
	private int zone;
	private int second_mcid;
	private int province;
	private int price;
	private int yj;
	private String mobel;
	private int isOk;
	private int isReceive;
	private Date startTime;
	private Date endDate;
	private Date upTime;
	private String guige;
	private String caizhi;
	private String longitude;
	private String latitude;
	private int isDelete;
	private String imgUrl;
	
	public Yongjin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Yongjin(Long id, int city, String memberId, int firstMcid, int zone,
			int secondMcid, int province, int price, int yj, String mobel,
			int isOk, int isReceive, Date startTime, Date endDate, Date upTime,
			String guige, String caizhi, String longitude, String latitude,
			int isDelete, String imgUrl) {
		super();
		this.id = id;
		this.city = city;
		member_id = memberId;
		first_mcid = firstMcid;
		this.zone = zone;
		second_mcid = secondMcid;
		this.province = province;
		this.price = price;
		this.yj = yj;
		this.mobel = mobel;
		this.isOk = isOk;
		this.isReceive = isReceive;
		this.startTime = startTime;
		this.endDate = endDate;
		this.upTime = upTime;
		this.guige = guige;
		this.caizhi = caizhi;
		this.longitude = longitude;
		this.latitude = latitude;
		this.isDelete = isDelete;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String memberId) {
		member_id = memberId;
	}

	public int getFirst_mcid() {
		return first_mcid;
	}

	public void setFirst_mcid(int firstMcid) {
		first_mcid = firstMcid;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	public int getSecond_mcid() {
		return second_mcid;
	}

	public void setSecond_mcid(int secondMcid) {
		second_mcid = secondMcid;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYj() {
		return yj;
	}

	public void setYj(int yj) {
		this.yj = yj;
	}

	public String getMobel() {
		return mobel;
	}

	public void setMobel(String mobel) {
		this.mobel = mobel;
	}

	public int getIsOk() {
		return isOk;
	}

	public void setIsOk(int isOk) {
		this.isOk = isOk;
	}

	public int getIsReceive() {
		return isReceive;
	}

	public void setIsReceive(int isReceive) {
		this.isReceive = isReceive;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	public String getCaizhi() {
		return caizhi;
	}

	public void setCaizhi(String caizhi) {
		this.caizhi = caizhi;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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
		return "Yongjin [caizhi=" + caizhi + ", city=" + city + ", endDate="
				+ endDate + ", first_mcid=" + first_mcid + ", guige=" + guige
				+ ", id=" + id + ", imgUrl=" + imgUrl + ", isDelete="
				+ isDelete + ", isOk=" + isOk + ", isReceive=" + isReceive
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", member_id=" + member_id + ", mobel=" + mobel + ", price="
				+ price + ", province=" + province + ", second_mcid="
				+ second_mcid + ", startTime=" + startTime + ", upTime="
				+ upTime + ", yj=" + yj + ", zone=" + zone + "]";
	}
	
}