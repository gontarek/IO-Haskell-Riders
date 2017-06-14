package io.riders.controllers;

import io.riders.models.LottoModel;
import io.riders.models.SequenceModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for random Lotto numbers
 */
@Controller
public class LottoController {

    /**
     * Rendering lotto view
     * @return view name as string
     */
    @RequestMapping("/lotto")
    public String lotto() {
        return "lotto";
    }

    /**
     * Api endpoint for returning the Lotto numbers as json
     * @return Lotto model rendered to JSON
     */
    @RequestMapping(value = "/api/lotto", method = RequestMethod.POST)
    public @ResponseBody
    LottoModel lottoApi() {
        return new LottoModel();
    }
}
