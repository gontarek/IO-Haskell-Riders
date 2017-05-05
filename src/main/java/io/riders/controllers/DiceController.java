package io.riders.controllers;

import io.riders.models.DiceModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Controller
public class DiceController {

    @RequestMapping("/dice")
    public @ResponseBody
    DiceModel coinToss(@RequestParam(value="type", required=false, defaultValue="k6") String diceType) {
        if ("k6".equals(diceType)) {
            return DiceModel.throwDice();
        } else {
            throw new NotImplementedException();
        }
    }
}
