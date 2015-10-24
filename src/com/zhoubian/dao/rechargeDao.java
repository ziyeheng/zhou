package com.zhoubian.dao;

import java.util.List;

public interface rechargeDao {

	public List getrecharge(int page, int num, String mobel);

	public int queryrechargecount(String mobel);

	public int querycouponcount(String mobel, int is_use, String mobel2);

	public List getcoupon(int page, int num, String mobel, int is_use,
			String mobel2);

	public int queryredmoneycount(String mobel, String mobel2);

	public List getredmoney(int page, int num, String mobel, String mobel2);

}
