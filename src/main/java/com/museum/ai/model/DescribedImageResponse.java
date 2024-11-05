package com.museum.ai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescribedImageResponse {
    private String description;
    private String historicalAndCulturalContext;
    private String visualAnalysis;
    private String artistInformation;
    private String creationYear;
}
