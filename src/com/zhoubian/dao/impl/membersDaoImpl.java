package com.zhoubian.dao.impl;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.zhoubian.dao.membersDao;
import com.zhoubian.util.DatabaseAccess;
import com.zhoubian.util.EasyMapsManager;
import com.zhoubian.util.MD5;

public class membersDaoImpl implements membersDao {
	public List querymembersDao(int Id, int city, int province, int zone,
			int role_id, int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select m.Id,m.name from members m where m.Id=? AND m.city=? AND m.province=? "
				+ "AND m.zone=? AND m.role_id=? LIMIT ?,?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(Id);
			easyMapsManager.setPreparedParameter(city);
			easyMapsManager.setPreparedParameter(province);
			easyMapsManager.setPreparedParameter(zone);
			easyMapsManager.setPreparedParameter(role_id);
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

	public boolean savemembers(int id, String name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "insert into members(Id,name) values(?,?);";
		dao.setPreparedParameter(id);
		dao.setPreparedParameter(name);
		boolean b = dao.executeInsert(sql) > 0 ? true : false;
		dao.close();
		return b;
	}

	public boolean updatemembers(int id, String name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "update members  set name=? where Id=?;";
		dao.setPreparedParameter(name);
		dao.setPreparedParameter(id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	public List login(String name, String password) {
		// MD5 m=new MD5();
		// String pw=m.md5s(password);
		String sql = "select * from members m where m.`mobel`=? and m.`password`=? and m.role_id=1 and m.is_useful=1;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(name);
			easyMapsManager.setPreparedParameter(password);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean Logon(String name, String password, String sex, int city,
			int province, int zone, String mobel, String email,
			String ture_name, String id_number, String address,
			String bank_card, String pay_password) {
		DatabaseAccess dao = new DatabaseAccess();
		Date now = new Date();
		// 是这样加密吗？
		MD5 m = new MD5();
		String pw = m.md5s(password);
		// Id由用户名家密码生成
		String Id = m.md5s(name + password);
		// id自动生成，自动生成需要插入吗？
		String sql = "insert into members (Id,name,password,sex,city,province,zone,mobel,role_id,email,"
				+ "ture_name,id_number,address,bank_card,pay_password,uptime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		dao.setPreparedParameter(Id);
		dao.setPreparedParameter(name);
		dao.setPreparedParameter(pw);
		dao.setPreparedParameter(sex);
		dao.setPreparedParameter(city);
		dao.setPreparedParameter(province);
		dao.setPreparedParameter(zone);
		dao.setPreparedParameter(mobel);
		// 注册用户的身份为1
		dao.setPreparedParameter(1);
		dao.setPreparedParameter(email);
		dao.setPreparedParameter(ture_name);
		dao.setPreparedParameter(id_number);
		dao.setPreparedParameter(address);
		dao.setPreparedParameter(bank_card);
		dao.setPreparedParameter(pay_password);
		dao.setPreparedParameter(now);
		int count = dao.executeInsert(sql);
		// System.out.println(count);
		dao.close();
		return true;
	}

	// 查询是否有相同的用户名，相同则不予以注册
	public List samename(String name) {
		DatabaseAccess dao = new DatabaseAccess();
		String sql = "select * from members where name=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(name);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			dao.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean uplogintime(String id) {
		DatabaseAccess dao = new DatabaseAccess();
		Date now = new Date();
		String sql = "update members  set logintime=? AND set logincount=longcount+1 where Id=?;";
		dao.setPreparedParameter(now);
		dao.setPreparedParameter(id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	// 更新用户的数据,同时更新表的的更新时间
	public boolean updatemembers(String id, String name, String password,
			String sex, int city, int province, int zone, String mobel,
			String email, String ture_name, String id_number, String address,
			String bank_card, String pay_password) {
		DatabaseAccess dao = new DatabaseAccess();
		Date now = new Date();
		// 是这样加密吗？
		MD5 m = new MD5();
		String pw = m.md5s(password);
		String sql = "update members set name=?,password=?,sex=?,city=?"
				+ ",province=?,zone=?,mobel=?,email=?"
				+ ",ture_name=?,id_number=?,address=?,bank_card=?,pay_password=? "
				+ ",uptime=? where Id=?;";
		// System.out.println(name);
		// System.out.println(now);
		// System.out.println(id);
		dao.setPreparedParameter(name);
		dao.setPreparedParameter(pw);
		dao.setPreparedParameter(sex);
		dao.setPreparedParameter(city);
		dao.setPreparedParameter(province);
		dao.setPreparedParameter(zone);
		dao.setPreparedParameter(mobel);
		dao.setPreparedParameter(email);
		dao.setPreparedParameter(ture_name);
		dao.setPreparedParameter(id_number);
		dao.setPreparedParameter(address);
		dao.setPreparedParameter(bank_card);
		dao.setPreparedParameter(pay_password);
		dao.setPreparedParameter(now);
		dao.setPreparedParameter(id);
		boolean b = dao.executeUpdate(sql);
		dao.close();
		return b;
	}

	// 查询当前页的用户数据
	public List querymembers(int roleid, int rows, int page, String mobel,
			int delete) {
		// TODO Auto-generated method stub
		String m = "";
		if (mobel != null && !mobel.equals(""))
			m = " and mobel like '%" + mobel + "%' ";
		String sql = "select mv.* from memberview mv where mv.role_id<>? and is_useful=1 and wait_delete=? "
				+ m + " order by Id desc limit ?,?";
		// System.out.println(sql);
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(
					databaseAccess);
			easyMapsManager.setPreparedParameter(roleid);
			easyMapsManager.setPreparedParameter(delete);
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

	public List queryadmin(int rows, int page) {
		// TODO Auto-generated method stub
		String sql = "select mv.* from memberview mv where mv.role_id=1 and is_useful=1 and wait_delete=0 order by uptime desc limit ?,?;";
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

	// 查询用户总量
	public int querymemberscount(int roleid, String mobel, int delete) {

		String m = "";
		if (mobel != null && !mobel.equals(""))
			m = " and mobel like '%" + mobel + "%' ";

		// TODO Auto-generated method stub
		String sql = "select count(*) from memberview mv where mv.role_id<>? and wait_delete= ?"
				+ m;
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(roleid);
			databaseAccess.setPreparedParameter(delete);
			int count = databaseAccess.executeCount(sql);
			databaseAccess.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int queryadmincount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from memberview mv where mv.role_id=1;";
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

	public boolean updateadminrenzhen(int id, int isreco, String uptime) {
		// TODO Auto-generated method stub
		String sql = "update members set is_recognise=?,uptime=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(isreco);
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

	public boolean updateadmindel(int id, int del, String uptime) {
		// TODO Auto-generated method stub
		String sql = "update members set wait_delete=?,uptime=? where Id=? and role_id=2;";
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

	// 查询用户
	public List querymember(int id) {

		// String m = "";
		// if (mobel != null && !mobel.equals(""))
		// m = " and mobel like '%" + mobel + "%' ";
		// TODO Auto-generated method stub
		String sql = "select mv.* from memberview mv where mv.Id=?";
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

	public boolean addadmin(String name, String password, String mobel,
			String email, String uptime) {
		// TODO Auto-generated method stub
		String sql = "insert into members(`name`,`password`,`mobel`,`email`,`uptime`,role_id,is_useful,is_email,is_mobel,wait_delete,is_recognise,is_card_ok,province,city,zone,yongjin,num) values(?,?,?,?,?,1,1,0,0,0,0,0,0,0,0,0,0);";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(name);
			databaseAccess.setPreparedParameter(password);
			databaseAccess.setPreparedParameter(mobel);
			databaseAccess.setPreparedParameter(email);
			databaseAccess.setPreparedParameter(uptime);
			databaseAccess.executeInsert(sql);
			databaseAccess.close();
			// System.out.println("sql:" + sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean upadmin(int id, String name, String mobel, String email,
			String uptime) {
		// TODO Auto-generated method stub
		String sql = "update members set `name`=?,`mobel`=?,email=?,uptime=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(name);
			databaseAccess.setPreparedParameter(mobel);
			databaseAccess.setPreparedParameter(email);
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

	// 修改用户信息
	public boolean upmember(int id, String name, String miyue) {
		// TODO Auto-generated method stub
		String sql = "update members set `name`=?,`recognise_id`=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(name);
			databaseAccess.setPreparedParameter(miyue);
			databaseAccess.setPreparedParameter(id);
			databaseAccess.executeUpdate(sql);
			databaseAccess.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 修改密码
	public boolean upPass(int id, String npass, String uptime) {
		// TODO Auto-generated method stub
		String sql = "update members set `password`=?,uptime=? where Id=?;";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(npass);
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

	// 获取原密码
	public String getopPass(int id) {
		String password = "";
		// TODO Auto-generated method stub
		String sql = "select password from members where Id= ? and is_useful=1 and role_id= 1";
		try {
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			databaseAccess.setPreparedParameter(id);
			password = databaseAccess.executepass(sql);
			databaseAccess.close();

			return password;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;

	}

}
