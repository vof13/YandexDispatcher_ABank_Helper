package com.yahelper.yandexdispatcher_abank_helper.service;

import com.yahelper.yandexdispatcher_abank_helper.rest.transactions.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Value("${project.baseurl}")
    private String baseurl;
    @Value("${project.parkid}")
    private String parkId;
    @Value("${project.clientid}")
    private String clienId;
    @Value("${project.key}")
    private String xApiKey;

    private TransactionsRequest body;

    public TransactionResponseBody restGetTransaction() {
        createPostBody();
        String postfixUrl = "/v2/parks/transactions/list";
        return WebClient.create(baseurl + postfixUrl)
                .post()
                .headers(HttpHeaders -> {
                    HttpHeaders.set("Accept-Language", "en");
                    HttpHeaders.set("X-Client-ID", clienId);
                    HttpHeaders.set("X-API-Key", xApiKey);
                })
                .bodyValue(body)
                .retrieve()
                .bodyToMono(TransactionResponseBody.class)
                .doOnError(error -> System.out.println("  ОШИБКА " + error.getMessage()))
                .onErrorResume(error -> Mono.just(new TransactionResponseBody()))
                .block();
    }

    private void createPostBody() {
        EventAt eventAt = new EventAt("2022-09-05T00:00:00+03:00", "2022-09-09T23:59:59+03:00");
        List<String> categoryIds = new ArrayList<>();
        categoryIds.add("partner_service_manual");
        categoryIds.add("partner_service_financial_statement");
        Transaction transaction = new Transaction(eventAt);
        transaction.setCategoryIds(categoryIds);
        Park park = new Park(parkId, transaction);
        Query query = new Query(park);
        body = new TransactionsRequest(query);
        body.setLimit(150);
    }
}
