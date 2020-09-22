package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(value = "controller")
@EnableWebMvc
public class  ServletDispatcher implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver(){
     InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
     internalResourceViewResolver.setPrefix("/WEB-INF/views/");
     internalResourceViewResolver.setSuffix(".jsp");
     return internalResourceViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/images/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new model.CustomConverter());
        registry.addConverter(new controller.CustConverter());
    }
}
