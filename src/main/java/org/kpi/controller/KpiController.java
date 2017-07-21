package org.kpi.controller;

import org.kpi.model.Kpi;
import org.kpi.service.KpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vquochuy on 7/21/2017.
 */
@RestController
@RequestMapping("/api/kpi")
public class KpiController {
    
    private KpiService kpiService;

    @Autowired
    public KpiController(KpiService kpiService) {
        this.kpiService = kpiService;
    }
    
    @PostMapping
    public void createKpi(@RequestBody Kpi kpi){
        kpiService.save(kpi);
    }
    
}
