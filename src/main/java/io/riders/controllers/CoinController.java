package io.riders.controllers;

import io.riders.models.CoinModel;
import io.riders.models.HistoryEntry;
import io.riders.models.User;
import io.riders.services.HistoryService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller class for coin page
 */
@Controller
public class CoinController {

    private final HistoryService historyService;

    @Autowired
    public CoinController(HistoryService historyService) {
        this.historyService = historyService;
    }


    @RequestMapping(value = "/coin", method = RequestMethod.GET)
    public String coin() {
        return "cointoss";
    }

    /**
     * @return CoinModel initized with random number
     */
    @RequestMapping(value = "/coin", method = RequestMethod.POST)
    public
    @ResponseBody
    CoinModel coinToss(Principal p) {
        CoinModel coinModel = new CoinModel((int) Math.round(Math.random()));

        historyService.saveOrUpdate(new HistoryEntry(p.getName(),
                                                     "coin toss",
                                                     String.valueOf(coinModel.getValue())));
        return coinModel;
    }
}
