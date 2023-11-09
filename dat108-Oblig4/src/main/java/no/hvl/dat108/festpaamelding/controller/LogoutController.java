package no.hvl.dat108.festpaamelding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("utlogging")
public class LogoutController {
	
	@PostMapping
    public String loggUt(HttpSession session, RedirectAttributes ra) {
		ra.addFlashAttribute("redirectMessage", "Du er nå logget ut");
		session.removeAttribute("deltager");
		session.invalidate();
		return "redirect:innlogging";
    }
}
