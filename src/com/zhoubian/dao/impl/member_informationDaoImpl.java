package com.zhoubian.dao.impl;

import java.util.Date;
import java.util.List;

import com.zhoubian.dao.member_informationDao;
import com.zhoubian.util.DatabaseAccess;
import com.zhoubian.util.EasyMapsManager;

public class member_informationDaoImpl implements member_informationDao {

	public List querymember_information(String member_id, int information_id,
			int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select m.Id from member_information m where m.merber_id=? AND m.information_id=? "
				+ "LIMIT ?,?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(member_id);
			easyMapsManager.setPreparedParameter(information_id);
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

	public boolean savemember_information(int Id, String member_id,
			int information_id) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "insert into member_information(Id,member_id,information_id) values(?,?,?);";
		dao.setPreparedParameter(Id);
		dao.setPreparedParameter(member_id);
		dao.setPreparedParameter(information_id);
		boolean b = dao.executeInsert(sql) > 0 ? true : false;
		dao.close();
		return b;
	}

	public boolean updatemember_information(String comment_content, int is_zan,
			int is_rescend, String member_id, int information_id) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "upadate member_information set comment_content=?,is_zan=? "
				+ ",is_rescend=? where member_id=? AND information_id=?;";
		dao.setPreparedParameter(comment_content);
		dao.setPreparedParameter(is_zan);
		dao.setPreparedParameter(is_rescend);
		dao.setPreparedParameter(member_id);
		dao.setPreparedParameter(information_id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public boolean dianzanmember_information(String member_id,
			int information_id) {
		boolean b = false;
		String sql1 = "select * from member_information  m where m.member_id=? AND m.information_id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(member_id);
			easyMapsManager.setPreparedParameter(information_id);
			List list = easyMapsManager.executeQuery(sql1);
			if (list.size() > 0) {
				DatabaseAccess dao = new DatabaseAccess();
				String sql = "update member_information m set m.is_zan=1 where m.member_id=? AND m.information_id=?;";
				dao.setPreparedParameter(member_id);
				dao.setPreparedParameter(information_id);
				b = dao.executeUpdate(sql);
			} else {
				DatabaseAccess dao = new DatabaseAccess();
				String sql2 = "insert into member_information(member_id,information_id,is_zan) values(?,?,?);";
				dao.setPreparedParameter(member_id);
				dao.setPreparedParameter(information_id);
				dao.setPreparedParameter(1);
				b = dao.executeInsert(sql2) > 0 ? true : false;
			}
			databaseAccess.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean zhuanfamember_information(String member_id,
			int information_id) {
		boolean b = false;
		String sql1 = "select * from member_information  m where m.member_id=? AND m.information_id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(member_id);
			easyMapsManager.setPreparedParameter(information_id);
			List list = easyMapsManager.executeQuery(sql1);
			if (list.size() > 0) {
				DatabaseAccess dao = new DatabaseAccess();
				String sql = "update member_information m set m.is_rescend=1 where m.member_id=? AND m.information_id=?;";
				dao.setPreparedParameter(member_id);
				dao.setPreparedParameter(information_id);
				b = dao.executeUpdate(sql);
			} else {
				DatabaseAccess dao = new DatabaseAccess();
				String sql2 = "insert into member_information(member_id,information_id,is_rescend) values(?,?,?);";
				dao.setPreparedParameter(member_id);
				dao.setPreparedParameter(information_id);
				dao.setPreparedParameter(1);
				b = dao.executeInsert(sql2) > 0 ? true : false;
			}
			databaseAccess.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean pinlunmember_information(String member_id,
			int information_id, String comment_content) {
		Date now = new Date();
		boolean b = false;
		System.out.println(comment_content);
		String sql1 = "select * from member_information  m where m.member_id=? AND m.information_id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(member_id);
			easyMapsManager.setPreparedParameter(information_id);
			List list = easyMapsManager.executeQuery(sql1);
			System.out.println(list.size());
			if (list.size() > 0) {
				DatabaseAccess dao = new DatabaseAccess();
				String sql = "update member_information m set m.comment_content=?,m.comment_time=? where member_id=? AND information_id=?;";
				dao.setPreparedParameter(comment_content);
				dao.setPreparedParameter(now);
				dao.setPreparedParameter(member_id);
				dao.setPreparedParameter(information_id);
				b = dao.executeUpdate(sql);
			} else {
				DatabaseAccess dao = new DatabaseAccess();
				String sql2 = "insert into member_information(member_id,information_id,"
						+ "comment_content,comment_time) values(?,?,?,?);";
				dao.setPreparedParameter(member_id);
				dao.setPreparedParameter(information_id);
				dao.setPreparedParameter(comment_content);
				dao.setPreparedParameter(now);
				b = dao.executeInsert(sql2) > 0 ? true : false;
			}
			databaseAccess.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public List queryMeberInformation(int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from memberinformationview where is_delete=0 order by comment_time desc LIMIT ?,?;";
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

	public int querycountMember() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from memberinformationview where is_delete=0;";
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

	public List queryMI(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from memberinformationview where Id=?;";
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

	public boolean updateMId(int id, int del) {
		// TODO Auto-generated method stub
		String sql = "update member_information set is_delete=? where Id=?;";
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
