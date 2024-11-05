package com.museum.ai.http_clients;

import com.museum.ai.model.MetmuseumDepartmentResponse;
import com.museum.ai.model.MetmuseumObjectResponse;
import com.museum.ai.model.MetmuseumSearchResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Slf4j
@Service
@RequiredArgsConstructor
public class MetmuseumHttpClient {
    public static final String METMUSEUM_INDEX_URL = "https://collectionapi.metmuseum.org/public/collection/v1";

    public MetmuseumObjectResponse getMetmuseumObject(Integer objectId) {
        RestClient restClient = RestClient.builder()
                .baseUrl(METMUSEUM_INDEX_URL)
                .build();

        return restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/objects")
                        .path("/" + objectId)
                        .build()
                )
                .retrieve()
                .body(MetmuseumObjectResponse.class);
    }

    public MetmuseumSearchResponse searchObjectsByQuery(String query) {
        RestClient restClient = RestClient.builder()
                .baseUrl(METMUSEUM_INDEX_URL)
                .build();

        return restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("q", query)
                        .build()
                )
                .retrieve()
                .body(MetmuseumSearchResponse.class);
    }

    public MetmuseumSearchResponse searchObjectsByDepartmentId(Integer departmentId) {
        RestClient restClient = RestClient.builder()
                .baseUrl(METMUSEUM_INDEX_URL)
                .build();

        return restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/objects")
                        .queryParam("departmentIds", departmentId)
                        .build()
                )
                .retrieve()
                .body(MetmuseumSearchResponse.class);
    }

    public MetmuseumDepartmentResponse getDepartments() {
        RestClient restClient = RestClient.builder()
                .baseUrl(METMUSEUM_INDEX_URL)
                .build();

        return restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/departments")
                        .build()
                )
                .retrieve()
                .body(MetmuseumDepartmentResponse.class);
    }
}
