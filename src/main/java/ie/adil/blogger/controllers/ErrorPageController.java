package ie.adil.blogger.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorPageController implements ErrorController  {

	@RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView handleErrorMessage(HttpServletRequest request) {
		Object errorCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        ModelAndView mav = new ModelAndView("error");
        String messageRepository = null ;
		mav.addObject("errorCode", errorCode);
        return mav;
}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
