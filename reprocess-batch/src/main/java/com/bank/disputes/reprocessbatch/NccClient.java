package com.bank.disputes.reprocessbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class NccClient {

    //    private final JdbcTemplate jdbcTemplate;
    private HttpClient httpClient;

    private Logger log = LoggerFactory.getLogger(NccClient.class);

    String schemaName = "DS15";
    String findFirstCaseQuery = "SELECT * FROM %s.TABLE WHERE ACT_CDE = '09002' AND HIST_TMS " +
            "BETWEEN '%s' AND '%s'";
    String processorApiUrl = "https://bank.com/disputes/reprocess/";

    public NccClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Optional<String> sendCaseForReprocess() {
        String caseNumber;

        try {
            var end = LocalDateTime.now().minusMinutes(5);
            var start = end.minusHours(24);
            log.info("Querying for cases between {} and {}", start, end);
            var query = String.format(findFirstCaseQuery,
                    schemaName,
                    start.format(DateTimeFormatter.ISO_DATE_TIME),
                    end.format(DateTimeFormatter.ISO_DATE_TIME)
            );
            caseNumber = getData(query);
            log.info("Found case number {} for reprocess", caseNumber);
        } //catch (EmptyResultDataAccessException) {
        //log.info("No case found for reprocess");
        // return Optional.empty();
        //}
        catch (Exception e) {
            log.error("Error retrieving case number for reprocess", e);
            return Optional.empty();
        }
        if (caseNumber != null) {
            try {
                callReprocessCase(caseNumber);
            } catch (InterruptedException e) {
                log.error("Request interrupted for case {}", caseNumber);
                Thread.currentThread().interrupt();
                return Optional.empty();
            } catch (Exception e) {
                log.error("Error in request for reprocessing case {}", caseNumber, e);
                return Optional.empty();
            }
        }

        return Optional.ofNullable(caseNumber);
    }

    private void callReprocessCase(String caseNumber) throws URISyntaxException, IOException, InterruptedException {
        log.info("Calling: " + processorApiUrl + caseNumber);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(processorApiUrl + caseNumber))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        log.info("Response status code: " + response.statusCode());
    }

    private String getData(String query) {
        log.info("querying database: {}", query);
        return "123456789";
    }
}
