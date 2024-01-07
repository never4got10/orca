package org.nettoall.orca.validating.controller;

import org.nettoall.orca.validating.form.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.validation.Valid;

@Controller
public class ValidateController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/validate")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    /**
     * @Valid : Fofm 에 입력한 필드들을 수집하여 PersonForm에 바인딩
     *
     * @param personForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/validate")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }
}
