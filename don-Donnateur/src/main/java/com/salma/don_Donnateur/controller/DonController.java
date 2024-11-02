package com.salma.don_Donnateur.controller;


import com.salma.don_Donnateur.entities.Campagne;
import com.salma.don_Donnateur.entities.Don;
import com.salma.don_Donnateur.repositories.CampagneRepository;
import com.salma.don_Donnateur.repositories.DonRepository;
import com.salma.don_Donnateur.repositories.DonateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dons")
public class DonController {

    @Autowired
    private DonRepository donRepository;

    @Autowired
    private DonateurRepository donateurRepository;
    @Autowired
    private CampagneRepository campagneRepository;

    @GetMapping("/list")
    public String listDons(Model model) {
        model.addAttribute("dons", donRepository.findAll());
        return "listDons";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("don", new Don());
        model.addAttribute("donateurs", donateurRepository.findAll());
        model.addAttribute("campagnes", campagneRepository.findAll());
        return "addDon";
    }

    @PostMapping("/add")
    public String addDon(@ModelAttribute Don don) {
        donRepository.save(don);
        return "redirect:/dons/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Don don = donRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Don non trouvé"));
        model.addAttribute("don", don);
        model.addAttribute("donateurs", donateurRepository.findAll());
        return "editDon";
    }

    @PostMapping("/edit/{id}")
    public String updateDon(@PathVariable Long id, @ModelAttribute Don don) {
        don.setId(id);
        donRepository.save(don);
        return "redirect:/dons/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteDon(@PathVariable("id") Long id) {
        donRepository.deleteById(id);
        return "redirect:/dons/list"; // redirige vers la liste des dons
    }

}