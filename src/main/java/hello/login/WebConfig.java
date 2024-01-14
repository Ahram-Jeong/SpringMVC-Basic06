package hello.login;

import hello.login.web.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter()); // 적용할 필터
        filterRegistrationBean.setOrder(1); // 필터의 순서
        filterRegistrationBean.addUrlPatterns("/*"); // 필터를 적용할 url패턴

        return filterRegistrationBean;
    }
}
