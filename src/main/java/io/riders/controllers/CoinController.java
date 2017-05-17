package io.riders.controllers;

import io.riders.models.CoinModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller class for coin model
 */
@Controller
public class CoinController {

    @RequestMapping(value = "/coin", method = RequestMethod.GET)
    public String coin() {
        return "cointoss";
    }

    /**
     * @return CoinModel initialized with random number
     */
    @RequestMapping(value = "/coin", method = RequestMethod.POST)
    public
    @ResponseBody
    CoinModel coinToss() {
        return new CoinModel((int) Math.round(Math.random()));
    }
}
