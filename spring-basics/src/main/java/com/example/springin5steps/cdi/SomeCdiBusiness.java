package com.example.springin5steps.cdi;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Arrays;

@Named
public class SomeCdiBusiness {

    @Inject
    SomeCdiDAO someCdiDAO;

    public SomeCdiDAO getSomeCdiDAO() {
        return someCdiDAO;
    }

    public void setSomeCdiDAO(SomeCdiDAO someCdiDAO) {
        this.someCdiDAO = someCdiDAO;
    }

    public int findGreatest() {
        return Arrays.stream(someCdiDAO.getData())
                .max()
                .orElse(0);
    }

}
