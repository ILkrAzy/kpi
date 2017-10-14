package org.kpi.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String index() {
        return "index";
    }

    @Override
    public String getErrorPath() {
        return "index";
    }
}