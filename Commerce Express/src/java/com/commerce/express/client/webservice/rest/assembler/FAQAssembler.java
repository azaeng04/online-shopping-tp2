/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.webservice.rest.assembler;

import com.commerce.express.client.webservice.rest.ProductRest;
import com.commerce.express.client.webservice.rest.resources.FAQResource;
import com.commerce.express.domain.FAQ;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 *
 * @author cna canal walk
 */
@Service("fAQAssembler")
public class FAQAssembler extends ResourceAssemblerSupport<FAQ, FAQResource >{
  
    public FAQAssembler() {
        super(ProductRest.class, FAQResource.class);
    }
    
    @Override
    public FAQResource toResource(FAQ t) {
        FAQResource resource = instantiateResource(t);
        resource.setFaq(t);
        resource.add(linkTo(ProductRest.class).slash(t.getId()).withSelfRel());
        return resource;
    }
    
}
