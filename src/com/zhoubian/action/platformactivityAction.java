package com.zhoubian.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhoubian.dao.platform_activityDao;
import com.zhoubian.dao.impl.platform_activityDaoImpl;
import com.zhoubian.util.Calenda;

public class platformactivityAction extends ActionSupport {

	private int paid;
	private int pacategory_id;
	private String patitle;
	private String pacontent;
	private String paimgUrl;
	private int paorder;
	private String pastratTime;
	private String paendTime;
	private String pauptime;
	private int paisDelete;
	private List platformactivitylist;
	private static int category_id;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		// System.out.println("111111111111111111" + category_id);
		this.category_id = category_id;
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

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public int getPacategory_id() {
		return pacategory_id;
	}

	public void setPacategory_id(int pacategory_id) {
		this.pacategory_id = pacategory_id;
	}

	public String getPatitle() {
		return patitle;
	}

	public void setPatitle(String patitle) {
		this.patitle = patitle;
	}

	public String getPacontent() {
		return pacontent;
	}

	public void setPacontent(String pacontent) {
		this.pacontent = pacontent;
	}

	public String getPaimgUrl() {
		return paimgUrl;
	}

	public void setPaimgUrl(String paimgUrl) {
		this.paimgUrl = paimgUrl;
	}

	public int getPaorder() {
		return paorder;
	}

	public void setPaorder(int paorder) {
		this.paorder = paorder;
	}

	public String getPastratTime() {
		return pastratTime;
	}

	public void setPastratTime(String pastratTime) {
		this.pastratTime = pastratTime;
	}

	public String getPaendTime() {
		return paendTime;
	}

	public void setPaendTime(String paendTime) {
		this.paendTime = paendTime;
	}

	public String getPauptime() {
		return pauptime;
	}

	public void setPauptime(String pauptime) {
		this.pauptime = pauptime;
	}

	public int getPaisDelete() {
		return paisDelete;
	}

	public void setPaisDelete(int paisDelete) {
		this.paisDelete = paisDelete;
	}

	public List getPlatformactivitylist() {
		return platformactivitylist;
	}

	public void setPlatformactivitylist(List platformactivitylist) {
		this.platformactivitylist = platformactivitylist;
	}

	private platform_activityDao pad = new platform_activityDaoImpl();

	public String getPlatformActivity() {
		if (nowpage == 0)
			nowpage = 1;
		totalpage = (pad.queryplatformactivitycount(2) - 1) / 10 + 1;
		if (nowpage >= totalpage)
			nowpage = totalpage;
		platformactivitylist = pad.queryPlatformActivity(10, nowpage, 2);

		System.out.println("platformactivitylist" + platformactivitylist);
		return "pa";
	}

	private List helplist;

	public List getHelplist() {
		return helplist;
	}

	public void setHelplist(List helplist) {
		this.helplist = helplist;
	}

	// 获取帮助中心的内容..应该是改为获取新手上路的内容
	// 现在改为获取四个栏目的内容
	public String getHelp() {
		// System.out.println("category_id:" + category_id);
		if (nowpage == 0)
			nowpage = 1;
		totalpage = (pad.queryplatformactivitycount(category_id) - 1) / 10 + 1;
		if (nowpage >= totalpage)
			nowpage = totalpage;
		helplist = pad.queryPlatformActivity(10, nowpage, category_id);
		return "h";
	}

	public String addPlatFormActivity() {
		return "apla";

	}

	public String upPlatFormActivity() {
		platformactivitylist = pad.queryPlatformAct(paid);
		return "upla";

	}

	public String addHelpInformation() {
		return "adh";
	}

	// 修改新手上路的信息
	public String upHelpInformation() {
		helplist = pad.queryPlatformAct(paid);
		return "uph";
	}

	public void upyjpaok() throws IOException {
		String notice = "删除成功";
		Calenda cal = new Calenda();
		if (pad.updateplatformdel(paid, 1, cal.getNowTime().toString()))
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

	public void yjaddPlatFormActivityok() throws IOException {
		String notice = "添加成功";
		Calenda cal = new Calenda();
		if (pad.addplatform(2, patitle, pacontent, "", paorder, cal
				.getNowTime().toString(), cal.getNowTime().toString(), cal
				.getNowTime().toString(), 0))
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

	public void yjupPlatFormActivityok() throws IOException {
		String notice = "修改成功";
		Calenda cal = new Calenda();
		if (pad.upplatform(paid, 2, patitle, pacontent, "", paorder, cal
				.getNowTime().toString(), cal.getNowTime().toString(), cal
				.getNowTime().toString(), 0))
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

	// 添加侧边栏的信息
	public void yjaddHelpok() throws IOException {
		String notice = "添加成功";
		Calenda cal = new Calenda();
		if (pad.addplatform(category_id, patitle, pacontent, "", paorder, cal
				.getNowTime().toString(), cal.getNowTime().toString(), cal
				.getNowTime().toString(), 0))
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

	// 修改新手上路
	public void yjupHelpok() throws IOException {
		String notice = "修改成功";
		Calenda cal = new Calenda();
		if (pad.upplatform(paid, category_id, patitle, pacontent, "", paorder,
				cal.getNowTime().toString(), cal.getNowTime().toString(), cal
						.getNowTime().toString(), 0))
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

	// 修改关于我们
	public void yjupGuanYu() throws IOException {
		String notice = "修改成功";
		Calenda cal = new Calenda();
		if (pad.upplatform(paid, 22, patitle, pacontent, "", paorder, cal
				.getNowTime().toString(), cal.getNowTime().toString(), cal
				.getNowTime().toString(), 0))
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

	// 修改常见问题
	public void yjupWenTi() throws IOException {
		String notice = "修改成功";
		Calenda cal = new Calenda();
		if (pad.upplatform(paid, 24, patitle, pacontent, "", paorder, cal
				.getNowTime().toString(), cal.getNowTime().toString(), cal
				.getNowTime().toString(), 0))
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

	// 修改服务规则
	public void yjupGuiZe() throws IOException {
		String notice = "修改成功";
		Calenda cal = new Calenda();
		if (pad.upplatform(paid, 25, patitle, pacontent, "", paorder, cal
				.getNowTime().toString(), cal.getNowTime().toString(), cal
				.getNowTime().toString(), 0))
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
