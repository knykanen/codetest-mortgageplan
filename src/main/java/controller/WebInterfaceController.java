package controller;

import model.WebForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebInterfaceController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getWebForm(Model model) {
        model.addAttribute("webForm", new WebForm());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String calculate(@ModelAttribute(name="webForm") WebForm webForm) {
        return "index";
    }
}
