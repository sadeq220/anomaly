package config;



import model.AccountInfo;

import org.hibernate.SessionFactory;


import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;

import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.beans.PropertyEditor;
import java.time.LocalDate;
import java.util.*;


@org.springframework.context.annotation.Configuration
@ComponentScan(value = {"repository","service"})
public class RootConfig {

    @Bean(name = "arr")
    public ArrayList<AccountInfo> getArray(){

        return new ArrayList<>();
    }

    @Bean
    public SessionFactory sessionFactory(){
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(AccountInfo.class);
        SessionFactory sessionFactory=cfg.buildSessionFactory();

       return sessionFactory;
    }
    @Bean
    public static ConversionService conversionService() {
//        DefaultFormattingConversionService service= new DefaultFormattingConversionService();
//      service.addConverter(new controller.CustConverter());
        GenericConversionService conversionService=new GenericConversionService();
        conversionService.addConverter(new controller.CustConverter());
       // ConversionServiceFactoryBean

      return conversionService;
    }
}
