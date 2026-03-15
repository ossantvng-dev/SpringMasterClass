package com.mockito.business;

import java.util.Arrays;

public class SomeBusinessImpl {

    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {
        return Arrays.stream(dataService.retrieveAllData())
                .max()
                .orElse(-1);
    }

}
