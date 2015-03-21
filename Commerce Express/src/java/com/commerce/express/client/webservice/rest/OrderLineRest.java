package com.commerce.express.client.webservice.rest;

import com.commerce.express.client.webservice.rest.assembler.OrderLineAssembler;
import com.commerce.express.client.webservice.rest.resources.OrderLineResource;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.service.OrderLineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author cna canal walk
 */
@Controller
@RequestMapping("orderline")
public class OrderLineRest {

    @Autowired
    private OrderLineService orderLineService;
    @Autowired
    private OrderLineAssembler orderLineAssembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrderLineResource>> getAppoint() {
        List<OrderLine> orderline = orderLineService.getAllOrderLine();
        List<OrderLineResource> resource = orderLineAssembler.toResources(orderline);
        return new ResponseEntity<List<OrderLineResource>>(resource, HttpStatus.OK);
    }
}
