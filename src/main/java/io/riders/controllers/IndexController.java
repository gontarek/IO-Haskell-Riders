package io.riders.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tommy on 5/5/2017.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }
}
