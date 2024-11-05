package com.museum.ai.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class MetmuseumDepartmentResponse {
    private List<MetmuseumDepartment> departments;
}
