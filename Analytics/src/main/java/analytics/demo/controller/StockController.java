package analytics.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import analytics.demo.domain.StockPE;
import analytics.demo.service.StockService;

@Controller
public class StockController {
	@Autowired
	private StockService stockService;

	@GetMapping("/pe2growth")
	public String pe2growth(
		@RequestParam(name="ticker", required=true) 
		String ticker, Model model) {
		List<StockPE> stockPEs = stockService.getStockPEs(ticker.toLowerCase());
		model.addAttribute("stockPEs",stockPEs);
		return "table";
	}
	
}
