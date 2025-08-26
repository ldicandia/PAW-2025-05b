package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.persistence.UserDao;
import ar.edu.itba.paw.services.UserService;
import ar.edu.itba.paw.webapp.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class HelloWorldController {

    private final UserService us;

    @Autowired
    public HelloWorldController(final UserService us) {
        this.us = us;
    }

    @RequestMapping("/")
    public ModelAndView helloWorld(@RequestParam(name = "userId", defaultValue = "1") long id,
                                   @RequestParam(name = "name", required = false) String name) {
        final ModelAndView mav = new ModelAndView("helloworld/index");
        mav.addObject("name", us.findById(id));
        mav.addObject("name", name);
        return mav;
    }

    @RequestMapping(path = "/create" , method = RequestMethod.POST)
    public ModelAndView profile(@Valid @ModelAttribute("userForm") final UserForm form, final BindingResult errors) {
        if (errors.hasErrors()) {
            //TODO: show errors
        }
        User newUser = us.create(form.getUsername());
        return new ModelAndView("redirect:/?userId=" + newUser.getId());
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView registerForm(@ModelAttribute("userForm") final UserForm form) {
        return new ModelAndView("register");
    }

    @ModelAttribute("currentUserId")
    public Optional<User> loggedUserId(){
        return us.findById(1);
    }

}
