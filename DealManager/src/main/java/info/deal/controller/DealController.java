package info.deal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import info.deal.dao.DealDAO;
import info.deal.entity.Deal;
import info.deal.service.DealService;

@Controller
@RequestMapping("/deal")
public class DealController {

	@Autowired
	private DealService dealService;

	@RequestMapping("/list")
	public String listDeals(Model theModel) {
		List<Deal> list = dealService.getDeals();
		theModel.addAttribute("deals", list);
		return "listDeals";
	}

	@RequestMapping("/activeDeals")
	public String listActiveDeals(Model theModel) {
		List<Deal> list = dealService.getActiveDeals();
		theModel.addAttribute("deals", list);
		return "listActiveDeals";
	}

}
