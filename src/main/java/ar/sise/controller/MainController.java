 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.controller;

/**
 *
 * @author LeaRC
 */
import ar.sise.model.Usuario;
import ar.sise.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    @Autowired
    private UsuarioService userService;

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

            ModelAndView model = new ModelAndView();
            model.addObject("title", "Spring Security + Hibernate Example");
            model.addObject("message", "This page is for ROLE_ADMIN only!");
            model.setViewName("admin");

            return model;

	}
        
        @RequestMapping(value="/register", method = RequestMethod.GET)
        public ModelAndView registerPage(){
            ModelAndView model = new ModelAndView();
            model.setViewName("register");
            return model;
        }
        
        @RequestMapping(value="/register", method = RequestMethod.POST)
        public ModelAndView registerPage(@RequestParam(value = "username" , required = true)String user,
                @RequestParam(value = "password", required = true)String pass,
                @RequestParam(value = "password2", required = true)String pass2, HttpServletRequest request){
            ModelAndView model = new ModelAndView();
            if(!pass.equals(pass2)){
                model.addObject("error", "Verifica las contraseñas");
                model.addObject("username", user);
                return model;
            }else{
                PasswordEncoder encoder = new BCryptPasswordEncoder();
                Usuario usuario = new Usuario(user,encoder.encode(pass),true);
                if(userService.registrarUser(usuario)){
                    model.setViewName("home");
                    return model;
                }else{
                    model.addObject("error","Nombre de Usuario en uso");
                }
            }        
            return model;
        }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}

}