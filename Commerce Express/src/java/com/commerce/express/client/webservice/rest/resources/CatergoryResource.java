package com.commerce.express.client.webservice.rest.resources;

import com.commerce.express.domain.Category;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author cna canal walk
 */
public class CatergoryResource extends ResourceSupport {

    private Category catergory;

    public Category getCatergory() {
        return catergory;
    }

    public void setCatergory(Category catergory) {
        this.catergory = catergory;
    }
}
