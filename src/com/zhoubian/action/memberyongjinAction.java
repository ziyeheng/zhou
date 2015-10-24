package com.zhoubian.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhoubian.dao.member_yongjinDao;
import com.zhoubian.dao.impl.member_yongjinDaoImpl;
import com.zhoubian.util.Calenda;

public class memberyongjinAction extends ActionSupport {
	
	private int myid;
	private String mymember_id;
	private int myyongjin_id;
	private int myisComplete;
	private String mystartTime;
	private String myendTime;
	private int myisDelete;
	private int myisPay;
	private String mypayTime;
	private List memberyongjinlist;
	
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
	
	public int getMyid() {
		return myid;
	}
	public void setMyid(int myid) {
		this.myid = myid;
	}
	public String getMymember_id() {
		return mymember_id;
	}
	public void setMymember_id(String mymember_id) {
		this.mymember_id = mymember_id;
	}
	public int getMyyongjin_id() {
		return myyongjin_id;
	}
	public void setMyyongjin_id(int myyongjin_id) {
		this.myyongjin_id = myyongjin_id;
	}
	public int getMyisComplete() {
		return myisComplete;
	}
	public void setMyisComplete(int myisComplete) {
		this.myisComplete = myisComplete;
	}
	public String getMystartTime() {
		return mystartTime;
	}
	public void setMystartTime(String mystartTime) {
		this.mystartTime = mystartTime;
	}
	public String getMyendTime() {
		return myendTime;
	}
	public void setMyendTime(String myendTime) {
		this.myendTime = myendTime;
	}
	public int getMyisDelete() {
		return myisDelete;
	}
	public void setMyisDelete(int myisDelete) {
		this.myisDelete = myisDelete;
	}
	public int getMyisPay() {
		return myisPay;
	}
	public void setMyisPay(int myisPay) {
		this.myisPay = myisPay;
	}
	public String getMypayTime() {
		return mypayTime;
	}
	public void setMypayTime(String mypayTime) {
		this.mypayTime = mypayTime;
	}
	public List getMemberyongjinlist() {
		return memberyongjinlist;
	}
	public void setMemberyongjinlist(List memberyongjinlist) {
		this.memberyongjinlist = memberyongjinlist;
	}
	
	private member_yongjinDao myd = new member_yongjinDaoImpl();
	
	public String getMemberYongjin() {
		if(nowpage == 0)
			nowpage = 1;
		totalpage =(myd.querymemberyongjincount()-1)/10 + 1;
		if(nowpage >= totalpage)
			nowpage = totalpage;
		memberyongjinlist = myd.queryMemberYongjin(10, nowpage);
		return "myj";
	}
	
	public void yjmyyjdm() throws IOException {
		String notice="删除成功";
		Calenda cal = new Calenda();
		if(myd.updatemyj(myid, 1))
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
