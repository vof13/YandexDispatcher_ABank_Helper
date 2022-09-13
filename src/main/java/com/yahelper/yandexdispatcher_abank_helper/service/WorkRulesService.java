package com.yahelper.yandexdispatcher_abank_helper.service;

import com.yahelper.yandexdispatcher_abank_helper.rest.driverwokrules.RestRules;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WorkRulesService {
    @Value("${project.baseurl}")
    private String baseurl;
    private final String postfixUrl = "/v1/parks/driver-work-rules";
    @Value("${project.parkid}")
    private String parkId;
    @Value("${project.clientid}")
    private String clienId;
    @Value("${project.key}")
    private String xApiKey;

    public RestRules getRules() {
            return  WebClient.create(baseurl)
                    .get()
                    .uri(uriBuilder -> uriBuilder.path(postfixUrl)
                                    .queryParam("park_id", parkId)
                                    .build())
                    .header("X-Client-ID", clienId)
                    .header("X-API-Key", xApiKey)
                    .header("Accept-Language", "en")
                    .retrieve()
                    .bodyToMono(RestRules.class)
                    .doOnError(error -> System.out.println("  ОШИБКА " + error.getMessage()))
                    .onErrorResume(error -> Mono.just(new RestRules()))
                    .block();
    }
}
