package com.salma.don_Donnateur.controller;


import com.salma.don_Donnateur.entities.Donateur;
import com.salma.don_Donnateur.repositories.DonateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/donateurs")
public class DonateurController {

    @Autowired
    private DonateurRepository donateurRepository;

    @GetMapping("/list")
    public String listDonateurs(Model model) {
        model.addAttribute("donateurs", donateurRepository.findAll());
        return "listDonateurs";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        Donateur donateur = donateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donateur non trouvé"));
        model.addAttribute("donateur", donateur);
        return "detailsDonateur";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("donateur", new Donateur());
        return "addDonateur";
    }

    @PostMapping("/add")
    public String addDonateur(@ModelAttribute Donateur donateur) {
        donateurRepository.save(donateur);
        return "redirect:/donateurs/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Donateur donateur = donateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donateur non trouvé"));
        model.addAttribute("donateur", donateur);
        return "editDonateur";
    }

    @PostMapping("/edit/{id}")
    public String updateDonateur(@PathVariable Long id, @ModelAttribute Donateur donateur) {
        donateur.setId(id);
        donateurRepository.save(donateur);
        return "redirect:/donateurs/list";
    }
}