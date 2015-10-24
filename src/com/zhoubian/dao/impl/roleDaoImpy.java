package com.zhoubian.dao.impl;

import java.util.List;

import com.zhoubian.dao.roleDao;
import com.zhoubian.util.DatabaseAccess;
import com.zhoubian.util.EasyMapsManager;

public class roleDaoImpy implements roleDao {
	public List queryrole(int Id, int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select r.Id,r.name from role r where r.Id=? LIMIT ?,?;";
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

	public boolean saverole(int id, int name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "insert into role(Id,name) values(?,?);";
		dao.setPreparedParameter(id);
		dao.setPreparedParameter(name);
		boolean b = dao.executeInsert(sql) > 0 ? true : false;
		dao.close();
		return b;
	}

	public boolean updaterole(int id, int name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update role set name=? where Id=?;";
		dao.setPreparedParameter(name);
		dao.setPreparedParameter(id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public List queryrole(int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select r.* from role r LIMIT ?,?;";
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

	public int queryrolecount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from role r;";
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

	public boolean updaterolestate(int id, int state, String uptime) {
		// TODO Auto-generated method stub
		String sql = "update `role` set `state`=?,uptime=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(state);
			databaseAccess.setPreparedParameter(uptime);
			databaseAccess.setPreparedParameter(id);
			databaseAccess.executeUpdate(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addrole(String name, String uptime) {
		// TODO Auto-generated method stub
		String sql = "insert into `role`(`name`,`uptime`,`state`) values(?,?,1);";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(name);
			databaseAccess.setPreparedParameter(uptime);
			databaseAccess.executeInsert(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List queryRole(int id) {
		// TODO Auto-generated method stub
		String sql = "select r.* from role r where r.Id=?;";
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

	public boolean uprole(int id, String name, String uptime) {
		// TODO Auto-generated method stub
		String sql = "update `role` set `name`=?,uptime=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(name);
			databaseAccess.setPreparedParameter(uptime);
			databaseAccess.setPreparedParameter(id);
			databaseAccess.executeUpdate(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getredmaxnum() {
		String sql = "select maxnum from role where Id=2";

		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			String maxnum = databaseAccess.executepass(sql);
			databaseAccess.close();
			return maxnum;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "5";

	}

	public boolean updatemaxnum(String maxnum) {
		String sql = "update `role` set `maxnum`= ? where Id = 2;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(maxnum);
			databaseAccess.executeUpdate(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
