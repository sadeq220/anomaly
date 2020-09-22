package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustConverter implements Converter<String, LocalDate> {
    @Override

    public LocalDate convert(String s) {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yy/MM/dd");
        
        return LocalDate.parse(s);
    }
}
