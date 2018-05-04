package info.deal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import info.deal.dao.DealDAO;
import info.deal.entity.Deal;
import info.deal.entity.Systems;
import info.deal.service.DealService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private DealService dealService;

	@RequestMapping("/list")
	public String listDeals(Model theModel) {
		List<Deal> list = dealService.getDeals();
		theModel.addAttribute("deals", list);
		if (list.size() > 0) {
			System.out.println("Rozmiar listy: "+list.size());
			Deal theDeal=list.get(0);
			
			System.out.println("Deal number " + theDeal.getOrderNumber());
			System.out.println("Deal Id: "+theDeal.getId());
//			Systems theSystem=theDeal.getSystems();
//			System.out.println("System name"+theSystem);
		} else {
			System.out.println("Rozmiar listy 0");
		}
		return "listAllOrders";
	}
	

	@RequestMapping("/listActive")
	public String listActiveDeals(Model theModel) {
		List<Deal> list = dealService.getActiveDeals();
		theModel.addAttribute("deals", list);
		return "listActiveOrders";
	}

}
