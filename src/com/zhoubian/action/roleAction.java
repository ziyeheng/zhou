package com.zhoubian.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhoubian.dao.roleDao;
import com.zhoubian.dao.impl.roleDaoImpy;
import com.zhoubian.util.Calenda;

public class roleAction extends ActionSupport {

	private int rid;
	private String rname;
	private int rstate;
	private String ruptime;
	private List rolelist;
	private String maxnum;

	public String getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(String maxnum) {
		this.maxnum = maxnum;
	}

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

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public int getRstate() {
		return rstate;
	}

	public void setRstate(int rstate) {
		this.rstate = rstate;
	}

	public String getRuptime() {
		return ruptime;
	}

	public void setRuptime(String ruptime) {
		this.ruptime = ruptime;
	}

	public List getRolelist() {
		return rolelist;
	}

	public void setRolelist(List rolelist) {
		this.rolelist = rolelist;
	}

	private roleDao rd = new roleDaoImpy();

	public String getRole() {
		if (nowpage == 0)
			nowpage = 1;
		totalpage = (rd.queryrolecount() - 1) / 10 + 1;
		if (nowpage >= totalpage)
			nowpage = totalpage;
		rolelist = rd.queryrole(10, nowpage);
		return "r";
	}

	public String addRole() {
		return "ar";
	}

	public String upRole() {
		rolelist = rd.queryRole(rid);
		return "ur";
	}

	// 获取最大发放红包数
	public String getredmaxnum() {

		maxnum = rd.getredmaxnum();

		return "max";
	}

	public void upyjrd() throws IOException {
		String notice = "删除成功";
		Calenda cal = new Calenda();
		if (rd.updaterolestate(rid, 0, cal.getNowTime().toString()))
			notice = "删除成功";
		else
			notice = "删除失败";
		JSONObject object = new JSONObject();
		// object.element("loginlist", JSONArray.fromObject(loginlist));
		object.element("notice", notice);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}

	// 修改最大抢红包数
	public void upmaxnum() throws IOException {

		String notice = "修改成功";
		Calenda cal = new Calenda();
		// System.out.println("maxnum1"+maxnum);
		if (rd.updatemaxnum(maxnum))
			notice = "修改成功";
		else
			notice = "修改失败";
		JSONObject object = new JSONObject();
		object.element("notice", notice);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}

	public void upyjrok() throws IOException {
		String notice = "启用成功";
		Calenda cal = new Calenda();
		if (rd.updaterolestate(rid, 1, cal.getNowTime().toString()))
			notice = "启用成功";
		else
			notice = "启用失败";
		JSONObject object = new JSONObject();
		// object.element("loginlist", JSONArray.fromObject(loginlist));
		object.element("notice", notice);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}

	public void addRoleok() throws IOException {
		String notice = "添加成功";
		Calenda cal = new Calenda();
		if (rd.addrole(rname, cal.getNowTime().toString()))
			notice = "添加成功";
		else
			notice = "添加失败";
		JSONObject object = new JSONObject();
		// object.element("loginlist", JSONArray.fromObject(loginlist));
		object.element("notice", notice);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}

	public void upRoleok() throws IOException {
		String notice = "修改成功";
		Calenda cal = new Calenda();
		if (rd.uprole(rid, rname, cal.getNowTime().toString()))
			notice = "修改成功";
		else
			notice = "修改失败";
		JSONObject object = new JSONObject();
		// object.element("loginlist", JSONArray.fromObject(loginlist));
		object.element("notice", notice);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}
}
