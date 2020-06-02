/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.controllers;

import cm.thesupermarket.models.ClientHasShippingCardInModel;
import cm.thesupermarket.models.FidelityCardInModel;
import cm.thesupermarket.models.FidelityCardOutModel;
import cm.thesupermarket.models.IdInModel;
import cm.thesupermarket.services.FidelityCardService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ryank
 */
@RestController
@CrossOrigin
@Api(value = "Fidelity_Card")
@RequestMapping("/fidelity_card")
public class FidelityCardRestController {

    private final FidelityCardService fidelityCardService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public FidelityCardRestController(FidelityCardService fidelityCardService) {
        this.fidelityCardService = fidelityCardService;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> addFidelityCard(
            @RequestBody(required = true) FidelityCardInModel data
    ) {

        fidelityCardService.createFidelityCard(data);
        log.info("----------------- valeur {} ", "");
        return new ResponseEntity<>("Well donne !", HttpStatus.OK);

    }

    @RequestMapping(value = "update", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> updateFidelityCard(
            @RequestBody(required = true) FidelityCardInModel data
    ) {

        fidelityCardService.updateFidelityCard(data);
        log.info("----------------- valeur {} ", "");
        return new ResponseEntity<>("Well donne !", HttpStatus.OK);

    }

    @RequestMapping(value = "remove", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> removeFidelityCard(
            @RequestBody(required = true) FidelityCardInModel data
    ) {

        fidelityCardService.removeFidelityCard(data);
        log.info("----------------- valeur {} ", "");
        return new ResponseEntity<>("Well donne !", HttpStatus.OK);

    }

    @RequestMapping(value = "get/id", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> getFidelityCard(
            @RequestBody(required = true) IdInModel data
    ) {

        FidelityCardOutModel out = fidelityCardService.getFidelityCard(data);
        log.info("----------------- valeur {} ", "");
        return new ResponseEntity<>(out, HttpStatus.OK);

    }

}
