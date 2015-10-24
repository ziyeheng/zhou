package com.zhoubian.dao;

import java.util.List;

public interface modul_categoryDao {
	public List querymodul_category(int category_id, int rows, int page);

	public boolean savemodul_category(int id, String name);

	public boolean updatemodul_category(int id, String name);

	public List getsecondmodul_category(int first_mcid);

	public List querymodulecategory(int categoryid, int type, int rows, int page);

	public boolean savemodulCategory(String name, int categoryid, int type,
			int order, String uptime, int isdelete);

	public List queryModulCatgory(int categoryid);

	public int querymodulecategorycount(int categoryid, int type);

	public List querymodulcategory(int id);

	public boolean upmodulCategory(int id, String name, int order, String uptime);

	public boolean upmodulcategorydel(int id, int del, String uptime);

}
