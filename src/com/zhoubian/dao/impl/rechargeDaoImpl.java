package com.zhoubian.dao.impl;

import java.util.List;

import com.zhoubian.dao.rechargeDao;
import com.zhoubian.util.DatabaseAccess;
import com.zhoubian.util.EasyMapsManager;

public class rechargeDaoImpl implements rechargeDao {

	// 获取充值记录
	public List getrecharge(int page, int num, String mobel) {
		// TODO Auto-generated method stub

		String m = "";
		if (mobel != null && !mobel.equals(""))
			m = "where mobel like '%" + mobel + "%' ";

		String sql = "select * from members_rechargeview " + m
				+ "  order by charge_time desc limit ?,? ";

		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter((page - 1) * num);
			easyMapsManager.setPreparedParameter(num);
			List list = easyMapsManager.executeQuery(sql);
			// System.out.println("sql:" + sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取充值总量
	public int queryrechargecount(String mobel) {

		String m = "";
		if (mobel != null && !mobel.equals(""))
			m = " where mobel like '%" + mobel + "%' ";

		String sql = "select count(*) from members_rechargeview " + m
				+ "order by charge_time desc";

		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			int count = databaseAccess.executeCount(sql);
			databaseAccess.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 获取消费数量
	public int querycouponcount(String mobel, int is_use, String mobel2) {

		String m = "";
		if (mobel != null && !mobel.equals(""))
			m = " and  mobel like '%" + mobel + "%' ";
		String m2 = "";
		if (mobel2 != null && !mobel2.equals(""))
			m2 = " and  phone like '%" + mobel2 + "%' ";
		String sql;
		if (is_use == 1)
			sql = "select count(*) from `members_use-couponview` where is_use ="
					+ is_use + m + m2 + "";
		else
			sql = "select count(*) from `members_use-couponview` where is_use <> 8"
					+ m + m2 + " ";
		// System.out.println("sql:" + sql);

		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			int count = databaseAccess.executeCount(sql);
			databaseAccess.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 获取消费列表
	public List getcoupon(int page, int num, String mobel, int is_use,
			String mobel2) {

		String m = "";
		if (mobel != null && !mobel.equals(""))
			m = " and mobel like '%" + mobel + "%' ";

		String m2 = "";
		if (mobel2 != null && !mobel2.equals(""))
			m2 = " and  phone like '%" + mobel2 + "%' ";
		String sql;
		if (is_use == 1)
			sql = "select * from `members_use-couponview` where is_use = "
					+ is_use + m + m2 + " order by use_time desc limit ?,? ";
		else
			sql = "select * from `members_use-couponview` where is_use <> 8"
					+ m + m2 + " order by add_time desc limit ?,? ";
		// System.out.println("sql:" + sql);

		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter((page - 1) * num);
			easyMapsManager.setPreparedParameter(num);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 红包数量
	public int queryredmoneycount(String mobel, String mobel2) {

		// 获取红包数量
		String m = "";
		if (mobel != null && !mobel.equals(""))
			m = " and  mobel like '%" + mobel + "%' ";
		String m2 = "";
		if (mobel2 != null && !mobel2.equals(""))
			m2 = " and  phone like '%" + mobel2 + "%' ";

		String sql = "select count(*) from `members_red_moneyview` where Id  <> 0 "
				+ m + m2;

		// System.out.println("sql:" + sql);

		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			int count = databaseAccess.executeCount(sql);
			databaseAccess.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	// 红包列表
	public List getredmoney(int page, int num, String mobel, String mobel2) {
		String m = "";
		if (mobel != null && !mobel.equals(""))
			m = " and mobel like '%" + mobel + "%' ";

		String m2 = "";
		if (mobel2 != null && !mobel2.equals(""))
			m2 = " and  phone like '%" + mobel2 + "%' ";

		String sql = "select * from `members_red_moneyview` where Id <> 0  "
				+ m + m2 + " order by Id desc limit ?,? ";

		// System.out.println("sql:" + sql);

		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter((page - 1) * num);
			easyMapsManager.setPreparedParameter(num);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
