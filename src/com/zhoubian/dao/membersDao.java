package com.zhoubian.dao;

import java.util.Date;
import java.util.List;

public interface membersDao {
	public boolean upmember(int id,String name,String miyue);
	
	public List querymembersDao(int Id, int city, int province, int zone,
			int role_id, int rows, int page);

	public boolean savemembers(int id, String name);

	public boolean updatemembers(String id, String name, String password,
			String sex, int city, int province, int zone, String mobel,
			String email, String ture_name, String id_number, String address,
			String bank_card, String pay_password);

	// 登录
	public List login(String name, String password);

	// 注册
	public boolean Logon(String name, String password, String sex, int city,
			int province, int zone, String mobel, String email,
			String ture_name, String id_number, String address,
			String bank_card, String pay_password);

	public List samename(String name);

	public boolean uplogintime(String id);

	public List querymembers(int roleid, int rows, int page,String mobel,int delete);

	public int querymemberscount(int roleid,String mobel,int delete);

	public List queryadmin(int rows, int page);

	public int queryadmincount();

	public boolean updateadminrenzhen(int id, int isreco, String uptime);

	public boolean updateadmindel(int id, int del, String uptime);

	public List querymember(int id);

	public boolean addadmin(String name, String password, String mobel,
			String email, String uptime);

	public boolean upadmin(int id, String name, String mobel, String email,
			String uptime);

	public boolean upPass(int id, String npass,String uptime);
	public String getopPass(int id);
	
}
