package com.zhoubian.dao;

import java.util.List;

public interface platform_activityDao {
        public List queryplatform_activity(int rows,int page);
        public boolean saveplatform_activity(int id,String name);
        public boolean updateplatform_activity(int id,String name);
        
        public List queryPlatformActivity(int rows,int page,int cat);
        
        public int queryplatformactivitycount(int cat);
        
        public boolean updateplatformdel(int id,int del,String uptime);
        
        public boolean addplatform(int categoryid,String title,String content,String imgurl,int order,String starttime,String endtime,String uptime,int del);
        
        public List queryPlatformAct(int id);
        
        public boolean upplatform(int id,int categoryid,String title,String content,String imgurl,int order,String starttime,String endtime,String uptime,int del);
        
}
