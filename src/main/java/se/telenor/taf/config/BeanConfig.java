package se.telenor.taf.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Properties;

@Configuration
public class BeanConfig {

    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String host;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${selenium.timeout}")
    private String timeoutValue;

//    @Bean
//    public WebDriverFacade webDriverFacade() {
//        return new WebDriverFacade(Long.parseLong(timeoutValue));
//    }

//    @Bean(name = "dataHolder")
//    public DataHolder dataHolder(){
//        return new DataHolder();
//    }

    @SneakyThrows
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        Properties properties = new Properties();
        properties.setProperty("driverClassName", "org.postgresql.Driver");
        DriverManagerDataSource dmds = new DriverManagerDataSource(host, userName, password);
        dmds.setDriverClassName(driver);
        dmds.setConnectionProperties(properties);
        return dmds;
    }
}
