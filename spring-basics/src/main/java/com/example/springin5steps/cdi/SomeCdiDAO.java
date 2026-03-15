package com.example.springin5steps.cdi;

import jakarta.inject.Named;

@Named
public class SomeCdiDAO {

    public int[] getData() { return new int[] { 5, 89, 100 }; }
}
