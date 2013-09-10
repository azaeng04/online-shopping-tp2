/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.factory;

import com.commerce.express.domain.FAQ;
import java.util.Map;

/**
 *
 * @author cna canal walk
 */
public class FAQFactory {

    public static FAQ getFAQ(Map<String, String> values) {
        FAQ faq = new FAQ();
        faq.setQuestion(values.get("question"));
        faq.setAnswer(values.get("answer"));
        return faq;
    }
}
