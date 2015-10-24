package com.zhoubian.dao;

import java.util.List;

public interface member_yongjinDao {

	public List querymerber_yongjin(int Id,String member_id,int yongjin_id,int rows,int page);
    public List querycomplete(int rows,int page);
    public boolean delectmember_yongjin(int Id,String member_id,int yongjin_id);
	public List jiedanmerber_yongjin(String member_id, int rows, int page);
	public boolean updatemember_yongjin(int id, String memberId, int yongjinId);
	public boolean getyongjin(String memberId, int yongjinId);
	
	public List queryMemberYongjin(int rows,int page);
	
	public int querymemberyongjincount();
	
	public List querymyj(int id);
	
	public boolean updatemyj(int id,int del);
}
