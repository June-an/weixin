package com.yc.web.listeners;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.bean.AdminType;
import com.yc.biz.AdminTypeBiz;


/**
 * 当servlet容器一启动就会加载这个类
 *
 */
public class InitListener implements ServletContextListener {
	private ApplicationContext ac;

    public InitListener() {

    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	//取application
    	ServletContext application = sce.getServletContext();
    	ac = WebApplicationContextUtils.getWebApplicationContext(application);
    	//获取管理员的所有类别，存到application中的adminTypeList
    	AdminTypeBiz typeBiz = (AdminTypeBiz) ac.getBean("adminTypeBizImpl");
    	List<AdminType> adminTypeList = typeBiz.getTypeList();
    	application.setAttribute("adminTypeList", adminTypeList);
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }
	
}
