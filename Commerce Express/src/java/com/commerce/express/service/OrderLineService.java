package com.commerce.express.service;

import com.commerce.express.domain.OrderLine;
import java.util.List;

/**
 *
 * @author Ronald
 */
public interface OrderLineService {

    public Integer getUniqueOrderLineNumber();

    public List<OrderLine> getAllOrderLine();
}
