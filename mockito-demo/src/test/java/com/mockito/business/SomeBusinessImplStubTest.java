package com.mockito.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplStubTest {

    @Test
    void findTheGreatestFromAllDataTestV1() {
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
        assertEquals(55, someBusiness.findTheGreatestFromAllData());
    }

}

class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAllData() { return new int[] { 1, 10, 55, 2, 8 }; }
}
