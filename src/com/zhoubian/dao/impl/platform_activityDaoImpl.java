package com.zhoubian.dao.impl;

import java.util.List;

import com.zhoubian.dao.platform_activityDao;
import com.zhoubian.util.DatabaseAccess;
import com.zhoubian.util.EasyMapsManager;

public class platform_activityDaoImpl implements platform_activityDao {

	public List queryplatform_activity(int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from platform_activity p where p.category_id=2 LIMIT ?,?;";
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

	public boolean saveplatform_activity(int id, String name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "insert into platform_activity(Id,name) values(?,?);";
		dao.setPreparedParameter(id);
		dao.setPreparedParameter(name);
		boolean b = dao.executeInsert(sql) > 0 ? true : false;
		dao.close();
		return b;
	}

	public boolean updateplatform_activity(int id, String name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update platform_activity set name=? where Id=?;";
		dao.setPreparedParameter(name);
		dao.setPreparedParameter(id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	// 获取新手上路的内容
	public List queryPlatformActivity(int rows, int page, int cat) {
		// TODO Auto-generated method stub
		String sql = "select * from platform_activity where category_id=? and is_delete=0 order by `order` desc LIMIT ?,?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(cat);
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

	// 获取新手上路的内容
	public int queryplatformactivitycount(int cat) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from platform_activity where category_id=? and is_delete=0;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(cat);
			int count = databaseAccess.executeCount(sql);
			databaseAccess.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean updateplatformdel(int id, int del, String uptime) {
		// TODO Auto-generated method stub
		String sql = "update platform_activity set is_delete=?,uptime=? where Id=?;";
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

	public boolean addplatform(int categoryid, String title, String content,
			String imgurl, int order, String starttime, String endtime,
			String uptime, int del) {
		// TODO Auto-generated method stub
		String sql = "insert into platform_activity(`category_id`,`title`,`content`,img_url,`order`,strat_time,end_time,uptime,is_delete) values(?,?,?,?,?,?,?,?,?);";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(categoryid);
			databaseAccess.setPreparedParameter(title);
			databaseAccess.setPreparedParameter(content);
			databaseAccess.setPreparedParameter(imgurl);
			databaseAccess.setPreparedParameter(order);
			databaseAccess.setPreparedParameter(starttime);
			databaseAccess.setPreparedParameter(endtime);
			databaseAccess.setPreparedParameter(uptime);
			databaseAccess.setPreparedParameter(del);
			databaseAccess.executeInsert(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 修改新手上路的信息
	public List queryPlatformAct(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from platform_activity where Id=?;";
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

	// 修改新手上路的内容
	public boolean upplatform(int id, int categoryid, String title,
			String content, String imgurl, int order, String starttime,
			String endtime, String uptime, int del) {
		// TODO Auto-generated method stub
		String sql = "update platform_activity set `title`=?,`content`=?,`order`=?,`uptime`=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(title);
			databaseAccess.setPreparedParameter(content);
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
}
