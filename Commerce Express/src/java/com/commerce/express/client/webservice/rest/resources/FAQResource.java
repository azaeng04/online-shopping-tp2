package com.commerce.express.client.webservice.rest.resources;

import com.commerce.express.domain.FAQ;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author cna canal walk
 */
public class FAQResource extends ResourceSupport {

    private FAQ faq;

    public FAQ getFaq() {
        return faq;
    }

    public void setFaq(FAQ faq) {
        this.faq = faq;
    }
}
