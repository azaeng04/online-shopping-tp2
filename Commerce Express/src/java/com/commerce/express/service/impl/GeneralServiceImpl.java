package com.commerce.express.service.impl;

import com.commerce.express.service.GeneralService;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ronald
 */
@Service("GeneralService")
public class GeneralServiceImpl implements GeneralService {
    
    private static GeneralServiceImpl objServiceImpl;
    
    private GeneralServiceImpl() {
    }
    
    public synchronized static GeneralServiceImpl getInstance() {
        if (objServiceImpl == null) {
            objServiceImpl = new GeneralServiceImpl();
        }
        return objServiceImpl;
    }

    @Override
    public Integer generateRandomNumber(Integer start, Integer end, Random randomize) {
        if (start > end) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        Long range = (long) end - (long) start + 1;
        Long fraction = (long) (range * randomize.nextDouble());
        Integer randomNumber = (int) (fraction + start);
        return randomNumber;
    }
}
