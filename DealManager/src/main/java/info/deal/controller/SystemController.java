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

import info.deal.entity.Systems;
import info.deal.service.SystemService;

@Controller
@RequestMapping("/system")
public class SystemController {

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
	@RequestMapping("/list")
	public String listSystems(Model theModel) {
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
	 */
	@GetMapping("/showFormForUpdateSystem")
	public String showFormForUpdateSystem(@RequestParam("systemId") long theId, Model theModel) {
		Systems theSystem = systemService.findById(theId);
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
	 */
	@PostMapping("/saveSystem")
	public String addDeal(@Valid @ModelAttribute("system") Systems theSystems, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			System.out.println(theSystems);
			return "systemForm";
		}
		systemService.saveSystem(theSystems);
		return "redirect:/system/list";
	}
}
