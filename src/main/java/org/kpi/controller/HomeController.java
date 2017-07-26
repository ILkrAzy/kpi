package org.kpi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lnphi
 * @since 7/24/2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/signin")
    public String signin() {
        return "signin";
    }
}
