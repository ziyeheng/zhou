package com.zhoubian.dao.impl;

import java.util.List;

import com.zhoubian.dao.dictionaryDao;
import com.zhoubian.util.DatabaseAccess;
import com.zhoubian.util.EasyMapsManager;

public class dictionaryDaoImpl implements dictionaryDao {

        public List querydictionary(int Id,int rows,int page) {
		// TODO Auto-generated method stub
		String sql = "select d.Id,d.name from dictionary d where d.Id=? LIMIT ?,?;";
		try{
			DatabaseAccess databaseAccess = new DatabaseAccess(false);
			EasyMapsManager easyMapsManager = new EasyMapsManager(databaseAccess);
			easyMapsManager.setPreparedParameter(Id);
			easyMapsManager.setPreparedParameter((page - 1) * rows);
			easyMapsManager.setPreparedParameter(rows);
			List list = easyMapsManager.executeQuery(sql);
			databaseAccess.close();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

        public boolean saveDictionary(int id,String name){
    		DatabaseAccess dao=new DatabaseAccess();
    		String sql="insert into dictionary(Id,name) values(?,?)";
    		dao.setPreparedParameter(id);
    		dao.setPreparedParameter(name);
    		boolean b=dao.executeInsert(sql)>0?true:false;
    		dao.close();
    		return b;
    	}
    	
    	public boolean updateDictionary(int id,String name){
    		DatabaseAccess dao=new DatabaseAccess();
    		String sql="update dictionary set name=? where Id=?;";
    		dao.setPreparedParameter(name);
    		dao.setPreparedParameter(id);
    		boolean b=dao.executeUpdate(sql);
    		dao.close();
    		return b;
    	}

		public List querydic(int type) {
			// TODO Auto-generated method stub
			String sql = "select d.Id,d.name from dictionary d where d.type=? order by d.Id;";
			try{
				DatabaseAccess databaseAccess = new DatabaseAccess(false);
				EasyMapsManager easyMapsManager = new EasyMapsManager(databaseAccess);
				easyMapsManager.setPreparedParameter(type);
				List list = easyMapsManager.executeQuery(sql);
				databaseAccess.close();
				return list;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
}
