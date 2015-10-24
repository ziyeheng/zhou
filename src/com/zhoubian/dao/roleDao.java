package com.zhoubian.dao;

import java.util.List;

public interface roleDao {
	public boolean updatemaxnum(String maxnum);
	
	public String getredmaxnum();

	public List queryrole(int Id, int rows, int page);

	public boolean saverole(int id, int name);

	public boolean updaterole(int id, int name);

	public List queryrole(int rows, int page);

	public int queryrolecount();

	public boolean updaterolestate(int id, int state, String uptime);

	public boolean addrole(String name, String uptime);

	public List queryRole(int id);

	public boolean uprole(int id, String name, String uptime);
}
