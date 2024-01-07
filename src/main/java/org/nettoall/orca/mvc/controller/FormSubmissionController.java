package org.nettoall.orca.mvc.controller;

import org.nettoall.orca.mvc.model.Hola;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormSubmissionController {

    @GetMapping("/hola")
    public String holaForm(Model model) {
        model.addAttribute("hola", new Hola());
        return "hola";
    }

    @PostMapping("/hola")
    public String holaSubmit(@ModelAttribute Hola hola, Model model) {
        model.addAttribute("hola", hola);
        return "result";
    }
}
