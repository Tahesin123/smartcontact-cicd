package com.smart.Controller;

import com.smart.Entity.User;
import com.smart.dao.UserRepository;
import com.smart.helper.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home(Model model)
    {
       model.addAttribute("title", "Home-Smart Contact-Manager!");
       return "home";
    }

    @RequestMapping("/about")
    public String about(Model model)
    {
        model.addAttribute("title", "About-Smart Contact-Manager!");
        return "about";
    }

    @RequestMapping("/singup")
    public String singup(Model model)
    {
        model.addAttribute("title", "Singup-Smart Contact-Manager!");
        model.addAttribute("user", new User());
        return "singup";
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST )
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam(value = "agreement", defaultValue = "false")
                                    boolean agreement, Model model, HttpSession session)
    {

       try{

           if(!agreement)
           {
               throw new Exception("Your have not agreed the terms and conditions!!");
           }

           if(result.hasErrors())
           {
               model.addAttribute("user", user);
               return "singup";
           }
           user.setRole("ROLE_USER");
           user.setEnable(true);
           user.setImageUrl("defualt.png");
           user.setPassword(passwordEncoder.encode(user.getPassword()));

           userRepository.save(user);

           model.addAttribute("user", new User());

           session.setAttribute("message", new Message("Successfully registered user!!", "alert-success"));

           return "singup";
       }
       catch (Exception e)
       {
           e.printStackTrace();
           model.addAttribute("user", user);
           session.setAttribute("message", new Message("Something went wrong!!","alert-danger"));
           return "singup";
       }

    }

    @GetMapping("/singin")
    public String customLogin(Model model)
    {
        model.addAttribute("title","Login-  Smart Contact Manager!");
        return "login";

    }
}
