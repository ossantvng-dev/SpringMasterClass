package com.aop.service;

import com.aop.annotation.TrackTime;
import com.aop.repository.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class BusinessService {

    @Autowired
    private DataService dataService;

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    @TrackTime
    public int calculateMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

    public int calculateMin() {
        try {
            return scheduler.schedule(() ->
                    Arrays.stream(dataService.retrieveData())
                            .min()
                            .orElse(0),
                    2, TimeUnit.SECONDS).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
