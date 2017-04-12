package io.riders;

import io.riders.models.CoinModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Controller class for coin page
 */
@Controller
public class CoinController {
    /**
     * @return CoinModel initized with random number
     */
    @RequestMapping("/coin")
    public @ResponseBody CoinModel coinToss() {
        return new CoinModel((int)Math.round(Math.random()));
    }
}
