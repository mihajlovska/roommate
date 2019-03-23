package com.roommate.api.web.controller;

import com.roommate.api.domain.UserService;
import com.roommate.api.model.Users;
import com.roommate.api.security.SecurityService;
import com.roommate.api.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam.Mode;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public ModelAndView registration(Model model) {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("userForm", new Users());
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute("userForm") Users userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        ModelAndView modelAndView = new ModelAndView("registration");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        modelAndView.setViewName("redirect:welcome");

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(Model model, String error, String logout) {
        ModelAndView modelAndView = new ModelAndView("login");

        if (error != null)
            modelAndView.addObject("error", "Your username and password is invalid.");

        if (logout != null)
            modelAndView.addObject("message", "You have been logged out successfully.");

        return modelAndView;
    }

    @GetMapping({"/", "/welcome"})
    public ModelAndView welcome(Model model) {
        return new ModelAndView("welcome");
    }
}
