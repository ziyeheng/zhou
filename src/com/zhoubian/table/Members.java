package com.zhoubian.table;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Members entity. @author MyEclipse Persistence Tools
 */

public class Members implements java.io.Serializable {

	// Fields

	private String id;
	private int role_id;
	private int city;
	private int zone;
	private int provice;
	private String name;
	private String password;
	private String sex;
	private String mobel;
	private String email;
	private String tureName;
	private int isUseful;
	private String idNumber;
	private String address;
	private int isEmail;
	private int isMobel;
	private String idcardUrl;
	private Date uptime;
	private Date logintime;
	private int logincount;
	private int waitDelete;
	private int isRecognise;
	private int yongjin;
	private String bankCard;
	private String cardUrl;
	private int isCardOk;
	private String recogniseId;
	private String payPassword;
	
	public Members() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Members(String id, int roleId, int city, int zone, int provice,
			String name, String password, String sex, String mobel,
			String email, String tureName, int isUseful, String idNumber,
			String address, int isEmail, int isMobel, String idcardUrl,
			Date uptime, Date logintime, int logincount, int waitDelete,
			int isRecognise, int yongjin, String bankCard, String cardUrl,
			int isCardOk, String recogniseId, String payPassword) {
		super();
		this.id = id;
		role_id = roleId;
		this.city = city;
		this.zone = zone;
		this.provice = provice;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.mobel = mobel;
		this.email = email;
		this.tureName = tureName;
		this.isUseful = isUseful;
		this.idNumber = idNumber;
		this.address = address;
		this.isEmail = isEmail;
		this.isMobel = isMobel;
		this.idcardUrl = idcardUrl;
		this.uptime = uptime;
		this.logintime = logintime;
		this.logincount = logincount;
		this.waitDelete = waitDelete;
		this.isRecognise = isRecognise;
		this.yongjin = yongjin;
		this.bankCard = bankCard;
		this.cardUrl = cardUrl;
		this.isCardOk = isCardOk;
		this.recogniseId = recogniseId;
		this.payPassword = payPassword;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int roleId) {
		role_id = roleId;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	public int getProvice() {
		return provice;
	}

	public void setProvice(int provice) {
		this.provice = provice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobel() {
		return mobel;
	}

	public void setMobel(String mobel) {
		this.mobel = mobel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTureName() {
		return tureName;
	}

	public void setTureName(String tureName) {
		this.tureName = tureName;
	}

	public int getIsUseful() {
		return isUseful;
	}

	public void setIsUseful(int isUseful) {
		this.isUseful = isUseful;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsEmail() {
		return isEmail;
	}

	public void setIsEmail(int isEmail) {
		this.isEmail = isEmail;
	}

	public int getIsMobel() {
		return isMobel;
	}

	public void setIsMobel(int isMobel) {
		this.isMobel = isMobel;
	}

	public String getIdcardUrl() {
		return idcardUrl;
	}

	public void setIdcardUrl(String idcardUrl) {
		this.idcardUrl = idcardUrl;
	}

	public Date getUptime() {
		return uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

	public Date getLogintime() {
		return logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	public int getLogincount() {
		return logincount;
	}

	public void setLogincount(int logincount) {
		this.logincount = logincount;
	}

	public int getWaitDelete() {
		return waitDelete;
	}

	public void setWaitDelete(int waitDelete) {
		this.waitDelete = waitDelete;
	}

	public int getIsRecognise() {
		return isRecognise;
	}

	public void setIsRecognise(int isRecognise) {
		this.isRecognise = isRecognise;
	}

	public int getYongjin() {
		return yongjin;
	}

	public void setYongjin(int yongjin) {
		this.yongjin = yongjin;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getCardUrl() {
		return cardUrl;
	}

	public void setCardUrl(String cardUrl) {
		this.cardUrl = cardUrl;
	}

	public int getIsCardOk() {
		return isCardOk;
	}

	public void setIsCardOk(int isCardOk) {
		this.isCardOk = isCardOk;
	}

	public String getRecogniseId() {
		return recogniseId;
	}

	public void setRecogniseId(String recogniseId) {
		this.recogniseId = recogniseId;
	}

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	@Override
	public String toString() {
		return "Members [address=" + address + ", bankCard=" + bankCard
				+ ", cardUrl=" + cardUrl + ", city=" + city + ", email="
				+ email + ", id=" + id + ", idNumber=" + idNumber
				+ ", idcardUrl=" + idcardUrl + ", isCardOk=" + isCardOk
				+ ", isEmail=" + isEmail + ", isMobel=" + isMobel
				+ ", isRecognise=" + isRecognise + ", isUseful=" + isUseful
				+ ", logincount=" + logincount + ", logintime=" + logintime
				+ ", mobel=" + mobel + ", name=" + name + ", password="
				+ password + ", payPassword=" + payPassword + ", provice="
				+ provice + ", recogniseId=" + recogniseId + ", role_id="
				+ role_id + ", sex=" + sex + ", tureName=" + tureName
				+ ", uptime=" + uptime + ", waitDelete=" + waitDelete
				+ ", yongjin=" + yongjin + ", zone=" + zone + "]";
	}
	
}