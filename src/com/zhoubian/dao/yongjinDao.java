package com.zhoubian.dao;

import java.util.List;

import com.zhoubian.table.*;

public interface yongjinDao {
	public List queryyonjin(int Id, int city, int first_mcid, String member_id,
			int province, int second_mcid, int zone, int rows, int page);

	public boolean saveyongjin(int id, String name);

	public boolean updateyongjin(int id, String businessname, String sjaddress,
			String discription, String phone, String range1);

	public int addyongjin(Yongjin y);

	public List querynearby(String longitude, String latitude, int second_mcid,
			int page, int rows);

	public List screenbottom(int city, String member_id, int province,
			int first_mcid, int second_mcid, int zone, int is_ok, int rows,
			int page);

	public List publisheryongjin(String id, int rows, int page);

	public boolean receiveyonjin(int yongjin_id);

	public List queryYongJin(int rows, int page);

	public List queryyongjin(int categoryid, int page, int num, String mobel);

	public int queryyongjincount(int categoryid, String mobel);

	public boolean updateyongjinok(int id, int isok);

	public boolean updateyongjindel(int id, int del);

	public List queryyongjin(int yongjinid);

	public String querycategoryname(int id);

}
