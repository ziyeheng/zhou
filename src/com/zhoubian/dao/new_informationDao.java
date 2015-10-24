package com.zhoubian.dao;

import java.util.List;

public interface new_informationDao {
	     //取出佣金社区表中显示的所有内容
         public List querynew_information(int rows,int page);
         public boolean updatenew_information(int id,String content);
		 public boolean savenew_information(String content, String member_id,String img_url);
		 public boolean liulannew_information(int informationId);
		 public boolean dianzannew_information(int information_id);
		 public boolean zhuanfanew_information(int information_id);
		 public boolean pinglunnew_information(int information_id);
		 public List querycompletenew_information(int rows, int page);
		 
		 public List queryNewInformation(int rows,int page);
		 
		 public int querynewinformationcount();
		 
		 public boolean upnidel(int id,int del,String uptime);
		 
		 public List queryNI(int id);
}
