package com.zhoubian.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhoubian.dao.categoryDao;
import com.zhoubian.dao.dictionaryDao;
import com.zhoubian.dao.modul_categoryDao;
import com.zhoubian.dao.yongjinDao;
import com.zhoubian.dao.impl.categoryDaoImpl;
import com.zhoubian.dao.impl.dictionaryDaoImpl;
import com.zhoubian.dao.impl.modul_categoryDaoImpl;
import com.zhoubian.dao.impl.yongjinDaoImpl;
import com.zhoubian.util.Calenda;

public class yongjinAction extends ActionSupport {

	private int yongjinid;
	private String sjaddress;
	private String discription;
	private String phone;
	private String range1;

	public String getSjaddress() {
		return sjaddress;
	}

	public void setSjaddress(String sjaddress) {
		this.sjaddress = sjaddress;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRange1() {
		return range1;
	}

	public void setRange1(String range1) {
		this.range1 = range1;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	private String businessname;

	public int getYongjinid() {
		return yongjinid;
	}

	public void setYongjinid(int yongjinid) {
		this.yongjinid = yongjinid;
	}

	private Long yjid;
	private int yjcity;
	private String yjmember_id;
	private int yjfirst_mcid;
	private int yjzone;
	private int yjsecond_mcid;
	private int yjprovince;
	private int yjprice;
	private int yjyj;
	private String yjmobel;
	private int yjisOk;
	private int yjisReceive;
	private String yjstartTime;
	private String yjendDate;
	private String yjupTime;
	private String yjguige;
	private String yjcaizhi;
	private String yjlongitude;
	private String yjlatitude;
	private int yjisDelete;
	private String yjimgUrl;

	private int nowpage;
	private int totalpage;
	private static String mobel;
	private static String categoryname = "全部";

	public static String getCategoryname() {
		return categoryname;
	}

	public static void setCategoryname(String categoryname) {
		yongjinAction.categoryname = categoryname;
	}

	public int getNowpage() {
		return nowpage;
	}

	public String getMobel() {
		return mobel;
	}

	public void setMobel(String mobel) {
		this.mobel = mobel;
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

	public Long getYjid() {
		return yjid;
	}

	public void setYjid(Long yjid) {
		this.yjid = yjid;
	}

	public int getYjcity() {
		return yjcity;
	}

	public void setYjcity(int yjcity) {
		this.yjcity = yjcity;
	}

	public String getYjmember_id() {
		return yjmember_id;
	}

	public void setYjmember_id(String yjmember_id) {
		this.yjmember_id = yjmember_id;
	}

	public int getYjfirst_mcid() {
		return yjfirst_mcid;
	}

	public void setYjfirst_mcid(int yjfirst_mcid) {
		this.yjfirst_mcid = yjfirst_mcid;
	}

	public int getYjzone() {
		return yjzone;
	}

	public void setYjzone(int yjzone) {
		this.yjzone = yjzone;
	}

	public int getYjsecond_mcid() {
		return yjsecond_mcid;
	}

	public void setYjsecond_mcid(int yjsecond_mcid) {
		this.yjsecond_mcid = yjsecond_mcid;
	}

	public int getYjprovince() {
		return yjprovince;
	}

	public void setYjprovince(int yjprovince) {
		this.yjprovince = yjprovince;
	}

	public int getYjprice() {
		return yjprice;
	}

	public void setYjprice(int yjprice) {
		this.yjprice = yjprice;
	}

	public int getYjyj() {
		return yjyj;
	}

	public void setYjyj(int yjyj) {
		this.yjyj = yjyj;
	}

	public String getYjmobel() {
		return yjmobel;
	}

	public void setYjmobel(String yjmobel) {
		this.yjmobel = yjmobel;
	}

	public int getYjisOk() {
		return yjisOk;
	}

	public void setYjisOk(int yjisOk) {
		this.yjisOk = yjisOk;
	}

	public int getYjisReceive() {
		return yjisReceive;
	}

	public void setYjisReceive(int yjisReceive) {
		this.yjisReceive = yjisReceive;
	}

	public String getYjstartTime() {
		return yjstartTime;
	}

	public void setYjstartTime(String yjstartTime) {
		this.yjstartTime = yjstartTime;
	}

	public String getYjendDate() {
		return yjendDate;
	}

	public void setYjendDate(String yjendDate) {
		this.yjendDate = yjendDate;
	}

	public String getYjupTime() {
		return yjupTime;
	}

	public void setYjupTime(String yjupTime) {
		this.yjupTime = yjupTime;
	}

	public String getYjguige() {
		return yjguige;
	}

	public void setYjguige(String yjguige) {
		this.yjguige = yjguige;
	}

	public String getYjcaizhi() {
		return yjcaizhi;
	}

	public void setYjcaizhi(String yjcaizhi) {
		this.yjcaizhi = yjcaizhi;
	}

	public String getYjlongitude() {
		return yjlongitude;
	}

	public void setYjlongitude(String yjlongitude) {
		this.yjlongitude = yjlongitude;
	}

	public String getYjlatitude() {
		return yjlatitude;
	}

	public void setYjlatitude(String yjlatitude) {
		this.yjlatitude = yjlatitude;
	}

	public int getYjisDelete() {
		return yjisDelete;
	}

	public void setYjisDelete(int yjisDelete) {
		this.yjisDelete = yjisDelete;
	}

	public String getYjimgUrl() {
		return yjimgUrl;
	}

	public void setYjimgUrl(String yjimgUrl) {
		this.yjimgUrl = yjimgUrl;
	}

	private List yongjinlist;

	public List getYongjinlist() {
		return yongjinlist;
	}

	public void setYongjinlist(List yongjinlist) {
		this.yongjinlist = yongjinlist;
	}

	// 动物 a=new 狗();实例化一个子类对象a，这个是典型的多态
	// a.发声(); 对象a可以使用动物中的发声()或其他方法，但不可以调用狗的方法。
	// A a = new A();实例化一个父类的对象a
	// 动物 a=new 狗()；狗b=(狗)a；//这里是向下转型
	// 这时b可调用动物类未被重写的方法和狗类所有方法（包括重写动物类的方法）
	private yongjinDao yjd = new yongjinDaoImpl();

	private categoryDao cd = new categoryDaoImpl();
	private modul_categoryDao mcd = new modul_categoryDaoImpl();
	private dictionaryDao dd = new dictionaryDaoImpl();

	private List maincategory;
	private List firstcategory;
	private List secondcategory;
	private List province;
	private List city;
	private List zone;

	public List getMaincategory() {
		return maincategory;
	}

	public void setMaincategory(List maincategory) {
		this.maincategory = maincategory;
	}

	public List getFirstcategory() {
		return firstcategory;
	}

	public void setFirstcategory(List firstcategory) {
		this.firstcategory = firstcategory;
	}

	public List getSecondcategory() {
		return secondcategory;
	}

	public void setSecondcategory(List secondcategory) {
		this.secondcategory = secondcategory;
	}

	public List getProvince() {
		return province;
	}

	public void setProvince(List province) {
		this.province = province;
	}

	public List getCity() {
		return city;
	}

	public void setCity(List city) {
		this.city = city;
	}

	public List getZone() {
		return zone;
	}

	public void setZone(List zone) {
		this.zone = zone;
	}

	// 从这里获取第一大类
	public void MainCategory() throws IOException {
		maincategory = cd.querybottom();
		String catname = "全部";
		if (categoryid > 0)
			catname = ((HashMap) (cd.queryCategory(categoryid).get(0))).get(
					"name").toString();
		JSONObject object = new JSONObject();
		object.element("maincategory", JSONArray.fromObject(maincategory));
		object.element("catname", catname);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}

	private int categoryid;

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	// 第一类筛选调用
	// 选了第一分类的数据之后,开始获取第二分类的数据
	public void yjFirstCategory() throws IOException {
		// 获取list,
		firstcategory = mcd.queryModulCatgory(categoryid);
		JSONObject object = new JSONObject();
		object.element("firstcategory", JSONArray.fromObject(firstcategory));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}

	private int firstmcid;

	public int getFirstmcid() {
		return firstmcid;
	}

	public void setFirstmcid(int firstmcid) {
		this.firstmcid = firstmcid;
	}

	public void yjSecondCategory() throws IOException {
		secondcategory = mcd.getsecondmodul_category(firstmcid);
		JSONObject object = new JSONObject();
		object.element("secondcategory", JSONArray.fromObject(secondcategory));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}

	private int secondid;

	public int getSecondid() {
		return secondid;
	}

	public void setSecondid(int secondid) {
		this.secondid = secondid;
	}

	public void yjProvince() throws IOException {
		province = dd.querydic(0);
		JSONObject object = new JSONObject();
		object.element("province", JSONArray.fromObject(province));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}

	private int provinceid;

	public int getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}

	public void yjCity() throws IOException {
		city = dd.querydic(provinceid);
		JSONObject object = new JSONObject();
		object.element("city", JSONArray.fromObject(city));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}

	private int cityid;

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public void yjZone() throws IOException {
		zone = dd.querydic(cityid);
		JSONObject object = new JSONObject();
		object.element("zone", JSONArray.fromObject(zone));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
	}

	private int zoneid;

	public int getZoneid() {
		return zoneid;
	}

	public void setZoneid(int zoneid) {
		this.zoneid = zoneid;
	}

	// 筛选佣金
	public String getYJ() {

		if (nowpage == 0)
			nowpage = 1;
		if (categoryid < 0)
			categoryid = 0;

		// System.out.println("categoryname:" + categoryname);

		totalpage = (yjd.queryyongjincount(categoryid, mobel) - 1) / 10 + 1;
		// 如果现在的页数小于之前的页数,给赋值

		if (nowpage >= totalpage)
			nowpage = totalpage;
		// 获取当前页的数据 估计nowpage是点击页码之后会获取.然后再调用这个方法的.
		yongjinlist = yjd.queryyongjin(categoryid, nowpage, 10, mobel);
		return "yj";
	}

	public String upyongjin() {
		// System.out.println(yongjinid);
		yongjinlist = yjd.queryyongjin(yongjinid);
		// System.out.println("yongjinlist" + yongjinlist.toString());
		return "uyj";
	}

	public void upyjrz() throws IOException {
		String notice = "认证成功";
		Calenda cal = new Calenda();
		List yjl = yjd.queryyongjin(Integer.parseInt(yjid.toString()));
		HashMap yjhm = (HashMap) yjl.get(0);
		if (Integer.parseInt(yjhm.get("is_ok").toString()) == 1) {
			notice = "已经认证";
		} else if (Integer.parseInt(yjhm.get("is_ok").toString()) == 0
				&& yjd.updateyongjinok(Integer.parseInt(yjid.toString()), 1))
			notice = "认证成功";
		else
			notice = "认证失败";
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

	// 删除佣金
	public void upyjd() throws IOException {
		String notice = "删除成功";
		Calenda cal = new Calenda();
		if (yjd.updateyongjindel(Integer.parseInt(yjid.toString()), 1))
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

	// 修改佣金
	public void upyjd1() throws IOException {
		// System.out.println(yongjinid + businessname + sjaddress + discription
		//		+ phone + range1);
		String notice = "修改成功";
		Calenda cal = new Calenda();
		if (yjd.updateyongjin(yongjinid, businessname, sjaddress, discription,
				phone, range1))
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
