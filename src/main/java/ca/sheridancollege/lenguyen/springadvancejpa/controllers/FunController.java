package ca.sheridancollege.lenguyen.springadvancejpa.controllers;

import ca.sheridancollege.lenguyen.springadvancejpa.beans.Employee;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class FunController {
    private List<Employee> employeeList = new ArrayList<>();

    @GetMapping("/readCookie")
    public String readCookie(Model model, @CookieValue(value = "username", defaultValue = "John") String userName) {
        model.addAttribute("userName", userName);
        return "cookieOne";
    }

    @GetMapping("/setCookie")
    public String setCookie(HttpServletResponse response) {
        // create a cookie   
        Cookie cookie = new Cookie("username", "Jovan");
        cookie.setMaxAge(3600);
        //add cookie to response
        response.addCookie(cookie);
        return "redirect:readCookie";
    }

    @GetMapping("/pageOne")
    public String pageOne(HttpSession session) {
        Employee employee = new Employee();
        employee.setName("John " + new Random().nextInt(1, 2000));
        employeeList.add(employee);
        session.setAttribute("employeeList", employeeList);
        return "page1";
    }

    @GetMapping("pageTwo")
    public String pageTwo() {
        return "page2";
    }


}
