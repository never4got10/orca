package org.nettoall.orca.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingMvcController {

    /**
     *
     * @param name @RequestParam required, defaultValue 설정
     * @param model
     * @return
     */
    @GetMapping("/greetingmvc")
    public String greeting(@RequestParam(name="name", required = false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
