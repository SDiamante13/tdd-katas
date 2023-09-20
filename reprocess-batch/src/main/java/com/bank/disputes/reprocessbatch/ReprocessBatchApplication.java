package com.bank.disputes.reprocessbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpClient;
import java.util.Optional;

public class ReprocessBatchApplication {

    private static Logger log = LoggerFactory.getLogger(ReprocessBatchApplication.class);

    public static void main(String[] args) throws Exception{

        NccClient nccClient = new NccClient(HttpClient.newBuilder().build());
        log.info("Starting cronjob for reprocess");

        String lastProcessedCase = "none";
        boolean continueProcessing = true;

        do {
            Optional<String> caseFound = nccClient.sendCaseForReprocess();
            if(caseFound.isPresent()) {
                if(lastProcessedCase.equals(caseFound.get())) {
                    log.info("Stopping job as case {} was already attempted", lastProcessedCase);
                    continueProcessing = false;
                } else {
                    lastProcessedCase = caseFound.get();
                }
            } else {
                log.info("Stopping reprocess job");
                continueProcessing = false;
            }

        }while(continueProcessing);

    }
}
