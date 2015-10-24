package com.zhoubian.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zhoubian.dao.rechargeDao;
import com.zhoubian.dao.impl.rechargeDaoImpl;

public class members_rechargeAction extends ActionSupport {
	private int nowpage;
	private int totalpage;
	private List rechargelist;
	private List useconponlist;
	private List redmoneylist;

	public List getRedmoneylist() {
		return redmoneylist;
	}

	public void setRedmoneylist(List redmoneylist) {
		this.redmoneylist = redmoneylist;
	}

	// 第一个联系电话.
	private static String mobel;
	// 第二个联系电话
	private static String mobel2;

	public String getMobel2() {
		return mobel2;
	}

	public void setMobel2(String mobel2) {
		members_rechargeAction.mobel2 = mobel2;
	}

	public String getMobel() {
		return mobel;
	}

	public void setMobel(String mobel) {
		this.mobel = mobel;
	}

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

	public List getRechargelist() {
		return rechargelist;
	}

	public void setRechargelist(List rechargelist) {
		this.rechargelist = rechargelist;
	}

	public List getUseconponlist() {
		return useconponlist;
	}

	public void setUseconponlist(List useconponlist) {
		this.useconponlist = useconponlist;
	}

	private rechargeDao yjd = new rechargeDaoImpl();

	// 获取当前充值记录
	public String getrecharge() {

		if (nowpage == 0)
			nowpage = 1;

		totalpage = (yjd.queryrechargecount(mobel) - 1) / 10 + 1;

		if (nowpage >= totalpage)
			nowpage = totalpage;

		rechargelist = yjd.getrecharge(nowpage, 10, mobel);

		return "re";
	}

	// 获取消费记录
	public String getcoupon() {

		if (nowpage == 0)
			nowpage = 1;

		int is_use = 1;
		// System.out.println("mobel2" + mobel2);

		totalpage = (yjd.querycouponcount(mobel, is_use, mobel2) - 1) / 10 + 1;

		if (nowpage >= totalpage)
			nowpage = totalpage;

		useconponlist = yjd.getcoupon(nowpage, 10, mobel, is_use, mobel2);

		return "cou";
	}

	// 获取抢使用券记录
	public String getcoupon2() {

		if (nowpage == 0)
			nowpage = 1;

		int is_use = 0;
		// System.out.println("mobel2" + mobel2);

		totalpage = (yjd.querycouponcount(mobel, is_use, mobel2) - 1) / 10 + 1;

		if (nowpage >= totalpage)
			nowpage = totalpage;

		useconponlist = yjd.getcoupon(nowpage, 10, mobel, is_use, mobel2);

		return "cou2";
	}

	// 获取红包
	public String getredmoney() {

		if (nowpage == 0)
			nowpage = 1;

		totalpage = (yjd.queryredmoneycount(mobel, mobel2) - 1) / 10 + 1;

		if (nowpage >= totalpage)
			nowpage = totalpage;

		redmoneylist = yjd.getredmoney(nowpage, 10, mobel, mobel2);

		// System.out.println("redmoneylist" + redmoneylist);
		return "red";
	}

}
