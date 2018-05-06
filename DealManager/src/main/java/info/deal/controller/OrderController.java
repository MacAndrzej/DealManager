package info.deal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.deal.entity.Deal;
import info.deal.service.DealService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private DealService dealService;

	@GetMapping("/list")
	public String listDeals(Model theModel) {
		List<Deal> list = dealService.getDeals();
		theModel.addAttribute("deals", list);
		return "listAllOrders";
	}

	@GetMapping("/listActive")
	public String listActiveDeals(Model theModel) {
		List<Deal> list = dealService.getActiveDeals();
		theModel.addAttribute("deals", list);
		return "listActiveOrders";
	}
	
	@GetMapping("/showFormForAddOrder")
	public String showFormForAddChild(Model theModel) {
		theModel.addAttribute("order", new Deal());
		return "dealForm";
	}

	@GetMapping("/showFormForUpdateOrder")
	public String showFormForUpdateOrder(@RequestParam("dealId") long theId, Model theModel) {
		Deal theDeal = dealService.findById(theId);
		theModel.addAttribute("order",theDeal);
		System.out.println();
		return "dealForm";
	}

	@GetMapping("/disableOrder")
	public String disableOrder(@RequestParam("dealId") long theId, Model theModel) {
		Deal theDeal = dealService.disableDeal(theId);
		return "redirect:/order/listActive";
	}
	
	@PostMapping("/saveOrder")
	public String addDeal(@Valid @ModelAttribute("order") Deal theDeal, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			System.out.println("Jakieś błędy walidacji");
			System.out.println(theDeal);
			return "dealForm";
		}
		System.out.println(theDeal.getOrderNumber());
		System.out.println("Formularz zwalidowany, powinien być zapis do bazy");
		dealService.saveDeal(theDeal);
		System.out.println("Jestem po zapisie do bazy, powinno być redirect:....");
		System.out.println(theDeal);
		return "redirect:/order/listActive";
	}

}
