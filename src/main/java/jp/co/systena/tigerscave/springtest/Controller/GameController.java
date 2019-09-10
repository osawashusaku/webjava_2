package jp.co.systena.tigerscave.springtest.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.springtest.Model.ChallengerForm;
import jp.co.systena.tigerscave.springtest.Model.Fighter;
import jp.co.systena.tigerscave.springtest.Model.Wizard;

@Controller
public class GameController {

  @Autowired
  HttpSession session;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView show(ModelAndView mav) {
    mav.setViewName("/MakeChallenger");
    return mav;
  }

  @RequestMapping(value = "/Command", method = RequestMethod.POST)
  public ModelAndView command(@Valid ChallengerForm form,  BindingResult result, ModelAndView mav,
                               @RequestParam(value = "job") String job,
                               @RequestParam(value = "name") String name) {

    mav.setViewName("Command");

    ChallengerForm challengerForm = new ChallengerForm();
    challengerForm.setName(name);

//    String msg;
    if (job.equals("fighter")) {
      Fighter fighter = getFighter(name);
      mav.addObject("Challenger",fighter);
      session.setAttribute("fighter", fighter);
    }else if (job.equals("wizard")) {
      Wizard wizard = getWizard(name);
      mav.addObject("Challenger",wizard);
      session.setAttribute("wizard", wizard);
    }

    return mav;
  }

  private Fighter getFighter(String name) {
    Fighter fighter = (Fighter) session.getAttribute("fighter");
    if (fighter == null) {
      fighter = new Fighter(name);
      session.setAttribute("fighter", fighter);
    }
    return fighter;
  }

  private Wizard getWizard(String name) {
    Wizard wizard = (Wizard) session.getAttribute("wizard");
    if (wizard == null) {
      wizard = new Wizard(name);
      session.setAttribute("wizard", wizard);
    }

    return wizard;
  }


  @RequestMapping(value = "/result", method = RequestMethod.POST)
  public ModelAndView result(@Valid ChallengerForm form,  BindingResult result, ModelAndView mav,
                               @RequestParam(value = "job") String job,
                               @RequestParam(value = "name") String name) {

    mav.setViewName("result");

    ChallengerForm challengerForm = new ChallengerForm();
    challengerForm.setName(name);

    if (job.equals("fighter")) {
      Fighter fighter = (Fighter) session.getAttribute("fighter");
      fighter.setName(name);
      mav.addObject("Challenger",fighter);
      session.setAttribute("fighter", fighter);
    }else if (job.equals("wizard")) {
      Wizard wizard = (Wizard) session.getAttribute("wizard");
      wizard.setName(name);
      mav.addObject("Challenger",wizard);
      session.setAttribute("wizard", wizard);
    }

    return mav;
  }
}
