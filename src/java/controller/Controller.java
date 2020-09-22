package controller;

import model.AccountInfo;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;


@org.springframework.stereotype.Controller
@PropertySource("classpath:/app.properties")
public class Controller {
    @Autowired
ArrayList arr;
    @Autowired
   private UserService userService;

    @Value("1990-09-11")
     private LocalDate date;

    @GetMapping("/date")
    public ResponseEntity<LocalDate> getDate(){
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(date);
    }
    @RequestMapping(value = {"/home","/"})
    public String home(){

        return "home";
    }
    @GetMapping("/registery")
    public String set(Model model){
        model.addAttribute("info",new AccountInfo());
        return "registery";
    }
@PostMapping("/registery")
    public String register(@Valid @ModelAttribute("info") AccountInfo info, BindingResult br){
        if(br.hasErrors()){
            return "registery";
        }else{
        arr.add(info);
        userService.saveDB(info);
        System.out.println(info);
        return "redirect: home";}
}
@RequestMapping("/panel")
    public String panel(Model model){
        model.addAttribute("listInfo",userService.getList());
        return "panel";
}
@GetMapping("/logIn-page")
    public String logIn(){
        return "logIn-page";
}
@PostMapping("/logIn-page")
    public String confirm(@RequestParam(name = "username") String username,@RequestParam(name="password")String password,Model model){

        if(userService.find(username,password)){
            try {
                String s=URLEncoder.encode(username, StandardCharsets.UTF_8.toString());
                return "redirect: userAccount/"+s;
            } catch (UnsupportedEncodingException e) {
                model.addAttribute("userStatus", "your Account not Available");
                return "logIn-page";

            }

        }else {
            model.addAttribute("userStatus", "your Account not Available");
            return "logIn-page";
        }
}
@RequestMapping("/userAccount/{username}")
    public String account(@PathVariable String username, Model model){
model.addAttribute("userAccount",userService.getAccount(username));

        return "userAccount";
}
}
