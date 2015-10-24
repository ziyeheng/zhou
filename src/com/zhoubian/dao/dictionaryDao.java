package com.zhoubian.dao;

import java.util.List;

public interface dictionaryDao {
	public List querydictionary(int Id,int rows,int page); 
	public boolean saveDictionary(int id,String name);
    public boolean updateDictionary(int id,String name);
    
    public List querydic(int type);
}
