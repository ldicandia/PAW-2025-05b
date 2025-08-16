package ar.edu.itba.paw.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class inputController {
    @Controller
    public class InputController {

        @PostMapping("/processInput")
        public ModelAndView processInputMail(@RequestParam(name = "email") String email) {
            ModelAndView mav = new ModelAndView("helloworld/index");
            String emailError = null;

            if (email == null || !email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                emailError = "El correo ingresado no es válido.";
            }
            if (emailError != null) {
                mav.addObject("email", email);
                mav.addObject("emailError", emailError);
                return mav;
            }
            mav.addObject("successMessage", "El formulario se procesó correctamente.");
            return mav;
        }
    }
}
