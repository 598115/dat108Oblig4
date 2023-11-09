package no.hvl.dat108.festpaamelding.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import no.hvl.dat108.festpaamelding.Deltager;
import no.hvl.dat108.festpaamelding.DeltagerService;
import no.hvl.dat108.festpaamelding.PassordService;

@Controller
@RequestMapping("paamelding")
public class PaameldingController {
	
	@Autowired
	private PassordService passordService;
	
	@Autowired
	private DeltagerService deltagerService;

	@GetMapping
    public String paameldingForm(Model model, RedirectAttributes ra, @ModelAttribute("redirectMessage") String redirectMessage) {
		model.addAttribute("redirectMessage", redirectMessage);
		return "paamelding";		
    }


	@PostMapping
    public String paameldSubmit(@Valid @ModelAttribute Deltager deltager, BindingResult result, RedirectAttributes ra,
    		@RequestParam String passord, @RequestParam String passordRepetert, HttpSession session) {
		
		Optional<Deltager> od = deltagerService.finnDeltagerMedId(deltager.getMobil());
		
		if(passord == null || passord.length() < 6 || result.hasErrors() || !(passord.equals(passordRepetert)) || od.isPresent()) {
				
		if(result.hasErrors()) {
		ra.addFlashAttribute("errorMessage", result.getAllErrors().get(0).getDefaultMessage());
		}
		else if(od.isPresent()) {
		ra.addFlashAttribute("errorMessage", "Mobilnummeret er allerede registrert");
		}
		else {
			ra.addFlashAttribute("errorMessage", "Passord må matche og være minst 6 symbol");
		}
		return "redirect:paamelding";
		}	
		
		String salt = passordService.genererTilfeldigSalt();
		String hash = passordService.hashMedSalt(passord, salt);
		Deltager d = new Deltager(deltager.getMobil(), deltager.getFornavn(), deltager.getEtternavn(), deltager.getKjonn(), hash, salt);
		
		deltagerService.registrerDeltager(d);
		
		session.setAttribute("deltager", d);
		session.setMaxInactiveInterval(300);
						
		return "redirect:erpaameldt";
    }
}
