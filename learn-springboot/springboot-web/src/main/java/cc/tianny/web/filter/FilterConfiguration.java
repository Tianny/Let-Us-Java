package cc.tianny.web.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/8/4
 * Time: 10:09 上午
 * Description: No Description
 */
@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilterFirst());
        registration.addUrlPatterns("/*");
        registration.setName("MyFilterFirst");
        registration.setOrder(6);
        return registration;
    }

    @Bean
    public FilterRegistrationBean test2FilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilterSecond());
        registration.addUrlPatterns("/*");
        registration.setName("MyFilterSecond");
        registration.setOrder(1);
        return registration;
    }
}
