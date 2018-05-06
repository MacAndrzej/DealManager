package info.deal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import info.deal.dao.SystemDAO;
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

}
