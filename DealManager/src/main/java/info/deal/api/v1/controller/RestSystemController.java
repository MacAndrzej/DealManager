package info.deal.api.v1.controller;
//package info.deal.api.controller;
//
//import org.apache.log4j.Logger;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import info.deal.api.controller.model.SystemDto;
//import info.deal.api.controller.model.SystemListDto;
//import info.deal.controller.SystemController;
//import info.deal.entity.Systems;
//import info.deal.service.SystemService;
//
///**
// * 
// * @Created by am on 24 cze 2018
// *
// */
//@RestController
//@RequestMapping("/api")
//public class RestSystemController {
//
//	final static Logger logger = Logger.getLogger(SystemController.class);
//
//	private final SystemService systemService;
//
//	public RestSystemController(SystemService systemService) {
//		this.systemService = systemService;
//	}
//
//	@GetMapping("/systems")
//	public ResponseEntity<SystemListDto> getListOfSystems() {
//		return new ResponseEntity<SystemListDto>(new SystemListDto(systemService.getSystems()), HttpStatus.OK);
//	}
//
//	// @GetMapping("/systems/{systemId}")
//	// public Systems getSystem(@PathVariable Long systemId) throws
//	// IdNotFoundException {
//	// Systems theSystem = systemService.findById(systemId);
//	// if (theSystem == null) {
//	// throw new IdNotFoundException("Customer id not found " + systemId);
//	// }
//	// return theSystem;
//	// }
//
//	@GetMapping("/systems/{systemId}")
//	public ResponseEntity<SystemDto> getSystem(@PathVariable Long systemId) {
//		return new ResponseEntity<SystemDto>(systemService.findById(systemId), HttpStatus.OK);
//
//	}
//
//	@PostMapping("/systems")
//	public ResponseEntity<Systems> addSystem(@RequestBody Systems theSystemDto) {
//		return new ResponseEntity<Systems>(systemService.saveSystem(theSystemDto), HttpStatus.OK);
//	}
//
//}
