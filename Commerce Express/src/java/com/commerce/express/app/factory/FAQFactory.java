/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.FAQ;

/**
 *
 * @author cna canal walk
 */
public class FAQFactory {

    private FAQFactory() {
    }

    public static FAQ getFAQ(String faqID,String question, String answer) {
        FAQ faq = new FAQ();
        faq.setFaqID("FAQ_" + faqID);
        faq.setQuestion(question);
        faq.setAnswer(answer);
        return faq;
    }
}
