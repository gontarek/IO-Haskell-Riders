package io.riders.controllers;

import io.riders.models.LottoModel;
import io.riders.models.SequenceModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mruga on 14.06.2017.
 */
@Controller
public class LottoController {

    @RequestMapping("/lotto")
    public String lotto() {
        return "lotto";
    }

    @RequestMapping(value = "/api/lotto", method = RequestMethod.POST)
    public @ResponseBody
    LottoModel lottoApi() {
        return new LottoModel();
    }
}
