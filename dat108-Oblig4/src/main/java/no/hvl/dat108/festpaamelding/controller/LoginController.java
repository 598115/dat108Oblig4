package no.hvl.dat108.festpaamelding.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.festpaamelding.Deltager;
import no.hvl.dat108.festpaamelding.DeltagerService;
import no.hvl.dat108.festpaamelding.PassordService;

@Controller
@RequestMapping(value = "innlogging")
public class LoginController {
	
	@Autowired
	private PassordService passordService;
	
	@Autowired
	private DeltagerService deltagerService;
	
	@GetMapping
    public String hentLoginSkjema(Model model, @ModelAttribute("redirectMessage") String redirectMessage) {
		model.addAttribute("redirectMessage", redirectMessage);
		return "loginView";
    }


	@PostMapping
    public String provAaLoggeInn(@RequestParam String mobil, @RequestParam String passord, RedirectAttributes ra,
    		HttpSession session) {
		
		Optional<Deltager> od = deltagerService.finnDeltagerMedId(mobil);
		if(od.isEmpty()) {
			ra.addFlashAttribute("redirectMessage", "Brukernavn og/eller passord er ugyldig");
			return "redirect:innlogging";
		}
		Deltager d = od.get();
		Boolean p = passordService.erKorrektPassord(passord, d.getSalt(), d.getHash());
		if(!p) {
			ra.addFlashAttribute("redirectMessage", "Passord er ugyldig");
			return "redirect:innlogging";
		}
		session.setAttribute("deltager", d);
		session.setMaxInactiveInterval(300);
		return "redirect:erpaameldt";
    }
}
