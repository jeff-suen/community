package com.around.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
 
@Repository
@Primary // higher priority than other beans of the same type
public class AlphaDAOMyBatisImpl implements AlphaDAO{

    @Override
    public String select() {
        return "MyBatis";
    }
}
 