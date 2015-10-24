package com.zhoubian.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhoubian.dao.membersDao;
import com.zhoubian.dao.impl.membersDaoImpl;
import com.zhoubian.util.Calenda;
import com.zhoubian.util.MD5;

public class adminAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mid;
	private int mrole_id;
	private int mcity;
	private int mzone;
	private int mprovice;
	private String mname;
	private String mpassword;
	private String msex;
	private String mmobel;
	private String memail;
	private String mtureName;
	private int misUseful;
	private String midNumber;
	private String maddress;
	private int misEmail;
	private int misMobel;
	private String midcardUrl;
	private String muptime;
	private String mlogintime;
	private int mlogincount;
	private int mwaitDelete;
	private int misRecognise;
	private int myongjin;
	private String mbankCard;
	private String mcardUrl;
	private int misCardOk;
	private String mrecogniseId;
	private String mpayPassword;
	private String notice;
	private List loginlist;
	private String mmiyue;
	private static String mobel;

	public String getMobel() {
		return mobel;
	}

	public void setMobel(String mobel) {
		this.mobel = mobel;
	}

	public String getMmiyue() {
		return mmiyue;
	}

	public void setMmiyue(String mmiyue) {
		this.mmiyue = mmiyue;
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

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getMrole_id() {
		return mrole_id;
	}

	public void setMrole_id(int mrole_id) {
		this.mrole_id = mrole_id;
	}

	public int getMcity() {
		return mcity;
	}

	public void setMcity(int mcity) {
		this.mcity = mcity;
	}

	public int getMzone() {
		return mzone;
	}

	public void setMzone(int mzone) {
		this.mzone = mzone;
	}

	public int getMprovice() {
		return mprovice;
	}

	public void setMprovice(int mprovice) {
		this.mprovice = mprovice;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMsex() {
		return msex;
	}

	public void setMsex(String msex) {
		this.msex = msex;
	}

	public String getMmobel() {
		return mmobel;
	}

	public void setMmobel(String mmobel) {
		this.mmobel = mmobel;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMtureName() {
		return mtureName;
	}

	public void setMtureName(String mtureName) {
		this.mtureName = mtureName;
	}

	public int getMisUseful() {
		return misUseful;
	}

	public void setMisUseful(int misUseful) {
		this.misUseful = misUseful;
	}

	public String getMidNumber() {
		return midNumber;
	}

	public void setMidNumber(String midNumber) {
		this.midNumber = midNumber;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public int getMisEmail() {
		return misEmail;
	}

	public void setMisEmail(int misEmail) {
		this.misEmail = misEmail;
	}

	public int getMisMobel() {
		return misMobel;
	}

	public void setMisMobel(int misMobel) {
		this.misMobel = misMobel;
	}

	public String getMidcardUrl() {
		return midcardUrl;
	}

	public void setMidcardUrl(String midcardUrl) {
		this.midcardUrl = midcardUrl;
	}

	public String getMuptime() {
		return muptime;
	}

	public void setMuptime(String muptime) {
		this.muptime = muptime;
	}

	public String getMlogintime() {
		return mlogintime;
	}

	public void setMlogintime(String mlogintime) {
		this.mlogintime = mlogintime;
	}

	public int getMlogincount() {
		return mlogincount;
	}

	public void setMlogincount(int mlogincount) {
		this.mlogincount = mlogincount;
	}

	public int getMwaitDelete() {
		return mwaitDelete;
	}

	public void setMwaitDelete(int mwaitDelete) {
		this.mwaitDelete = mwaitDelete;
	}

	public int getMisRecognise() {
		return misRecognise;
	}

	public void setMisRecognise(int misRecognise) {
		this.misRecognise = misRecognise;
	}

	public int getMyongjin() {
		return myongjin;
	}

	public void setMyongjin(int myongjin) {
		this.myongjin = myongjin;
	}

	public String getMbankCard() {
		return mbankCard;
	}

	public void setMbankCard(String mbankCard) {
		this.mbankCard = mbankCard;
	}

	public String getMcardUrl() {
		return mcardUrl;
	}

	public void setMcardUrl(String mcardUrl) {
		this.mcardUrl = mcardUrl;
	}

	public int getMisCardOk() {
		return misCardOk;
	}

	public void setMisCardOk(int misCardOk) {
		this.misCardOk = misCardOk;
	}

	public String getMrecogniseId() {
		return mrecogniseId;
	}

	public void setMrecogniseId(String mrecogniseId) {
		this.mrecogniseId = mrecogniseId;
	}

	public String getMpayPassword() {
		return mpayPassword;
	}

	public void setMpayPassword(String mpayPassword) {
		this.mpayPassword = mpayPassword;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public List getLoginlist() {
		return loginlist;
	}

	public void setLoginlist(List loginlist) {
		this.loginlist = loginlist;
	}

	private membersDao msd = new membersDaoImpl();

	public String zhoubian() {
		return "l";
	}

	public void login() {

		notice = "登陆成功";
		try {
			MD5 md5 = new MD5();
			if (mname != null && mname != "" && mpassword != null
					&& mpassword != "") {
				loginlist = msd.login(mname, md5.md5s(mpassword));
				if (loginlist.size() == 0) {
					notice = "用户名或密码错误";
				} else {
					ActionContext.getContext().getSession()
							.put("userlogin", loginlist);
				}
			} else {
				notice = "用户名或密码不能为空";
			}
			JSONObject object = new JSONObject();
			// object.element("loginlist", JSONArray.fromObject(loginlist));
			object.element("notice", notice);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(object);
			out.flush();
			out.close();
		} catch (Exception e) {
		}
	}

	private List userlist;

	public List getUserlist() {
		return userlist;
	}

	public void setUserlist(List userlist) {
		this.userlist = userlist;
	}

	// 获取用户信息
	public String getUser() {

		if (nowpage == 0)
			nowpage = 1;
		totalpage = (msd.querymemberscount(1, mobel, 0) - 1) / 10 + 1;
		if (nowpage >= totalpage)
			nowpage = totalpage;
		userlist = null;
		userlist = msd.querymembers(1, 10, nowpage, mobel, 0);
		// System.out.println("count:" + msd.querymemberscount(1, mobel));
		// System.out.println("userlist:" + userlist);
		return "u";
	}

	// 获取已删用户信息
	public String getUser2() {

		if (nowpage == 0)
			nowpage = 1;
		totalpage = (msd.querymemberscount(1, mobel, 1) - 1) / 10 + 1;
		if (nowpage >= totalpage)
			nowpage = totalpage;
		userlist = null;
		userlist = msd.querymembers(1, 10, nowpage, mobel, 1);
		// System.out.println("count:" + msd.querymemberscount(1, mobel));
		// System.out.println("userlist:" + userlist);
		return "d";
	}

	public List adminlist;

	public List getAdminlist() {
		return adminlist;
	}

	public void setAdminlist(List adminlist) {
		this.adminlist = adminlist;
	}

	// 获取管理员数据

	public String getAdmin() {
		if (nowpage == 0)
			nowpage = 1;
		totalpage = (msd.queryadmincount() - 1) / 10 + 1;
		if (nowpage >= totalpage)
			nowpage = totalpage;
		adminlist = msd.queryadmin(10, nowpage);
		return "au";
	}

	public String getUpPass() {
		return "up";
	}

	public String addAdmin() {
		return "ada";
	}

	public String upAdmin() {
		adminlist = msd.querymember(Integer.parseInt(mid));
		return "upa";
	}

	// 编辑密钥
	public String upMiYue() {
		adminlist = msd.querymember(Integer.parseInt(mid));
		return "upm";

	}

	public void upyjrzm() throws IOException {
		String notice = "认证成功";
		Calenda cal = new Calenda();
		List yjl = msd.querymember(Integer.parseInt(mid.toString()));
		HashMap yjhm = (HashMap) yjl.get(0);
		if (Integer.parseInt(yjhm.get("is_recognise").toString()) == 1) {
			notice = "已经认证";
		} else
			try {
				if (Integer.parseInt(yjhm.get("is_recognise").toString()) == 0
						&& msd.updateadminrenzhen(Integer.parseInt(mid), 1, cal
								.getNowTime().toString()))
					notice = "认证成功";
				else
					notice = "认证失败";
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

	// 删除用户
	public void upyjdm() throws NumberFormatException, Exception {
		String notice = "删除成功";
		Calenda cal = new Calenda();
		if (msd.updateadmindel(Integer.parseInt(mid.toString()), 1, cal
				.getNowTime().toString()))
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

	// 恢复用户
	public void upyjdm2() throws NumberFormatException, Exception {
		String notice = "恢复成功";
		Calenda cal = new Calenda();
		if (msd.updateadmindel(Integer.parseInt(mid.toString()), 0, cal
				.getNowTime().toString()))
			notice = "恢复成功";
		else
			notice = "恢复失败";
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

	// 添加管理员

	public void addAdminok() throws IOException {
		String notice = "添加成功";
		Calenda cal = new Calenda();
		MD5 md5 = new MD5();
		try {
			if (msd.addadmin(mname, md5.md5s(mpassword), mmobel, memail, cal
					.getNowTime().toString()))
				notice = "添加成功";
			else
				notice = "添加失败";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	// 修改管理员信息
	public void upAdminok() throws IOException {
		String notice = "修改成功";
		Calenda cal = new Calenda();
		MD5 md5 = new MD5();
		try {
			if (msd.upadmin(Integer.parseInt(mid), mname, mmobel, memail, cal
					.getNowTime().toString()))
				notice = "修改成功";
			else
				notice = "修改失败";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	// 修改用户信息
	public void upMemok() throws IOException {
		String notice = "修改成功";
		Calenda cal = new Calenda();
		MD5 md5 = new MD5();
		try {
			if (msd.upmember(Integer.parseInt(mid), mname, mmiyue))
				notice = "修改成功";
			else
				notice = "修改失败";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	private String opass;
	private String npass;

	public String getOpass() {
		return opass;
	}

	public void setOpass(String opass) {
		this.opass = opass;
	}

	public String getNpass() {
		return npass;
	}

	public void setNpass(String npass) {
		this.npass = npass;
	}

	// 修改密码
	public void upPassok() throws IOException {

		String notice = "修改成功";
		Calenda cal = new Calenda();
		MD5 md5 = new MD5();
		List aduser = (List) ActionContext.getContext().getSession()
				.get("userlogin");
		HashMap adu = (HashMap) aduser.get(0);
		try {

			// System.out.println("获取原MD5:"+msd.getopPass(Integer.parseInt(adu.get("Id").toString())));
			// System.out.println("输入原MD5:"+md5.md5s(opass).toString());
			if ((msd.getopPass(Integer.parseInt(adu.get("Id").toString()))
					.equals(md5.md5s(opass).toString()))) {
				if (msd.upPass(Integer.parseInt(adu.get("Id").toString()), md5
						.md5s(npass).toString(), cal.getNowTime().toString())) {

					notice = "修改成功";
				}
			} else {
				notice = "修改失败";
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
