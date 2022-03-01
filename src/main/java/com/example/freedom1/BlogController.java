package com.example.freedom1;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BlogController {
    Attack2 atack = new Attack2();

    @GetMapping("/")
    public String greeting(Model model){
        //model.addAttribute("title","name");
        return "home";
    }
    @PostMapping("/select")
    public String blogPostAdd(@RequestParam String title,
                              Model model) throws Exception {
        atack.main1(title);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("select");
        //modelAndView.addObject("text",text);
        return "select";
    }
}


