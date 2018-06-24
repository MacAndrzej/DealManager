package info.deal.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import info.deal.exception.IdNotFoundException;

/**
 * 
 * @author Andrzej
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	
	final static Logger logger = Logger.getLogger(ControllerExceptionHandler.class);
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleNumberFormatException(NumberFormatException e) {
		logger.error("Handling number format exception");
		logger.error(e.getMessage());
		ModelAndView theModel = new ModelAndView();
		theModel.addObject("exc", e);
		theModel.setViewName("400");
		return theModel;
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

}
