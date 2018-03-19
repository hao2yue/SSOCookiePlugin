
package com.doctorai.kisso.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

/**
 * <p>
 * Kisso 配置启动监听
 * </p>
 * 
 * @author zhaoshihao
 * @Date 2015-02-06
 */
@WebListener
public class KissoConfigListener implements ServletContextListener {

	protected static final Logger logger = Logger.getLogger("KissoConfigListener");


	/**
	 * 初始化
	 */
	public void contextInitialized( ServletContextEvent sce ) {
		new WebKissoConfigurer().initKisso(sce.getServletContext());
	}


	/**
	 * 销毁
	 */
	public void contextDestroyed( ServletContextEvent sce ) {
		logger.info("Uninstalling Kisso ");
	}

}
