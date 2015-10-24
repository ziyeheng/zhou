package com.zhoubian.dao.impl;

import java.util.Date;
import java.util.List;

import com.zhoubian.dao.member_yongjinDao;
import com.zhoubian.util.DatabaseAccess;
import com.zhoubian.util.EasyMapsManager;

public class member_yongjinDaoImpl implements member_yongjinDao {

	@SuppressWarnings({ "rawtypes", "static-access" })
	public List querymerber_yongjin(int Id, String member_id, int yongjin_id,
			int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select qb_members.uid from member_yongjing where member_yongjin.username=? and member_yongjin.password=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(Id);
			easyMapsManager.setPreparedParameter(member_id);
			easyMapsManager.setPreparedParameter(yongjin_id);
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

	public boolean updatemember_yongjin(int id, String member_id, int yongjin_id) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update member_yongjin set is_complete=1 where Id=? AND member_id=? AND yongjin_id=?;";
		dao.setPreparedParameter(id);
		dao.setPreparedParameter(member_id);
		dao.setPreparedParameter(yongjin_id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public List querycomplete(int rows, int page) {
		String sql = "select * from member_yongjin j left join members m on j.member_id=m.Id where "
				+ "j.is_complete=1 LIMIT ?,?;";
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

	public boolean delectmember_yongjin(int Id, String member_id, int yongjin_id) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update member_yongjin set is_delete=1 where Id=? AND member_id=? AND yongjin_id=?;";
		dao.setPreparedParameter(Id);
		dao.setPreparedParameter(member_id);
		dao.setPreparedParameter(yongjin_id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public List jiedanmerber_yongjin(String member_id, int rows, int page) {
		String sql = "select * from member_yongjin m left join yongjin y on m.yongjin_id=y.Id where m.member_id=? LIMIT ?,?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(member_id);
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

	public boolean getyongjin(String member_id, int yongjin_id) {
		DatabaseAccess dao = new DatabaseAccess();
		Date now = new Date();
		String sql = "insert into member_yongjin(member_id,yongjin_id,is_complete,start_time,is_delete,is_pay) values(?,?,?,?,?,?);";
		dao.setPreparedParameter(member_id);
		dao.setPreparedParameter(yongjin_id);
		dao.setPreparedParameter(0);
		dao.setPreparedParameter(now);
		dao.setPreparedParameter(0);
		dao.setPreparedParameter(0);
		boolean b = dao.executeInsert(sql) > 0 ? true : false;
		dao.close();
		return b;
	}

	public List queryMemberYongjin(int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from memberyongjinview where is_delete=0 order by start_time desc LIMIT ?,?;";
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

	public int querymemberyongjincount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from memberyongjinview where is_delete=0;";
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

	public List querymyj(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from memberyongjinview where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(id);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updatemyj(int id, int del) {
		// TODO Auto-generated method stub
		String sql = "update member_yongjin set is_delete=? where Id=?;";
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
}
