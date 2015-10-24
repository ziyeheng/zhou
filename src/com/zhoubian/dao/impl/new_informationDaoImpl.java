package com.zhoubian.dao.impl;

import java.util.Date;
import java.util.List;

import com.zhoubian.dao.new_informationDao;
import com.zhoubian.util.DatabaseAccess;
import com.zhoubian.util.EasyMapsManager;

public class new_informationDaoImpl implements new_informationDao {

	public List querynew_information(int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select n.Id,n.content from new_information n where n.category_id=? "
				+ "AND m.member_id=? LIMIT ?,?;";
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

	public List querycompletenew_information(int rows, int page) {
		String sql = "select * from new_information n LIMIT ?,?;";
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

	public boolean savenew_information(String content, String member_id,
			String img_url) {
		DatabaseAccess dao = new DatabaseAccess();
		Date now = new Date();
		System.out.println(content);
		// 这里的Id是自增的吧？
		String sql = "insert into new_information(content,member_id,img_url,uptime) values(?,?,?,?);";
		dao.setPreparedParameter(content);
		dao.setPreparedParameter(member_id);
		dao.setPreparedParameter(img_url);
		dao.setPreparedParameter(now);
		boolean b = dao.executeInsert(sql) > 0 ? true : false;
		dao.close();
		return b;
	}

	public boolean updatenew_information(int id, String content) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update new_information set content=? where Id=?;";
		dao.setPreparedParameter(content);
		dao.setPreparedParameter(id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public boolean liulannew_information(int information_id) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update new_information set see_count=see_count+1 where Id=?;";
		dao.setPreparedParameter(information_id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public boolean dianzannew_information(int information_id) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update new_information set zan_count=zan_count+1 where Id=?;";
		dao.setPreparedParameter(information_id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public boolean zhuanfanew_information(int information_id) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update new_information set resend_count=resend_count+1 where Id=?;";
		dao.setPreparedParameter(information_id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public boolean pinglunnew_information(int information_id) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update new_information set comment_count=comment_count+1 where Id=?;";
		dao.setPreparedParameter(information_id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	// 获取当前页反馈
	public List queryNewInformation(int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from newinformationview where is_delete=0 order by uptime desc LIMIT ?,?;";
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

	// 获取用户反馈
	public int querynewinformationcount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from newinformationview where is_delete=0;";
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

	// 删除反馈信息
	public boolean upnidel(int id, int del, String uptime) {
		// TODO Auto-generated method stub
		String sql = "update new_information set is_delete=?  where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(del);
			// databaseAccess.setPreparedParameter(uptime);
			databaseAccess.setPreparedParameter(id);
			databaseAccess.executeUpdate(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List queryNI(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from newinformationview where Id=0;";
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
}
