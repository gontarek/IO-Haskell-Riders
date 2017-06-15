package io.riders.controllers.advice;

import java.security.Principal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Controller advice dedicated to adding logged user name to all controllers models
 */
@ControllerAdvice
public class GlobalControllerAdvice {

  /**
   * Method which adds user name to all models
   * @param model given by SpringBoot framework
   * @param principal logged user given by SpringBoot framework
   */
  @ModelAttribute
  public void loggerUserName(Model model, Principal principal) {
    if(principal != null) {
      model.addAttribute("userName", principal.getName());
    }
  }
}
