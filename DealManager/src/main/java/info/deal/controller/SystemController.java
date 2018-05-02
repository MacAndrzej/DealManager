package info.deal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import info.deal.dao.SystemDAO;
import info.deal.entity.Systems;

@Controller
@RequestMapping("/system")
public class SystemController {

	/* inject the system DAO */
	@Autowired
	private SystemDAO systemDAO;

	@RequestMapping("/list")
	public String listSystems(Model theModel) {

		List<Systems> theSystems = systemDAO.getSystems();

		System.out.println(theSystems.toString());
		theModel.addAttribute("systems", theSystems);

		return "listSystems";
	}

}
