package com.zhoubian.main;

import java.util.List;

import com.zhoubian.dao.categoryDao;
import com.zhoubian.dao.dictionaryDao;
import com.zhoubian.dao.member_yongjinDao;
import com.zhoubian.dao.membersDao;
import com.zhoubian.dao.modul_categoryDao;
import com.zhoubian.dao.impl.categoryDaoImpl;
import com.zhoubian.dao.impl.dictionaryDaoImpl;
import com.zhoubian.dao.impl.member_yongjinDaoImpl;
import com.zhoubian.dao.impl.membersDaoImpl;
import com.zhoubian.dao.impl.modul_categoryDaoImpl;

import java.io.PrintWriter;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         categoryDao m=new categoryDaoImpl();
		List list=m.querysonpage(5);
		if(list.size()>0){
			System.out.println(list);
			System.out.println("success!");
		}
		else
		{
			System.out.println("error");
		}

}
}