package com.spring.application.controller;


import com.spring.application.entity.Athlete;
import com.spring.application.entity.Country;
import com.spring.application.entity.Medal;
import com.spring.application.service.AthleteService;
import com.spring.application.service.MedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAspectJAutoProxy
@RequestMapping("/medal")
public class MedalController {
    MedalService medalService;
    @Autowired
    AthleteService athleteService;

    @Autowired
    MedalController(MedalService medalService){
        this.medalService=medalService;
    }
    @GetMapping("/list")
    public String listMedals(Model theModel) {

        List<Medal> medals = medalService.findAll();

        // add to the spring model
        theModel.addAttribute("medals", medals);


        return "medals/medals-list";
    }



    @GetMapping("/add")
    public String addMedal(Model model){
        Medal medal=new Medal();
        model.addAttribute("medal",medal);
        return "medals/medals-form";
    }
    @GetMapping("/country")
    public String country(Model model){

        List<Medal> medalList=medalService.findAll();
        Map<String, Country> map=new HashMap<>();
        for(Medal medal :medalList){
            Country country=new Country(medal.getAthlete().getCountry(),medal.getGold(), medal.getSilver(),medal.getBronze());
            if(map.containsKey(medal.getAthlete().getCountry())){
                Country prev=map.get(medal.getAthlete().getCountry());
                country.add(prev);
                map.put(medal.getAthlete().getCountry(),country);
            }
            else{
                map.put(medal.getAthlete().getCountry(),country);}
        }
        List<Country> countryList=new ArrayList<>();
        for(Country country: map.values()){
            countryList.add(country);
        }
        model.addAttribute("countries", countryList);

        return "medals/country-list";
    }



    @PostMapping("/save")
    public String saveMedals(@ModelAttribute("medal")  Medal theMedal,
        BindingResult bindingResult) {

            if (bindingResult.hasErrors()) {
                return "medals/medals-form";
            }
            else {
                int id= theMedal.id;
                Athlete athlete=athleteService.findById(id);
                if(athlete==null)
                {
                    ObjectError error = new ObjectError("globalError", "Enter correct Athlete id");
                    bindingResult.addError(error);
                    return "medals/medals-form";

                }
                medalService.save(theMedal);

                // use a redirect to prevent duplicate submissions
                return "redirect:/medal/list";
            }


    }
    @GetMapping("/update")
    public String update(@RequestParam("id") int theId,
                         Model theModel) {

        Medal medal = medalService.findById(theId);
        theModel.addAttribute("id",theId);

        theModel.addAttribute("medal", medal);

        // send over to our form
        return "medals/medals-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int theId) {


        medalService.deleteById(theId);


        return "redirect:/medal/list";

    }
    @GetMapping("/finance")
    public String finance(Model model){
        return "finance";
    }

    @GetMapping("/athlete/{id}")
    public String athlete(Model model, @PathVariable int id){
        Athlete athlete =athleteService.findById(id);

        if (athlete == null) {
            throw new RuntimeException("Athlete not found ");
        }
        model.addAttribute("athlete",athlete);
        return "athlete";

    }

}
