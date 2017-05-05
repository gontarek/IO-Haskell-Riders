package io.riders.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Controller class for the main page
 */
@Controller
public class GreetingController {

    /**
     *
     * @param name Name of the peron of thing which is to be greeted
     * @param model Model passing to the template engine
     * @return template name
     */@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
