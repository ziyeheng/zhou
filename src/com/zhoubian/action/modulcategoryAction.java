package com.zhoubian.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhoubian.dao.categoryDao;
import com.zhoubian.dao.modul_categoryDao;
import com.zhoubian.dao.impl.categoryDaoImpl;
import com.zhoubian.dao.impl.modul_categoryDaoImpl;
import com.zhoubian.util.Calenda;

public class modulcategoryAction extends ActionSupport {

	private Integer mcid;
	private int mccategory_id;
	private String mcname;
	private int mctype;
	private int mcorder;
	private String mcuptime;
	private int mcisDelete;
	private List modulcategorylist;

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

	public Integer getMcid() {
		return mcid;
	}

	public void setMcid(Integer mcid) {
		this.mcid = mcid;
	}

	public int getMccategory_id() {
		return mccategory_id;
	}

	public void setMccategory_id(int mccategory_id) {
		this.mccategory_id = mccategory_id;
	}

	public String getMcname() {
		return mcname;
	}

	public void setMcname(String mcname) {
		this.mcname = mcname;
	}

	public int getMctype() {
		return mctype;
	}

	public void setMctype(int mctype) {
		this.mctype = mctype;
	}

	public int getMcorder() {
		return mcorder;
	}

	public void setMcorder(int mcorder) {
		this.mcorder = mcorder;
	}

	public String getMcuptime() {
		return mcuptime;
	}

	public void setMcuptime(String mcuptime) {
		this.mcuptime = mcuptime;
	}

	public int getMcisDelete() {
		return mcisDelete;
	}

	public void setMcisDelete(int mcisDelete) {
		this.mcisDelete = mcisDelete;
	}

	public List getModulcategorylist() {
		return modulcategorylist;
	}

	public void setModulcategorylist(List modulcategorylist) {
		this.modulcategorylist = modulcategorylist;
	}

	private List clist;

	public List getClist() {
		return clist;
	}

	public void setClist(List clist) {
		this.clist = clist;
	}

	private modul_categoryDao mcd = new modul_categoryDaoImpl();
	private categoryDao cd = new categoryDaoImpl();

	public String getModulCategory() {
		clist = cd.querybottom();
		return "mc";
	}

	private List fisrtclist;

	public List getFisrtclist() {
		return fisrtclist;
	}

	public void setFisrtclist(List fisrtclist) {
		this.fisrtclist = fisrtclist;
	}

	private int cid;
	private int tp;

	public int getTp() {
		return tp;
	}

	public void setTp(int tp) {
		this.tp = tp;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getFirstModulCategory() {
		if (nowpage == 0)
			nowpage = 1;
		totalpage = (mcd.querymodulecategorycount(cid, tp) - 1) / 10 + 1;

		// System.out.println("count:" + mcd.querymodulecategorycount(cid, tp));

		if (nowpage >= totalpage)
			nowpage = totalpage;
		fisrtclist = mcd.querymodulecategory(cid, tp, 10, nowpage);
		// System.out.println("fisrtclist:" + fisrtclist);
		return "fmc";
	}

	private List secondclist;

	public List getSecondclist() {
		return secondclist;
	}

	public void setSecondclist(List secondclist) {
		this.secondclist = secondclist;
	}

	public String getSecondModulCategory() {
		if (nowpage == 0)
			nowpage = 1;
		totalpage = (mcd.querymodulecategorycount(cid, tp) - 1) / 10 + 1;
		if (nowpage >= totalpage)
			nowpage = totalpage;
		secondclist = mcd.querymodulecategory(cid, tp, 10, nowpage);
		return "smc";
	}

	public String addFirstCategory() {
		return "fc";
	}

	public String addSecondCategory() {
		return "sc";
	}

	// 添加小分类
	public void addFirstCategoryok() throws IOException {
		String notice = "添加成功";
		Calenda cal = new Calenda();
		if (mcd.savemodulCategory(mcname, cid, tp, mcorder, cal.getNowTime()
				.toString(), 0))
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

	// 修改小分类
	public String upfirstcategory() {
		fisrtclist = mcd.querymodulcategory(mcid);
		return "ufc";
	}

	public String upSecondCategory() {
		secondclist = mcd.querymodulcategory(mcid);
		return "usc";
	}

	// 修改小分类
	public void upfirstcategoryok() throws IOException {
		String notice = "修改成功";
		Calenda cal = new Calenda();
		if (mcd.upmodulCategory(mcid, mcname, mcorder, cal.getNowTime()
				.toString()))
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

	// 删除小分类
	public void delfirstcategoryok() throws IOException {
		String notice = "删除成功";
		Calenda cal = new Calenda();
		if (mcd.upmodulcategorydel(mcid, 1, cal.getNowTime().toString()))
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
