package com.museum.ai.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class MetmuseumSearchResponse {
    private int total;
    private List<Integer> objectIDs;
}
