package com.museum.ai.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class MetmuseumObjectResponse {
    private Integer objectID;
    private String primaryImage;
    private String primaryImageSmall;
    private List<String> additionalImages;
    private String department;
    private String objectName;
    private String title;
    private String culture;
    private String period;
    private String objectDate;
    private String creditLine;
    private String objectURL;
}
