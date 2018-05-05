package info.deal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import info.deal.dao.DealDAO;
import info.deal.entity.Deal;
import info.deal.entity.Systems;
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

	@GetMapping("/showFormForUpdateForm")
	public String updateOrder(@RequestParam("dealId") long theId, Model theModel) {
		Deal theDeal = dealService.getActiveDeal(theId);
		return "listActiveOrders";
	}

	@GetMapping("/disableOrder")
	public String disableOrder(@RequestParam("dealId") long theId, Model theModel) {
		Deal theDeal = dealService.deactiveDeal(theId);
		return "redirect:/order/listActive";
	}

}
