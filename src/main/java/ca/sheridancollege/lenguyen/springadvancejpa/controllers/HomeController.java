package ca.sheridancollege.lenguyen.springadvancejpa.controllers;

import ca.sheridancollege.lenguyen.springadvancejpa.database.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {     
    @Autowired
    private EmployeeRepository employeeRepository;
                 
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("employeeList", employeeRepository.findAll());
        model.addAttribute("emailList", employeeRepository.findById(1L).get().getEmails());     
        return "index";     
    }     
}
