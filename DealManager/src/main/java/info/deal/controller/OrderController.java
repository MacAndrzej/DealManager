package info.deal.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import info.deal.entity.Deal;
import info.deal.exception.IdNotFoundException;
import info.deal.service.DealService;
import info.deal.service.DealServiceImpl;
import info.deal.service.SystemService;

/**
 * 
 * @author Andrzej
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	final static Logger logger = Logger.getLogger(DealServiceImpl.class);

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
		theModel.addAttribute("allSystems", systemService.getSystems());
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
	 * @throws IdNotFoundException
	 *             Entry with theId not found.
	 * 
	 */
	@GetMapping("/showFormForUpdateOrder")
	public String showFormForUpdateOrder(@RequestParam("dealId") long theId, Model theModel)
			throws IdNotFoundException {
		logger.info("Entering to showFormForUpdateOrder");
		Deal theDeal = dealService.findById(theId);
		if (theDeal == null) {
			throw new IdNotFoundException();
		}
		theModel.addAttribute("order", theDeal);
		theModel.addAttribute("allSystems", systemService.getSystems());
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
	 * @throws IdNotFoundException
	 *             Entry with theId not found.
	 */
	@GetMapping("/disableOrder")
	public String disableOrder(@RequestParam("dealId") long theId, Model theModel) throws IdNotFoundException {
		Deal theDeal = dealService.disableDeal(theId);
		if (theDeal == null) {
			throw new IdNotFoundException();
		}
		return "redirect:/order/listActive";
	}

	/**
	 * 
	 * @param theDeal
	 *            The information of the saved deal entry.
	 * @param theBindingResult
	 *            The information of the correctness data.
	 * @return Redirect to view.
	 * 
	 */
	@PostMapping("/saveOrder")
	public String addDeal(@Valid @ModelAttribute("order") Deal theDeal, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "dealForm";
		}
		dealService.saveDeal(theDeal);
		return "redirect:/order/listActive";
	}

	/**
	 * Import deals from a file
	 * 
	 * @return Redirect to view which displays stats of import.
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@GetMapping("/showImportOrdersForm")
	public String importCsvTxtOrder(Model theModel) throws FileNotFoundException, IOException {
		Integer importResult = dealService.importCsv().size();
		theModel.addAttribute("results", importResult);
		return "importOrders";
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public ModelAndView handleOrderNotFoundException(IdNotFoundException e) {
		ModelAndView theModel = new ModelAndView();
		theModel.addObject("exc", e);
		theModel.setViewName("404");

		return theModel;
	}

}
