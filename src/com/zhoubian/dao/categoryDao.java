package com.zhoubian.dao;

import java.util.List;

public interface categoryDao {
       public List querycategory(int rows,int page); 
       public boolean saveCategory(int id,String name);
       public boolean updateCategory(int id,String name);
       public List  querycategoryfour();
	   public List querybottom();
	   public List querysonpage(int id);
	   public List queryonelateral();
	   public List querysecondlateral(int id);
	   
	   public List queryallcategory(int rows,int page);
	   
	   public boolean saveCategory(String name, int modul,int type,int order,int state,String pic_url,String content,String uptime,int isdelete);
	   
	   public List queryCategory(int id);
	   
	   public boolean upCategory(int id,String name, int modul,int type,int order,int state,String pic_url,String content,String uptime,int isdelete);
	   
	   public boolean delCategory(int id,String uptime,int isdelete);
	   
	   public int querycategorycount();
	   
	   public boolean upCategoryAll(int id,String name, int modul,int type,int order,int state,String pic_url,String content,String uptime,int isdelete);
	   
}
