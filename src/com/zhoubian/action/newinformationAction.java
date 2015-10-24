package com.zhoubian.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhoubian.dao.new_informationDao;
import com.zhoubian.dao.impl.new_informationDaoImpl;
import com.zhoubian.util.Calenda;

public class newinformationAction extends ActionSupport {

	private int niid;
	private String nimember_id;
	private int nicategory_id;
	private String nicontent;
	private String niuptime;
	private int nitype;
	private int nizanCount;
	private int niresendCount;
	private int nicommentCount;
	private int niseeCount;
	private int niisDelete;
	private String niimgUrl;
	private List newinformationlist;

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

	public int getNiid() {
		return niid;
	}

	public void setNiid(int niid) {
		this.niid = niid;
	}

	public String getNimember_id() {
		return nimember_id;
	}

	public void setNimember_id(String nimember_id) {
		this.nimember_id = nimember_id;
	}

	public int getNicategory_id() {
		return nicategory_id;
	}

	public void setNicategory_id(int nicategory_id) {
		this.nicategory_id = nicategory_id;
	}

	public String getNicontent() {
		return nicontent;
	}

	public void setNicontent(String nicontent) {
		this.nicontent = nicontent;
	}

	public String getNiuptime() {
		return niuptime;
	}

	public void setNiuptime(String niuptime) {
		this.niuptime = niuptime;
	}

	public int getNitype() {
		return nitype;
	}

	public void setNitype(int nitype) {
		this.nitype = nitype;
	}

	public int getNizanCount() {
		return nizanCount;
	}

	public void setNizanCount(int nizanCount) {
		this.nizanCount = nizanCount;
	}

	public int getNiresendCount() {
		return niresendCount;
	}

	public void setNiresendCount(int niresendCount) {
		this.niresendCount = niresendCount;
	}

	public int getNicommentCount() {
		return nicommentCount;
	}

	public void setNicommentCount(int nicommentCount) {
		this.nicommentCount = nicommentCount;
	}

	public int getNiseeCount() {
		return niseeCount;
	}

	public void setNiseeCount(int niseeCount) {
		this.niseeCount = niseeCount;
	}

	public int getNiisDelete() {
		return niisDelete;
	}

	public void setNiisDelete(int niisDelete) {
		this.niisDelete = niisDelete;
	}

	public String getNiimgUrl() {
		return niimgUrl;
	}

	public void setNiimgUrl(String niimgUrl) {
		this.niimgUrl = niimgUrl;
	}

	public List getNewinformationlist() {
		return newinformationlist;
	}

	public void setNewinformationlist(List newinformationlist) {
		this.newinformationlist = newinformationlist;
	}

	private new_informationDao nid = new new_informationDaoImpl();

	// 获取反馈信息
	public String getNewInformation() {
		if (nowpage == 0)
			nowpage = 1;
		totalpage = (nid.querynewinformationcount() - 1) / 10 + 1;

		// System.out.println("totalpage" + totalpage + "***"
		//		+ nid.querynewinformationcount());

		if (nowpage >= totalpage)
			nowpage = totalpage;
		newinformationlist = nid.queryNewInformation(10, nowpage);
		return "ni";
	}

	// 删除反馈信息
	public void upyjnidm() throws IOException {
		String notice = "删除成功";
		Calenda cal = new Calenda();
		if (nid.upnidel(niid, 1, cal.getNowTime().toString()))
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

}
