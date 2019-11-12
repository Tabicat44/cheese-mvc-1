package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseData;
import org.launchcode.models.CheeseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;


    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeseDao.findAll()/*CheeseData.getAll()*/);
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());  /*Don't need keyword cuz we put it
                                           as an object in the template
                                           By default; it will detect the
                                           name of the class*/
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors, Model model) {


        //Says that if the user types something in wrong
        //to reload the page, and make them start over

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";

        }

        cheeseDao.save(newCheese)
//        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeseDao.findAll()/*CheeseData.getAll()*/);
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            cheeseDao.delete(cheeseId);
//            CheeseData.remove(cheeseId);
        }

        return "redirect:";
    }
/*
    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId){
        Cheese chosenCheese = CheeseData.getById(cheeseId);


        *//*        for (Cheese candidateCheese : CheeseData.cheeses){
            if (candidateCheese.getCheeseId() == cheeseId){
                chosenCheese = candidateCheese;
            }
        }*//*
        model.addAttribute(chosenCheese);
        return "cheese/edit";

    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute Cheese theCheese){
        CheeseData.update(theCheese);

            return "redirect:/cheese";

    }*/


}

