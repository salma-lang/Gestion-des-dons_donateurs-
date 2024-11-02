package com.salma.don_Donnateur.controller;

import com.salma.don_Donnateur.entities.Campagne;
import com.salma.don_Donnateur.repositories.CampagneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/campagnes")

public class CampagneController {
    @Autowired
    private CampagneRepository campagneRepository;

    @GetMapping("/list")
    public String listeCampagnes(Model model) {
        model.addAttribute("campagnes", campagneRepository.findAll());
        return "listCampagnes"; // Utiliser le fichier "Campagne.html" pour afficher la liste
    }

    @GetMapping("/add")
    public String ajouterCampagneForm(Model model) {
        model.addAttribute("campagne", new Campagne());
        return "Campagne"; // Créez "addCampagne.html" si besoin
    }

    @PostMapping("/add")
    public String addCampagne(@ModelAttribute Campagne campagne) {
        campagneRepository.save(campagne);
        return "redirect:/campagnes/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("campagne", campagneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campagne non trouvée")));
        return "editCampagne";
    }

    @PostMapping("/edit/{id}")
    public String updateCampagne(@PathVariable Long id, @ModelAttribute Campagne campagne) {
        campagne.setId(id);
        campagneRepository.save(campagne);
        return "redirect:/campagnes/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteCampagne(@PathVariable("id") Long id) {
        campagneRepository.deleteById(id);
        return "redirect:/campagnes/list"; // Redirige vers la liste des campagnes après suppression
    }
    
}