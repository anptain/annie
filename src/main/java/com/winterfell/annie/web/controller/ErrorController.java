package com.winterfell.annie.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ErrorController{

	  /**
     * 定义404的ModelAndView
     * @param request
     * @param response
     * @return
     */
	//@ExceptionHandler(value = Exception.class)
    @RequestMapping(value = "404")
    @ResponseBody
    public JsonResult errorHtml404(HttpServletRequest request,
                                  HttpServletResponse response) {
        return new JsonResult();
    }

    /**
     * 定义404的JSON数据
     * @param request
     * @return
     */
//    @RequestMapping(value = "404")
//    @ResponseBody
//    public ResponseEntity<Map<String, Object>> error404(HttpServletRequest request) {
//        Map<String, Object> body = getErrorAttributes(request,
//                isIncludeStackTrace(request, MediaType.TEXT_HTML));
//        HttpStatus status = getStatus(request);
//        return new ResponseEntity<Map<String, Object>>(body, status);
//    }
    

}
