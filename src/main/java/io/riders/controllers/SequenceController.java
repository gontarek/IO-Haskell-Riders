package io.riders.controllers;

import io.riders.models.SequenceModel;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * Created by mruga on 11.06.2017.
 */
@Controller
public class SequenceController {

    @RequestMapping("/sequence")
    public String sequence() {
        return "sequence";
    }

    @RequestMapping(value = "/sequence", method = RequestMethod.POST)
    public @ResponseBody SequenceModel sequence(@RequestParam(value = "length",
                                                              required = false,
                                                              defaultValue = "10") int length) {
        return new SequenceModel(length);
    }
}
