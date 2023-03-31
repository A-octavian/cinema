package com.example.cinemaproiectis.controllers;

import com.example.cinemaproiectis.models.User;
import com.example.cinemaproiectis.repositories.UserRepository;
import com.example.cinemaproiectis.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Objects;

@Controller
public class UserController {
    private UserRepository userRepository;
    private UserService userService;
    public UserController(UserService userService,UserRepository userRepository) {
        super();
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ModelAndView getUsers(Model model){
        ModelAndView mav = new ModelAndView("users.html");
        mav.addObject("users",userRepository.findAll());
        return mav;
    }
    @RequestMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView("register.html");
        return mav;
    }

    @RequestMapping(value = "/registerNewUser")
    public ModelAndView registerNewUser(HttpServletRequest request, @RequestParam(name = "userType") String userType,@RequestParam(name = "fName") String fName, @RequestParam(name = "lName") String lName,@RequestParam(name = "email") String email, @RequestParam(name = "phoneNumber") String phoneNumber, @RequestParam(name = "pass1") String pass1,@RequestParam(name = "pass2") String pass2) {
        User user = new User(false,false,fName,lName,email,pass1,phoneNumber);
        userService.registerNewUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        ModelAndView mav = new ModelAndView("app.html");
        return mav;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login.html");
        return mav;
    }

    @RequestMapping(value = "/loginUser")
    public ModelAndView loginUser(HttpServletResponse response, HttpServletRequest request, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password, @RequestParam(required = false,name = "savePass") String savePass) {
        ArrayList<String> errors = new ArrayList<>();
        if( userRepository.findUserByEmail(email).isPresent()){
            if(!Objects.equals(userRepository.findUserByEmail(email).get().getPassword(), password)){
                errors.add("Wrong password!");
            }
        }else {
            errors.add("Wrong email!");
        };
        if (errors.size() > 0) {
            ModelAndView mav2 = new ModelAndView("login.html");
            mav2.addObject("errors", errors);
            return mav2;
        } else {
            ModelAndView mav = new ModelAndView("app.html");
            if ( savePass != null ) {
                Cookie cookie = new Cookie("email", email);
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                cookie.setMaxAge(60*60*60);
                response.addCookie(cookie);
            }
            return mav;
        }

    }

    @RequestMapping(value = "/admin")
    public ModelAndView admin() {
        ModelAndView mav = new ModelAndView("admin.html");
        return mav;
    }

    @RequestMapping(value = "/logout")
    public RedirectView logOut(HttpServletRequest request,HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        request.getSession().invalidate();
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");
        return redirectView;
    }

}
