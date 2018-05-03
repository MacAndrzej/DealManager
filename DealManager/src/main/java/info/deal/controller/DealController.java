package info.deal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import info.deal.dao.DealDAO;
import info.deal.entity.Deal;

@Controller
@RequestMapping("/deal")
public class DealController {

	@Autowired
	private DealDAO dealDAO;

	@RequestMapping("/list")
	public String listDeals(Model theModel) {
		List<Deal> list = dealDAO.getDeals();
		theModel.addAttribute("deals", list);
		return "listDeals";
	}

	@RequestMapping("/activeDeals")
	public String listActiveDeals(Model theModel) {
		List<Deal> list = dealDAO.getActiveDeals();
		theModel.addAttribute("deals", list);
		System.out.println();
		return "listActiveDeals";
	}

}
