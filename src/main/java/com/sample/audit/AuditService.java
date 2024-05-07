package com.sample.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

public class AuditService {

    private final Logger log = LoggerFactory.getLogger(AuditService.class);

    /**
     * an async method to delegate the request for auditing
     * Added Thread.Sleep to simulate the operations that will be performed in a seperate thread
     */
    @Async
    public void startAudit(String request, String response) throws InterruptedException {

        log.info("start Auditing");
        Thread.sleep(5000);
        log.info("perform an operation");
        Thread.sleep(20000);
        log.info("operation is complete ");

    }
}
