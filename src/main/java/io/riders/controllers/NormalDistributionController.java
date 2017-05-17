package io.riders.controllers;

import io.riders.models.DiceModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mruga on 18.05.2017.
 */
@Controller
public class NormalDistributionController {
    @RequestMapping(value = "/normaldist", method = RequestMethod.GET)
    public String normaldist() {
        return "normaldist";
    }
    @RequestMapping(value = "/dice", method = RequestMethod.POST)
    public @ResponseBody String coinToss(){
        return "Not implemented";
    }
}
