package com.gps.speakers.GpsReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gps.speakers.GpsReport.dao.GpsSpeakerRepository;
import com.gps.speakers.GpsReport.entity.User;
import com.gps.speakers.GpsReport.service.SecurityService;
import com.gps.speakers.GpsReport.service.UserService;
import com.gps.speakers.GpsReport.validator.UserValidator;


//@RequestMapping("/GpsReport")
@Controller
public class GpsSpeakerController {
	
	@Autowired
	GpsSpeakerRepository repository;
	
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
	
	 @GetMapping({"/", "/welcome"})
	public String getData(Model model) {
	/*	
         Iterable<Speakers> ls=repository.findAll();
		
		for(Speakers ls1:ls)
		{
			System.out.println("--"+ls1.getId());
			System.out.println("--"+ls1.getWebsite());
			System.out.println("--"+ls1.getName());
			System.out.println("--"+ls1.getPosition());
			System.out.println("--"+ls1.getEmail());
			System.out.println("--"+ls1.getContactno());
			System.out.println("--"+ls1.getAddress());
		}*/
        model.addAttribute("speakers", repository.findAll());
        return "welcome";
   }
	
	/* @GetMapping({"/", "/welcome"})
	    public String welcome(Model model) {
	        return "welcome";
	    }*/
	

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

}
