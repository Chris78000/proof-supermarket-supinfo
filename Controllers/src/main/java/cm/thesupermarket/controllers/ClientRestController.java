/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.controllers;

import cm.thesupermarket.models.ClientInModel;
import cm.thesupermarket.models.ClientOutModel;
import cm.thesupermarket.models.IdInModel;
import cm.thesupermarket.models.SortModel;
import cm.thesupermarket.services.ClientService;
import io.swagger.annotations.Api;
import java.util.List;
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
@RequestMapping("/client")
@Api(value = "clientstore")
public class ClientRestController {

    private final ClientService clientService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> createClient(
            @RequestBody(required = true) ClientInModel client
    // @RequestParam(value = "client", required = true) String client
    ) {

        ClientOutModel data = clientService.create(client);
        log.info("----------------- valeur {} ", "");
        return new ResponseEntity<>(data, HttpStatus.OK);

    }
    
     @RequestMapping(value = "update", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> updateClient(
            @RequestBody(required = true) ClientInModel client
    // @RequestParam(value = "client", required = true) String client
    ) {

        ClientOutModel data = clientService.update(client);
        log.info("----------------- valeur {} ", "");
        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @RequestMapping(value = "get", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> getClient(
            @RequestBody(required = true) SortModel client
    ) {

        List<ClientOutModel> data = clientService.getAll(client);
        log.info("----------------- valeur {} ", "");
        return new ResponseEntity<>(data, HttpStatus.OK);

    }
    
    @RequestMapping(value = "get/id", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> getClientById(
            @RequestBody(required = true) IdInModel client
    ) {

        ClientOutModel data = clientService.getClientById(client);
        log.info("----------------- valeur {} ", "");
        return new ResponseEntity<>(data, HttpStatus.OK);

    }

}
