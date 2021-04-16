package cn.cerny.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
//<context:component-scan base-package="cn.cerny"/>
@ComponentScan("cn.cerny")
//<import resource=""/>
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
