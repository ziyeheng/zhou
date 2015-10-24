package com.zhoubian.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhoubian.dao.member_informationDao;
import com.zhoubian.dao.impl.member_informationDaoImpl;

public class memberinformationAction extends ActionSupport {
	
	private Long miid;
	private String mimembers;
	private int minewInformation;
	private String micommentContent;
	private int miisZan;
	private int miisRescend;
	private String micommentTime;
	private List memberinformationlist;
	
	private int nowpage;
	private int totalpage;
	
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	
	public Long getMiid() {
		return miid;
	}
	public void setMiid(Long miid) {
		this.miid = miid;
	}
	public String getMimembers() {
		return mimembers;
	}
	public void setMimembers(String mimembers) {
		this.mimembers = mimembers;
	}
	public int getMinewInformation() {
		return minewInformation;
	}
	public void setMinewInformation(int minewInformation) {
		this.minewInformation = minewInformation;
	}
	public String getMicommentContent() {
		return micommentContent;
	}
	public void setMicommentContent(String micommentContent) {
		this.micommentContent = micommentContent;
	}
	public int getMiisZan() {
		return miisZan;
	}
	public void setMiisZan(int miisZan) {
		this.miisZan = miisZan;
	}
	public int getMiisRescend() {
		return miisRescend;
	}
	public void setMiisRescend(int miisRescend) {
		this.miisRescend = miisRescend;
	}
	public String getMicommentTime() {
		return micommentTime;
	}
	public void setMicommentTime(String micommentTime) {
		this.micommentTime = micommentTime;
	}
	public List getMemberinformationlist() {
		return memberinformationlist;
	}
	public void setMemberinformationlist(List memberinformationlist) {
		this.memberinformationlist = memberinformationlist;
	}
	
	private member_informationDao mid = new member_informationDaoImpl();
	
	public String getMemberInformation() {
		if(nowpage == 0)
			nowpage = 1;
		totalpage =(mid.querycountMember() -1)/10 + 1;
		if(nowpage >= totalpage)
			nowpage = totalpage;
		memberinformationlist = mid.queryMeberInformation(10, nowpage);
		return  "mi";
	}
	
	public void yjmid() throws IOException {
		String notice="删除成功";
		if(mid.updateMId(Integer.parseInt(miid.toString()), 1))
			notice="删除成功";
		else
			notice="删除失败";
		JSONObject object = new JSONObject();
		//object.element("loginlist", JSONArray.fromObject(loginlist));
		object.element("notice", notice);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}

}
