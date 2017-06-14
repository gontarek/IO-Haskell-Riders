package io.riders.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main application controller.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }
}
