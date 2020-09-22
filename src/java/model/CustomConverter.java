package model;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CustomConverter implements Converter<String[], LocalDate> {
    @Override
    public LocalDate convert(String[] s) {
        String sA=String.format("%s-%s-%s",s[0],s[1],s[2]);
      try{  return  LocalDate.parse(sA);}catch(DateTimeParseException e){
          throw new RuntimeException("inter your birthday");
      }
    }
}
