package io.riders.controllers;


import io.riders.services.HistoryService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller dedicated to showing history
 */
@Controller
public class HistoryController {

  private final HistoryService historyService;

  @Autowired
  public HistoryController(HistoryService historyService) {
      this.historyService = historyService;
  }

  /**
   * rendering history view
   * @param model given by SpringBoot framework
   * @param p principal given by SpringBoot framework
   * @return view name as a string
   */
  @RequestMapping(value = "/history", method = RequestMethod.GET)
  public String showHistory(Model model, Principal p) {
      model.addAttribute("entries", historyService.findAllByUser(p.getName()));
      return "history";
  }
}
