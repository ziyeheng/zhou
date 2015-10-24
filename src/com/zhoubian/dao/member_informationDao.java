package com.zhoubian.dao;

import java.util.List;

public interface member_informationDao {
             
	 public List querymember_information(String member_id,int information_id,int rows,int page);
	 public boolean savemember_information(int Id,String member_id,int information_id);
	 public boolean updatemember_information(String comment_content,int is_zan,int is_rescend,
			 String member_id,int information_id);
	 public boolean dianzanmember_information(String member_id, int information_id);
	 public boolean zhuanfamember_information(String member_id, int information_id);
	 public boolean pinlunmember_information(String member_id, int information_id,
			String comment_content);
	 
	 public List queryMeberInformation(int rows,int page);
	 
	 public int querycountMember();
	 
	 public List queryMI(int id);
	 
	 public boolean updateMId(int id,int del);
}
