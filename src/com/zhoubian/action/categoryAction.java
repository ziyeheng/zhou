package com.zhoubian.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhoubian.dao.categoryDao;
import com.zhoubian.dao.impl.categoryDaoImpl;
import com.zhoubian.util.Calenda;

public class categoryAction extends ActionSupport {
	
	private int cid;
	private String cname;
	private int cmodul;
	private int ctype;
	private int corder;
	private int cstate;
	private String cpicUrl;
	private String ccontent;
	private int cisDelete;
	private List categorylist;
	
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
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCmodul() {
		return cmodul;
	}
	public void setCmodul(int cmodul) {
		this.cmodul = cmodul;
	}
	public int getCtype() {
		return ctype;
	}
	public void setCtype(int ctype) {
		this.ctype = ctype;
	}
	public int getCorder() {
		return corder;
	}
	public void setCorder(int corder) {
		this.corder = corder;
	}
	public int getCstate() {
		return cstate;
	}
	public void setCstate(int cstate) {
		this.cstate = cstate;
	}
	public String getCpicUrl() {
		return cpicUrl;
	}
	public void setCpicUrl(String cpicUrl) {
		this.cpicUrl = cpicUrl;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public int getCisDelete() {
		return cisDelete;
	}
	public void setCisDelete(int cisDelete) {
		this.cisDelete = cisDelete;
	}
	public List getCategorylist() {
		return categorylist;
	}
	public void setCategorylist(List categorylist) {
		this.categorylist = categorylist;
	}
	
	private categoryDao cd = new categoryDaoImpl();
	
	public String getCategory() {
		if(nowpage == 0)
			nowpage = 1;
		totalpage =(cd.querycategorycount()-1)/10 + 1;
		if(nowpage >= totalpage)
			nowpage = totalpage;
		categorylist = cd.queryallcategory(10, nowpage);
		return "c";
	}
	
	public String addCategory() {
		return "ac";
	}
	
	//添加大分类
	public void addCategoryok() throws IOException {
		String notice="添加成功";
		if(corder==0)
			corder=10000;
		Calenda cal = new Calenda();
		if(cd.saveCategory(cname, 3, 0, corder, 1, "", "",cal.getNowTime().toString(), 0))
			notice="添加成功";
		else
			notice="添加失败";
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
	
	public String upCategory() {
		categorylist = cd.queryCategory(cid);
		return "uc";
	}
	//修改大分类
	public void upCategoryok() throws IOException {
		String notice="修改成功";
		if(corder==0)
			corder=10000;
		Calenda cal = new Calenda();
		if(cd.upCategory(cid,cname, 3, 0, corder, 1, "", "",cal.getNowTime().toString(), 0))
			notice="修改成功";
		else
			notice="修改失败";
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
	
	//删除大分类
	public void delCategoryok() throws IOException {
		String notice="删除成功";
		Calenda cal = new Calenda();
		if(cd.delCategory(cid,cal.getNowTime().toString(), 1))
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
	
	public String addCat() {
		return "addc";
	}
	
	public void addAllCategoryok() throws IOException {
		String notice="添加成功";
		if(corder==0)
			corder=10000;
		Calenda cal = new Calenda();
		if(cd.saveCategory(cname, cmodul, ctype, corder, 1, "", ccontent,cal.getNowTime().toString(), 0))
			notice="添加成功";
		else
			notice="添加失败";
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
	
	public String upCat() {
		categorylist = cd.queryCategory(cid);
		return "upc";
	}
	
	public void upAllCategoryok() throws IOException {
		String notice="修改成功";
		if(corder==0)
			corder=10000;
		Calenda cal = new Calenda();
		if(cd.upCategoryAll(cid,cname, cmodul, ctype, corder, 1, "", ccontent,cal.getNowTime().toString(), 0))
			notice="修改成功";
		else
			notice="修改失败";
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
