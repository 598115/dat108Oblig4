package no.hvl.dat108.festpaamelding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.festpaamelding.Deltager;
import no.hvl.dat108.festpaamelding.DeltagerService;
import no.hvl.dat108.registrering.util.SessionUtil;

@Controller
@RequestMapping("/deltagerliste")
public class ListeController {
	
	@Autowired
	private DeltagerService deltagerService;
	
	@GetMapping
	public String seListe(HttpSession session, Model model, RedirectAttributes ra) {
		
		if(!SessionUtil.erLoggetInn(session)) {
			ra.addFlashAttribute("redirectMessage", "Du er logget ut");
			return "redirect:innlogging";
		}
			
		List<Deltager> liste = deltagerService.finnDeltagere();
		model.addAttribute(session.getAttribute("deltager"));
		
		if(liste != null) {
		model.addAttribute("deltagerList", liste);
		}	
		return "deltagerliste";
	}
}
