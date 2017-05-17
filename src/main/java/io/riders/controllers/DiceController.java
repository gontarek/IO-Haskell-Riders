package io.riders.controllers;

import io.riders.models.DiceModel;
import io.riders.models.HistoryEntry;
import io.riders.services.HistoryService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
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

  private final HistoryService historyService;

  @Autowired
  public DiceController(HistoryService historyService) {
    this.historyService = historyService;
  }

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
  public @ResponseBody DiceModel coinToss(
      @RequestParam(value = "type", required = false, defaultValue = "k6") String diceType,
      Principal p
                                         ) {

    if (!"k6".equals(diceType)) {
      throw new NotImplementedException();
    }

    DiceModel diceModel = DiceModel.throwDice();

    historyService.saveOrUpdate(new HistoryEntry(p.getName(),
                                                 "dice roll",
                                                 String.valueOf(diceModel.getValue())));
    return diceModel;
  }
}
