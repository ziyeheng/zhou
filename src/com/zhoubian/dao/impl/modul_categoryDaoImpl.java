package com.zhoubian.dao.impl;

import java.util.List;

import com.zhoubian.dao.modul_categoryDao;
import com.zhoubian.util.DatabaseAccess;
import com.zhoubian.util.EasyMapsManager;

public class modul_categoryDaoImpl implements modul_categoryDao {

	public List querymodul_category(int category_id, int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from modul_category m left join category c on c.Id=m.category_id where m.category_id=? LIMIT ?,?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(category_id);
			easyMapsManager.setPreparedParameter((page - 1) * rows);
			easyMapsManager.setPreparedParameter(rows);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
//			System.out
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean savemodul_category(int id, String name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "insert into modul_category(Id,name) values(?,?);";
		dao.setPreparedParameter(id);
		dao.setPreparedParameter(name);
		boolean b = dao.executeInsert(sql) > 0 ? true : false;
		dao.close();
		return b;
	}

	public boolean updatemodul_category(int id, String name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update modul_category set name=? where Id=?;";
		dao.setPreparedParameter(name);
		dao.setPreparedParameter(id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public List getsecondmodul_category(int first_mcid) {
		String sql = "select * from modul_category m where m.`type`=? and m.is_delete=0;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(first_mcid);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List querymodulecategory(int categoryid, int type, int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from modul_category m where m.category_id=?  and is_delete=0 order by `order` desc LIMIT ?,?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(categoryid);
			// easyMapsManager.setPreparedParameter(type);
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

	// 添加小分类
	public boolean savemodulCategory(String name, int categoryid, int type,
			int order, String uptime, int isdelete) {
		// TODO Auto-generated method stub
		String sql = "insert into modul_category(`name`,category_id,`order`,uptime,is_delete) values(?,?,?,?,?);";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(name);
			databaseAccess.setPreparedParameter(categoryid);
			// databaseAccess.setPreparedParameter(type);
			databaseAccess.setPreparedParameter(order);
			databaseAccess.setPreparedParameter(uptime);
			databaseAccess.setPreparedParameter(isdelete);
			databaseAccess.executeInsert(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 第二类列表
	public List queryModulCatgory(int categoryid) {
		// TODO Auto-generated method stub
		String sql = "select * from modul_category m where m.category_id=? and m.is_delete=0;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(categoryid);
			// 从EasyMapsManager返回键值对list
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取第二分类的数量
	public int querymodulecategorycount(int categoryid, int type) {
		// TODO Auto-generated method stub
		// String sql =
		// "select count(*) from modul_category m where m.category_id=? and m.`type`=? and is_delete=0;";
		String sql = "select count(*) from modul_category m where m.category_id=? and is_delete=0;";
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

	// 修改小分类,先是查找
	public List querymodulcategory(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from modul_category m where m.Id=? and m.is_delete=0;";
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

	// 修改小分类
	public boolean upmodulCategory(int id, String name, int order, String uptime) {
		// TODO Auto-generated method stub
		String sql = "update modul_category set `name`=?,`order`=?,`uptime`=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(name);
			databaseAccess.setPreparedParameter(order);
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

	// 删除大分类
	public boolean upmodulcategorydel(int id, int del, String uptime) {
		// TODO Auto-generated method stub
		String sql = "update modul_category set is_delete=?,`uptime`=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(del);
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
}
