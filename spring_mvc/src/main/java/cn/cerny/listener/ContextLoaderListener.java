package cn.cerny.listener;

import cn.cerny.config.SpringConfiguration;
import cn.cerny.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        //读取web.xml中的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //将Spring的应用上下文对象存储到ServletContext域中
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        //ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        servletContext.setAttribute("app",app);
        System.out.println("Spring容器創建完畢！");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
