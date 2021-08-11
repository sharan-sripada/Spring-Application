package com.spring.application.controller;

import com.spring.application.entity.Athlete;
import com.spring.application.entity.Medal;
import com.spring.application.service.AthleteService;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@EnableAspectJAutoProxy
@RequestMapping("/athlete")
public class AthleteController {
    AthleteService athleteService;
    AthleteController(AthleteService athleteService){
        this.athleteService=athleteService;
    }
    @GetMapping("/list")
    public String listathletes(Model theModel) {

        List<Athlete> athletes = athleteService.findAll();

        // add to the spring model
        theModel.addAttribute("athletes", athletes);


        return "athlete/athlete-list";
    }
    @GetMapping("/add")
    public String addAthlete(Model model){
        Athlete athlete=new Athlete();
        model.addAttribute("athlete",athlete);
        return "athlete/athlete-form";
    }
    @PostMapping("/save")
    public String saveAthlete(@ModelAttribute("athlete")  Athlete athlete,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return "athlete/athlete-form";
        }
        else {
            if(athlete.getName().isEmpty()||athlete.getCountry().isEmpty()){
                ObjectError error = new ObjectError("globalError", "Cannot be null");
                bindingResult.addError(error);
                return "athlete/athlete-form";
            }

            athleteService.save(athlete);

            // use a redirect to prevent duplicate submissions
            return "redirect:/athlete/list";
        }


    }
    @GetMapping("/update")
    public String update(@RequestParam("id") int theId,
                         Model theModel) {

        Athlete athlete = athleteService.findById(theId);
        theModel.addAttribute("id",theId);

        theModel.addAttribute("athlete", athlete);

        // send over to our form
        return "athlete/athlete-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int theId) {


        athleteService.deleteById(theId);


        return "redirect:/athlete/list";

    }
}
