package org.formation.ajc.family.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

//	@GetMapping("/admin")
//	public String gerantPage(ModelMap model) {
//		model.addAttribute("user", getPrincipal());
//		return "admin_welcome";
//	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

//	@GetMapping("/logout")
//	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null) {
//			new SecurityContextLogoutHandler().logout(request, response, auth);
//		}
//		return "redirect:/login?logout";
//	}
//
//	private User getPrincipal() {
//		User user = null;
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		if (principal instanceof User) {
//			user = (User) principal;
//		}
//
//		return user;
//	}

}
