package org.kpi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author lnphi
 * @since 7/24/2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/{[path:[^\\.]*}")
    @ResponseStatus(HttpStatus.OK)
    public String redirectWithParams(HttpServletRequest request) {
        return "forward:/";
    }
}
