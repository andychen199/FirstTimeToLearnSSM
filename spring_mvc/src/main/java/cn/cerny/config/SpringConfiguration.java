package cn.cerny.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//<context:component-scan base-package="cn.cerny"/>
@ComponentScan("cn.cerny")
//<import resource=""/>
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
