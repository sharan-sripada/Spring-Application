package com.spring.application.controller;


import com.spring.application.entity.Medal;
import com.spring.application.service.MedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    MedalService medalService;
    @GetMapping("/loginPage")
    public String loginPage() {

        return "login";

    }

    // add request mapping for /access-denied

    @GetMapping("/denied")
    public String accessDenied() {

        return "denied";

    }
    @PostMapping("/save")
    public String saveMedals(@ModelAttribute("medal") Medal theMedal,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "medals/medals-form";
        }
        else {

            medalService.save(theMedal);

            // use a redirect to prevent duplicate submissions
            return "redirect:/medal/list";
        }

    }
    @RequestMapping("/")
    public String index() {
        return "redirect:/medal/list";
    }

}