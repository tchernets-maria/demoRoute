package com.example.demo.controllers;

import com.example.demo.services.IdentityService;
import com.example.demo.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private RouteService routeService;
    @Autowired
    private IdentityService identityService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("routes", routeService.getAllRoutes());
        return "home";
    }

    @GetMapping("/route/{id}")
    public String details(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("route", List.of(routeService.getInfoRoute(id)));
        return "details";
    }

    @GetMapping("/route/add")
    public String routeAdd(Model model) {
        return "add";
    }

    @PostMapping("/route/add")
    public String routeAddPost(@RequestParam String login, @RequestParam String password, @RequestParam String fromName,
                               @RequestParam String toName, @RequestParam String transportName, Model model) {
        Long idCompany = identityService.getIdCompany(login, password);
        if (idCompany != null) {
            routeService.addRoute(idCompany, fromName, toName, transportName);
        }
        return "redirect:/";
    }

}