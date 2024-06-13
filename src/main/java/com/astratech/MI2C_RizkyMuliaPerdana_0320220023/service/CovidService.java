package com.astratech.MI2C_RizkyMuliaPerdana_0320220023.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class CovidService {

    private static final String url = "https://covid-193.p.rapidapi.com/statistics";
    private static final String url2 = "https://covid-193.p.rapidapi.com/countries";

    private static final String xRapidapiKey = "25da8344c5msh30a64c9f67ed5b1p1d62fejsn3344182aeb6d";

    private static final String getxRapidApiHost = "covid-193.p.rapidapi.com";

    @Autowired
    private RestTemplate restTemplate;

    public Object getAllCovidStatistic() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-key", xRapidapiKey);
            headers.set("x-rapidapi-host", getxRapidApiHost);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(headers),String.class);
            log.info("Output API: {} ", response.getBody());

            return response.getBody();

        }catch (Exception e){
            log.error("Terjadi kesalahan dengan RapidAPI ", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exeception ketika memanggil API",
                    e
            );
        }
    }

    public Object getAllCovidCountry() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-key", xRapidapiKey);
            headers.set("x-rapidapi-host", getxRapidApiHost);

            ResponseEntity<String> response = restTemplate.exchange(url2, HttpMethod.GET,new HttpEntity<>(headers),String.class);
            log.info("Output API: {} ", response.getBody());

            return response.getBody();

        }catch (Exception e){
            log.error("Terjadi kesalahan dengan RapidAPI ", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exeception ketika memanggil API",
                    e
            );
        }
    }

    public Object getWeather() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-key", xRapidapiKey);
            headers.set("x-rapidapi-host", "weatherbit-v1-mashape.p.rapidapi.com");

            ResponseEntity<String> response = restTemplate.exchange("https://covid-193.p.rapidapi.com/history?country=usa&day=2020-06-02", HttpMethod.GET,new HttpEntity<>(headers),String.class);
            log.info("Output API: {} ", response.getBody());

            return response.getBody();

        }catch (Exception e){
            log.error("Terjadi kesalahan dengan RapidAPI ", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exeception ketika memanggil API",
                    e
            );
        }
    }
}
