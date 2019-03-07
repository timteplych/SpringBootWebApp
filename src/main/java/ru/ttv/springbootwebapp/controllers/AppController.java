package ru.ttv.springbootwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ttv.springbootwebapp.model.User;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class AppController {

    @GetMapping(value = "/")
    public String mainPage(Model model){
        DateFormat dateFormat = DateFormat.getDateInstance();
        model.addAttribute("currentDate", dateFormat.format(new Date()));
        return "index";
    }

    @GetMapping(value = "/register")
    public String getRegister(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/register")
    public String postRegister(@ModelAttribute("userData")User user){
        System.out.println(user);
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String postLogin(@RequestParam("login") String login, @RequestParam("password") String password){
        System.out.println(login);
        System.out.println(password);
        return "redirect:/";
    }

}
