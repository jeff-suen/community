package com.around.community.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.around.community.dao.AlphaDAO;

import jakarta.annotation.PreDestroy;
import jakarta.annotation.PostConstruct;

@Service
// @Scope("prototype")

public class AlphaService {

    @Autowired
     private AlphaDAO alphaDAO;
    public AlphaService() {
        System.out.println("instantiate AlphaService");
    }
    @PostConstruct // run after the bean is created
    public void init() {
        System.out.println("init AlphaService");
    }

    @PreDestroy // run before the bean is destroyed
    public void destroy() {
        System.out.println("destroy AlphaService");
    }

    public String find() {
        return alphaDAO.select();
    }
}

