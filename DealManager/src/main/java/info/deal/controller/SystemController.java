package info.deal.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import info.deal.entity.Systems;
import info.deal.exception.IdNotFoundException;
import info.deal.service.SystemService;

/**
 * 
 * @author Andrzej
 *
 */
@Controller
@RequestMapping("/system")
public class SystemController {

	final static Logger logger = Logger.getLogger(SystemController.class);

	@Autowired
	private SystemService systemService;

	@Autowired
	public SystemController(SystemService systemService) {
		this.systemService = systemService;
	}

	/**
	 * Takes the request,calls service,set model and returns view name to
	 * DispatcherServlet.
	 * 
	 * @param theModel
	 *            Model to fulfill by list of all deals entry.
	 * @return View name to DispatcherServlet.
	 */
	@RequestMapping("/list")
	public String listOfSystems(Model theModel) {
		List<Systems> theSystems = systemService.getSystems();
		theModel.addAttribute("systems", theSystems);
		return "listSystems";
	}

	/**
	 * 
	 * @param theId
	 *            The theId of the updated system entry.
	 * @param theModel
	 *            Model to fulfill by updated system.
	 * @return View name to DispatcherServlet.
	 * @throws SystemNotFoundException
	 * 
	 */
	@GetMapping("/showFormForUpdateSystem")
	public String showFormForUpdateSystem(@RequestParam("systemId") long theId, Model theModel)
			throws IdNotFoundException {
		logger.info("Entering to method before finding by id");
		Systems theSystem = systemService.findById(theId);
		if (theSystem == null) {
			logger.info("Value of id not existing: " + theSystem);
			throw new IdNotFoundException("Requested id : " + theId + " not found.");
		}
		theModel.addAttribute("system", theSystem);
		return "systemForm";
	}

	/**
	 * 
	 * @param theSystems
	 *            The information of the saved system entry.
	 * @param theBindingResult
	 *            The information of the correctness data.
	 * @return Redirect to view.
	 * 
	 */
	@PostMapping("/saveSystem")
	public String updateSystem(@Valid @ModelAttribute("system") Systems theSystems, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "systemForm";
		}
		systemService.saveSystem(theSystems);
		return "redirect:/system/list";
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public ModelAndView handleOrderNotFoundException(IdNotFoundException e) {
		logger.error("Handling not found exception");
		logger.error(e.getMessage());
		ModelAndView theModel = new ModelAndView();
		theModel.addObject("exc", e);
		theModel.setViewName("404");
		return theModel;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleOrderNotFoundException(NumberFormatException e) {
		logger.error("Handling number format exception");
		logger.error(e.getMessage());
		ModelAndView theModel = new ModelAndView();
		theModel.addObject("exc", e);
		theModel.setViewName("400");
		return theModel;
	}
}
