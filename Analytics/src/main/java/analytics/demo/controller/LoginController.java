package analytics.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @GetMapping ("/resetpage")
    public String resetPage(Model model) {
    	return "resetpage";
    }
    
    @GetMapping("/userhome")
    public String userHome() {
    	SecurityContext context = SecurityContextHolder.getContext();
    	Authentication auth = context.getAuthentication();
    	SimpleGrantedAuthority role = (SimpleGrantedAuthority) (auth.getAuthorities().toArray())[0];
    	if (role.getAuthority().equals("USER"))
    		return "user/userhome";
    	else
    		return "denied";
    }
    
}
