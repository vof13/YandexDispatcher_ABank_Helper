package com.yahelper.yandexdispatcher_abank_helper.service;

import com.yahelper.yandexdispatcher_abank_helper.rest.driverprofiles.request.*;
import com.yahelper.yandexdispatcher_abank_helper.rest.driverprofiles.response.ProfilesResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Service
public class ProfilesService {

    @Value("${project.baseurl}")
    private String baseurl;
    @Value("${project.parkid}")
    private String parkId;
    @Value("${project.clientid}")
    private String clienId;
    @Value("${project.key}")
    private String xApiKey;

    private FullProfileRequest body;

    public ProfilesResponseBody restGetProfiles() {
        createPostBody();
        String postfixUrl = "/v1/parks/driver-profiles/list";
        return WebClient.create(baseurl + postfixUrl)
                .post()
                .headers(HttpHeaders -> {
                    HttpHeaders.set("Accept-Language", "en");
                    HttpHeaders.set("X-Client-ID", clienId);
                    HttpHeaders.set("X-API-Key", xApiKey);
                })
                .bodyValue(body)
                .retrieve()
                .bodyToMono(ProfilesResponseBody.class)
                .doOnError(error -> System.out.println("  ОШИБКА " + error.getMessage()))
                .onErrorResume(error -> Mono.just(new ProfilesResponseBody()))
                .block();
    }

    private void createPostBody() {
        DriverProfileForResponse driverProfileForRequest = new DriverProfileForResponse();
        driverProfileForRequest.setWorkStatus(new ArrayList<>(Collections.singletonList("working")));
        Park park = new Park(parkId);
        park.setDriverProfile(driverProfileForRequest);
        Query query = new Query(park);

        Fields fields = new Fields();
        fields.setAccount(new  ArrayList<>(Collections.singletonList("balance")));
        fields.setCar(new  ArrayList<>(Arrays.asList("callsign", "brand", "number")));
        fields.setDriverProfile(new  ArrayList<>(Arrays.asList("id", "last_name", "first_name",
                "middle_name")));
        body = new FullProfileRequest(query);
        body.setFields(fields);
        body.setLimit(150);
    }
}
