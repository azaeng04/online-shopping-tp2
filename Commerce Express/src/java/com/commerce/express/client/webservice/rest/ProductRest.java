package com.commerce.express.client.webservice.rest;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.client.webservice.rest.assembler.ProductAssembler;
import com.commerce.express.client.webservice.rest.resources.ProductResource;
import com.commerce.express.domain.Product;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cna canal walk
 */
@RestController
public class ProductRest {

    private static final CommerceExpressServices CE_SERVICES = CommerceExpressServices.getCommerceExpressServices();
    private static final CommerceExpressCRUD CE_CRUDS = CommerceExpressCRUD.getCommerceExpressCRUD();
    List<Product> products = new ArrayList<Product>();
    
    @Autowired
    private ProductAssembler productResourceAssembler;

    @RequestMapping(value = "product/{id}", method = RequestMethod.GET)
    public ResponseEntity getProduct(@PathVariable("id") Long id) {
        clearProductListIfNotEmpty(products);
        Product product = CE_CRUDS.getProductCrudService().findById(id);        
        products.add(product);
        List<ProductResource> resource = productResourceAssembler.toResources(products);
        return new ResponseEntity<List<ProductResource>>(resource, HttpStatus.OK);
    }
    
    @RequestMapping(value = "products", method = RequestMethod.GET)
    public ResponseEntity<List<ProductResource>> getProducts() {
        clearProductListIfNotEmpty(products);
        products = CE_SERVICES.getProductService().getProducts();
        List<ProductResource> resource = productResourceAssembler.toResources(products);
        return new ResponseEntity<List<ProductResource>>(resource, HttpStatus.OK);
    }
    
    public void clearProductListIfNotEmpty(List<Product> products){
        if (!products.isEmpty()) {
            products.clear();
        }
    }
}
