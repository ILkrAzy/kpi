package org.kpi.controller;

import java.util.ArrayList;
import java.util.List;

import org.kpi.model.Kpi;
import org.kpi.model.dto.KpiDTO;
import org.kpi.service.KpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public void createKpi(@RequestBody KpiDTO kpiDTO) {
        kpiService.save(kpiDTO.toModel());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<KpiDTO> getKpiByUUID(@PathVariable String uuid) {
        Kpi kpi = kpiService.getKpiByUUID(uuid);
        KpiDTO kpiDTO = new KpiDTO();
        return ResponseEntity.ok(kpiDTO.fromModel(kpi));
    }

    @GetMapping
    public List<KpiDTO> getAll() {
        List<Kpi> kpis = kpiService.getAll();
        List<KpiDTO> kpiDTOs = new ArrayList<>();
        for (Kpi kpi : kpis) {
            kpiDTOs.add(new KpiDTO().fromModel(kpi));
        }
        return kpiDTOs;
    }
    
    @PutMapping
    public void update(@RequestBody List<KpiDTO> kpiDTOs){
        kpiService.update(kpiDTOs);
    }
    
    @GetMapping("/not-association")
    public List<KpiDTO> getKpisNotAsociationWithProjectType() {
        List<Kpi> kpis = kpiService.getKpisNotAsociationWithProjectType();
        List<KpiDTO> kpiDTOs = new ArrayList<>();
        for (Kpi kpi : kpis) {
            kpiDTOs.add(new KpiDTO().fromModel(kpi));
        }
        return kpiDTOs;
    }
    
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> remove(@PathVariable String uuid) {
        kpiService.remove(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
