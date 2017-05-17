package io.riders.controllers;

import io.riders.models.DiceModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Controller for dice model
 */
@Controller
public class DiceController {
    
    @RequestMapping(value = "/dice", method = RequestMethod.GET)
    public String coin() {
        return "dicethrow";
    }

    /**
     *
     * @param diceType
     * @return DiceModel
     */
    @RequestMapping(value = "/dice", method = RequestMethod.POST)
    public
    @ResponseBody
    DiceModel coinToss(@RequestParam(value = "type", required = false, defaultValue = "k6") String diceType) {
        if ("k6".equals(diceType)) {
            return DiceModel.throwDice();
        } else {
            throw new NotImplementedException();
        }
    }
}
