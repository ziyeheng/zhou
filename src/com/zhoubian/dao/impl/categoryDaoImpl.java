package com.zhoubian.dao.impl;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import com.zhoubian.dao.categoryDao;
import com.zhoubian.util.DatabaseAccess;
import com.zhoubian.util.EasyMapsManager;
import com.zhoubian.util.MD5;

public class categoryDaoImpl implements categoryDao {

	public List querycategory(int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from category c where c.type=1 AND c.modul=0 and is_delete=0 LIMIT ?,?;";
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

	// 添加大分类
	public boolean saveCategory(int id, String name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "insert into category(Id,name) values(?,?);";
		dao.setPreparedParameter(id);
		dao.setPreparedParameter(name);
		boolean b = dao.executeInsert(sql) > 0 ? true : false;
		dao.close();
		return b;
	}

	public boolean updateCategory(int id, String name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update category set name=? where Id=?;";
		dao.setPreparedParameter(name);
		dao.setPreparedParameter(id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	// 查询顶部四张主要图片
	public List querycategoryfour() {
		// TODO Auto-generated method stub
		String sql = "select * from category c where c.type=0 AND c.modul=0 and is_delete=0;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 查询主分类
	public List querybottom() {
		// TODO Auto-generated method stub
		String sql = "select * from category c where c.type=0 AND c.modul=3 and is_delete=0 order by `order` desc;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			// System.out.println("大分类:" + sql);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List querysonpage(int id) {
		String sql = "select * from category c where c.id=? and is_delete=0;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(id);
			// easyMapsManager.setPreparedParameter(name);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List queryonelateral() {
		String sql = "select * from category c where c.type=0 AND c.modul=2 and is_delete=0;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List querysecondlateral(int id) {
		String sql = "select * from category c where c.type=? AND c.modul=2 and is_delete=0;";
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

	public List queryallcategory(int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from category where is_delete=0 order by uptime desc LIMIT ?,?;";
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

	// 添加大分类
	public boolean saveCategory(String name, int modul, int type, int order,
			int state, String pic_url, String content, String uptime,
			int isdelete) {
		// TODO Auto-generated method stub
		String sql = "insert into category(`name`,modul,type,`order`,state,pic_url,content,uptime,is_delete) values(?,?,?,?,?,?,?,?,?);";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(name);
			databaseAccess.setPreparedParameter(modul);
			databaseAccess.setPreparedParameter(type);
			databaseAccess.setPreparedParameter(order);
			databaseAccess.setPreparedParameter(state);
			databaseAccess.setPreparedParameter(pic_url);
			databaseAccess.setPreparedParameter(content);
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

	public List queryCategory(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from category where Id=?;";
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

	public boolean upCategory(int id, String name, int modul, int type,
			int order, int state, String pic_url, String content,
			String uptime, int isdelete) {
		// TODO Auto-generated method stub
		String sql = "update category set `name`=?,modul=?,type=?,`order`=?,uptime=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(name);
			databaseAccess.setPreparedParameter(modul);
			databaseAccess.setPreparedParameter(type);
			databaseAccess.setPreparedParameter(order);
			databaseAccess.setPreparedParameter(uptime);
			databaseAccess.setPreparedParameter(id);
			databaseAccess.executeInsert(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 删除大分类
	public boolean delCategory(int id, String uptime, int isdelete) {
		// TODO Auto-generated method stub
		String sql = "update category set uptime=?,is_delete=? where Id=?;";

		System.out.println("category id:" + id);
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(uptime);
			databaseAccess.setPreparedParameter(isdelete);
			databaseAccess.setPreparedParameter(id);
			databaseAccess.executeInsert(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int querycategorycount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from category where is_delete=0;";
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

	public boolean upCategoryAll(int id, String name, int modul, int type,
			int order, int state, String pic_url, String content,
			String uptime, int isdelete) {
		// TODO Auto-generated method stub
		String sql = "update category set `name`=?,modul=?,type=?,`order`=?,uptime=?,`content`=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(name);
			databaseAccess.setPreparedParameter(modul);
			databaseAccess.setPreparedParameter(type);
			databaseAccess.setPreparedParameter(order);
			databaseAccess.setPreparedParameter(uptime);
			databaseAccess.setPreparedParameter(content);
			databaseAccess.setPreparedParameter(id);
			databaseAccess.executeInsert(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
