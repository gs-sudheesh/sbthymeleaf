package com.springboot.sbthymeleaf.controllers;

import com.springboot.sbthymeleaf.models.Registration;
import com.springboot.sbthymeleaf.repositories.UserFormRepository;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UserFormController {
    private UserFormRepository userFormRepository;

    public UserFormController(UserFormRepository userFormRepository){
        this.userFormRepository = userFormRepository;
    }

    @GetMapping("/")
    public String landingForm(final Model model){
        log.debug( "LANDING FORM" );
        model.addAttribute( "formObject", new Registration() );
        return
            "index";
    }

    @GetMapping("/content")
    public String contentPage(final Model model){
        log.debug( "Content Page" );
        model.addAttribute( "companyName", "SGS Consultancy" );
        return
            "content";
    }

    @PostMapping("/insert")
    public String addNewUserRegistration(@ModelAttribute("formObject") @Valid Registration registration, BindingResult result ){
        log.debug( "ADD FORM DATA" );
        if(result.hasErrors() || result.hasFieldErrors()){
            result.getAllErrors().stream().forEach( objectError -> { log.error( "Error occurred at getObjectName={}, getArguments={}, getCode={}, getCodes={}, getDefaultMessage={}",objectError.getObjectName(), objectError.getArguments(), objectError.getCode(), objectError.getCodes(), objectError.getDefaultMessage() );} );
            result.getFieldErrors().stream().forEach( fieldError -> log.error("FIELD ERROR: getField={}, getRejectedValue={}, getDefaultMessage={}", fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage()) );
            return "index";
        }
        userFormRepository.save( registration );
        log.debug( "ADDED FORM DATA" );
        return "success";
    }


    @GetMapping("/list")
    public String list(final Model model){
        log.debug( "List Page" );
        List< Registration > registrationList = userFormRepository.findAll();
        model.addAttribute( "list", registrationList );
        model.addAttribute( "companyName", "SGS Consultancy" );
        return
            "multiplePages/list";
    }

    @GetMapping("/newForm")
    public String newForm(final Model model){
        log.debug( "New form Page" );
        model.addAttribute( "companyName", "SGS Consultancy" );
        model.addAttribute( "registrationForm", new Registration() );
        return
            "multiplePages/form";
    }
    @PostMapping("/insertNewForm")
    public String insertNewUserForm(@ModelAttribute("registrationForm") @Valid Registration registration, BindingResult result, Model model ){
        log.debug( "ADD FORM DATA" );
        if(result.hasErrors() || result.hasFieldErrors()){
            result.getAllErrors().stream().forEach( objectError -> { log.error( "Error occurred at getObjectName={}, getArguments={}, getCode={}, getCodes={}, getDefaultMessage={}",objectError.getObjectName(), objectError.getArguments(), objectError.getCode(), objectError.getCodes(), objectError.getDefaultMessage() );} );
            result.getFieldErrors().stream().forEach( fieldError -> log.error("FIELD ERROR: getField={}, getRejectedValue={}, getDefaultMessage={}", fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage()) );
            return "multiplePages/form";
        }
        userFormRepository.save( registration );
        log.debug( "ADDED FORM DATA" );
        model.addAttribute( "companyName", "SGS Consultancy" );
        return "redirect:/list";
    }
}
