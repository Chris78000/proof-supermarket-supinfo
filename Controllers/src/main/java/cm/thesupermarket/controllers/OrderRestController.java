/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.controllers;

import cm.thesupermarket.models.OrderInModel;
import cm.thesupermarket.models.OrderOutModel;
import cm.thesupermarket.models.SortModel;
import cm.thesupermarket.services.OrderService;
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
 * @author Chris
 */
@RestController
@CrossOrigin
@RequestMapping("/order")
@Api(value = "order")
public class OrderRestController {
    private final OrderService orderService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> createOrder(
            @RequestBody(required = true) OrderInModel order
    ) {

        OrderOutModel data = orderService.create(order);
        log.info("----------------- valeur {} ", "");
        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @RequestMapping(value = "get", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> getOrder(
            @RequestBody(required = true) SortModel order
    ) {

        List<OrderOutModel> data = orderService.getAll(order);
        log.info("----------------- valeur {} ", "");
        return new ResponseEntity<>(data, HttpStatus.OK);

    }
}
