package com.astratech.MI2C_RizkyMuliaPerdana_0320220023.controller;

import com.astratech.MI2C_RizkyMuliaPerdana_0320220023.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
public class CovidController {
    @Autowired
    private final CovidService covidService;

    public CovidController(CovidService covidService){
        this.covidService = covidService;
    }

    @GetMapping("/getAll-covid-statistic")
    public ResponseEntity<?> callcovidstatistic(){
        return ResponseEntity.ok(covidService.getAllCovidStatistic());
    }

    @GetMapping("/getAll-covid-country")
    public ResponseEntity<?> callcovidcountry(){
        return ResponseEntity.ok(covidService.getAllCovidCountry());
    }

    @GetMapping("/get-weather")
    public ResponseEntity<?> callweather(){
        return ResponseEntity.ok(covidService.getWeather());
    }
}
