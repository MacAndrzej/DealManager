package info.deal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import info.deal.entity.Systems;
import info.deal.service.DealService;
import info.deal.service.SystemService;

/**
 * 
 * @author Andrzej
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private DealService dealService;

	@Autowired
	private SystemService systemService;

	/**
	 * Takes the request,calls service,set model and returns view name to
	 * DispatcherServlet.
	 * 
	 * @param theModel
	 *            Model to fulfill by list of all deals entry.
	 * @return View name to DispatcherServlet.
	 */
	@GetMapping("/list")
	public String listDeals(Model theModel) {
		List<Deal> list = dealService.getDeals();
		theModel.addAttribute("deals", list);
		return "listAllOrders";
	}

	/**
	 * Takes the request,calls service,set model and returns view name to
	 * DispatcherServlet.
	 * 
	 * @param theModel
	 *            Model to fulfill by list of all active deals entry.
	 * @return View name to DispatcherServlet.
	 */
	@GetMapping("/listActive")
	public String listActiveDeals(Model theModel) {
		List<Deal> list = dealService.getActiveDeals();
		theModel.addAttribute("deals", list);
		return "listActiveOrders";
	}

	/**
	 * Takes the request,set model and returns view name to DispatcherServlet.
	 * 
	 * @param theModel
	 *            Model to fulfill by new deal.
	 * @return View name to DispatcherServlet.
	 */
	@GetMapping("/showFormForAddOrder")
	public String showFormForAddChild(Model theModel) {
		theModel.addAttribute("order", new Deal());
		return "dealForm";
	}

	/**
	 * Takes the request, set model by data to update and returns view name to
	 * DispatcherServlet.
	 * 
	 * @param theId
	 *            The theId of the updated deal entry.
	 * @param theModel
	 *            Model to fulfill by updated deal.
	 * @return View name to DispatcherServlet.
	 */
	@GetMapping("/showFormForUpdateOrder")
	public String showFormForUpdateOrder(@RequestParam("dealId") long theId, Model theModel) {
		Deal theDeal = dealService.findById(theId);
		theModel.addAttribute("order", theDeal);
		System.out.println();
		return "dealForm";
	}

	/**
	 * Takes the request, set model by data to disable and redirect to view to
	 * DispatcherServlet.
	 * 
	 * @param theId
	 *            The theId of the disabled deal entry.
	 * @param theModel
	 *            Model to fulfill by disabled deal.
	 * @return Redirect to view.
	 */
	@GetMapping("/disableOrder")
	public String disableOrder(@RequestParam("dealId") long theId, Model theModel) {
		Deal theDeal = dealService.disableDeal(theId);
		return "redirect:/order/listActive";
	}

	/**
	 * Takes the request, take model, check
	 * 
	 * @param theDeal
	 *            The information of the saved deal entry.
	 * @param theBindingResult
	 *            The information of the correctness data.
	 * @return Redirect to view.
	 */
	@PostMapping("/saveOrder")
	public String addDeal(@Valid @ModelAttribute("order") Deal theDeal, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "dealForm";
		}
		dealService.saveDeal(theDeal);
		return "redirect:/order/listActive";
	}

}
