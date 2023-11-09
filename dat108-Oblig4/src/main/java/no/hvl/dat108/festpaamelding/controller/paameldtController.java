package no.hvl.dat108.festpaamelding.controller;

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
import no.hvl.dat108.registrering.util.SessionUtil;

	@Controller
	@RequestMapping("erpaameldt")
	public class paameldtController {
			
		@GetMapping
	    public String hentLoginSkjema(Model model, HttpSession session, RedirectAttributes ra) {
			if(SessionUtil.erLoggetInn(session)) {
			model.addAttribute(session.getAttribute("deltager"));
			return "erpaameldt";
			}
			else {
				ra.addFlashAttribute("redirectMessage", "Du er logget ut");
				return "redirect:innlogging";
			}
	    }
}
