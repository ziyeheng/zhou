package com.zhoubian.dao.impl;

import java.util.List;

import com.zhoubian.dao.yongjinDao;
import com.zhoubian.table.*;
import com.zhoubian.util.DatabaseAccess;
import com.zhoubian.util.EasyMapsManager;

public class yongjinDaoImpl implements yongjinDao {
	public List queryyonjin(int Id, int city, int first_mcid, String member_id,
			int province, int second_mcid, int zone, int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from yongjin y left join member_yongjin m where y.Id=? AND"
				+ "y.member_id=m.member.id LIMIT ?,?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(Id);
			easyMapsManager.setPreparedParameter((page - 1) * rows);
			easyMapsManager.setPreparedParameter(rows);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean saveyongjin(int id, String name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "insert into yongjin (Id,name) values(?,?);";
		dao.setPreparedParameter(id);
		dao.setPreparedParameter(name);
		boolean b = dao.executeInsert(sql) > 0 ? true : false;
		dao.close();
		return b;
	}

	// 修改发布信息
	public boolean updateyongjin(int id, String businessname, String sjaddress,
			String discription, String phone, String range1) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update yongjin  set businessname=? , sjaddress=? , discription=? , phone=? , range1=?  where Id=?";
		dao.setPreparedParameter(businessname);
		dao.setPreparedParameter(sjaddress);
		dao.setPreparedParameter(discription);
		dao.setPreparedParameter(phone);
		dao.setPreparedParameter(range1);
		dao.setPreparedParameter(id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public int addyongjin(Yongjin y) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "insert into yongjin(first_mcid,second_mcid,member_id,province,city,zone,"
				+ "price,yj,mobel,is_ok,is_receive,guige,caizhi,start_time,end_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		dao.setPreparedParameter(y.getFirst_mcid());
		dao.setPreparedParameter(y.getSecond_mcid());
		dao.setPreparedParameter(y.getMember_id());
		dao.setPreparedParameter(y.getProvince());
		dao.setPreparedParameter(y.getCity());
		dao.setPreparedParameter(y.getZone());
		dao.setPreparedParameter(y.getPrice());
		dao.setPreparedParameter(y.getYj());
		dao.setPreparedParameter(y.getMobel());
		dao.setPreparedParameter(y.getIsOk());
		dao.setPreparedParameter(y.getIsReceive());
		dao.setPreparedParameter(y.getGuige());
		dao.setPreparedParameter(y.getCaizhi());
		dao.setPreparedParameter(y.getStartTime());
		dao.setPreparedParameter(y.getEndDate());
		int count = dao.executeInsert(sql);
		dao.close();
		return count;
	}

	// 查询附近的佣金项目
	public List querynearby(String longitude, String latitude, int second_mcid,
			int page, int rows) {
		String sql = "select * from yongjin j left join modul_category m where j.second_mcid=m.category_id "
				+ "AND longitude=? AND latitude=? AND second_mcid=? LIMIT ?,? ;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(longitude);
			easyMapsManager.setPreparedParameter(latitude);
			easyMapsManager.setPreparedParameter(second_mcid);
			easyMapsManager.setPreparedParameter((page - 1) * rows);
			easyMapsManager.setPreparedParameter(rows);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List screenbottom(int city, String member_id, int province,
			int first_mcid, int second_mcid, int zone, int is_ok, int rows,
			int page) {
		String sql = "select * from yongjin j left join modul_category m on j.first_mcid=m.Id "
				+ "AND j.second_mcid=m.Id where j.first_mcid=? AND j.city=? AND j.member_id=? AND j.province=? "
				+ "AND j.second_mcid=? AND j.zone=? AND j.is_ok=? LIMIT ?,? ;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(first_mcid);
			easyMapsManager.setPreparedParameter(city);
			easyMapsManager.setPreparedParameter(member_id);
			easyMapsManager.setPreparedParameter(province);
			easyMapsManager.setPreparedParameter(second_mcid);
			easyMapsManager.setPreparedParameter(zone);
			easyMapsManager.setPreparedParameter(is_ok);
			easyMapsManager.setPreparedParameter((page - 1) * rows);
			easyMapsManager.setPreparedParameter(rows);
			List list = easyMapsManager.executeQuery(sql);
			System.out.println(list);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List publisheryongjin(String id, int rows, int page) {
		// 活动发布者通过查询yongjin和member_yongjin查出自己发布的任务和谁接了自己发布的任务
		// System.out.println(id);
		String sql = "select distinct * from members m inner join yongjin j "
				+ "ON m.Id=j.member_id left join member_yongjin my on my.yongjin_id=j.Id where m.Id=? LIMIT ?,? ;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(id);
			easyMapsManager.setPreparedParameter((page - 1) * rows);
			easyMapsManager.setPreparedParameter(rows);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean receiveyonjin(int yongjin_id) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update yongjin  set is_receive=1 where Id=?";
		dao.setPreparedParameter(yongjin_id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public List queryYongJin(int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from zhoubianview  where is_close=0 limit ?,?";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter((page - 1) * rows);
			easyMapsManager.setPreparedParameter(rows);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取当前页的数据..从yongjinview视图中
	public List queryyongjin(int categoryid, int page, int num, String mobel) {
		// TODO Auto-generated method stub

		String cat = " cat_id<>? ";
		String m = "";
		if (categoryid != 0)
			cat = "cat_id=? ";
		if (mobel != null && !mobel.equals(""))
			m = "and phone like '%" + mobel + "%' ";

		String sql = "select * from zhoubianview where is_close=0 and " + cat
				+ m + "order by Id desc limit ?,? ";

		// System.out.println("____" + categoryid + "____" + m + "____" + sql);
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(categoryid);
			easyMapsManager.setPreparedParameter((page - 1) * num);
			easyMapsManager.setPreparedParameter(num);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			// System.out.println("+++" + sql);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取categoryname
	public String querycategoryname(int id) {

		String categoryname = "全部";
		String sql = "select name from category where Id = ?";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(id);
			categoryname = easyMapsManager.getString(sql);
			databaseAccess.close();
			// System.out.println("id:" + id);
			// System.out.println("+++" + sql);
			return categoryname;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryname;
	}

	public int queryyongjincount(int categoryid, String mobel) {
		// TODO Auto-generated method stub
		// System.out.println(categoryid);
		String m = "";
		if (mobel != null && !mobel.equals(""))
			m = "and phone like '%" + mobel + "%' ";

		String cat = "cat_id<>? ";
		if (categoryid != 0)
			cat = "cat_id=?";
		String sql = "select count(*) from zhoubianview where " + cat
				+ "and is_close=0 " + m;

		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(categoryid);
			int count = databaseAccess.executeCount(sql);
			databaseAccess.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean updateyongjinok(int id, int isok) {
		// TODO Auto-generated method stub
		String sql = "update yongjin set `is_ok`=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(isok);
			databaseAccess.setPreparedParameter(id);
			databaseAccess.executeUpdate(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateyongjindel(int id, int del) {
		// TODO Auto-generated method stub
		String sql = "update yongjin set `is_close`=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(del);
			databaseAccess.setPreparedParameter(id);
			databaseAccess.executeUpdate(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List queryyongjin(int yongjinid) {
		// TODO Auto-generated method stub
		String sql = "select * from zhoubianview where Id=? ";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(yongjinid);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
