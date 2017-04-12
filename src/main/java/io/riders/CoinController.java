package io.riders;

import io.riders.models.CoinModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoinController {

    @RequestMapping("/coin")
    public @ResponseBody CoinModel coinToss() {
        return new CoinModel((int)Math.round(Math.random()));
    }
}
