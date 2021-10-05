package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import apap.tutorial.cineplux.service.BioskopService;

import java.util.List;
import apap.tutorial.cineplux.model.BioskopModel;

@Controller
public class BaseController {

    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @GetMapping("/")
    private String home(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        model.addAttribute("listBioskop", listBioskop);
        return "home";
    }

//    public String listBioskop(Model model) {
//        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
//        model.addAttribute("listBioskop", listBioskop);
//        return "viewall-bioskop";
//    }
    //    @RequestMapping("/error")
    //    public String handleError() {
    //        return "error-message";
    //    }
}
