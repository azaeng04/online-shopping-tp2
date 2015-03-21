package com.commerce.express.client.webservice.rest.assembler;

import com.commerce.express.client.webservice.rest.ProductRest;
import com.commerce.express.client.webservice.rest.resources.CatergoryResource;
import com.commerce.express.domain.Category;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

/**
 *
 * @author cna canal walk
 */
@Service("catergoryAssembler")
public class CatergoryAssembler extends ResourceAssemblerSupport<Category, CatergoryResource> {

    public CatergoryAssembler() {
        super(ProductRest.class, CatergoryResource.class);
    }

    @Override
    public CatergoryResource toResource(Category t) {
        CatergoryResource resource = instantiateResource(t);
        resource.setCatergory(t);
        resource.add(linkTo(ProductRest.class).slash(t.getId()).withSelfRel());
        return resource;
    }
}
