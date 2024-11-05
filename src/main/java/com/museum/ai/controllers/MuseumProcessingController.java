package com.museum.ai.controllers;

import com.museum.ai.model.DescribedImageResponse;
import com.museum.ai.model.MetmuseumDepartmentResponse;
import com.museum.ai.model.MetmuseumObjectResponse;
import com.museum.ai.model.MetmuseumSearchResponse;
import com.museum.ai.services.MuseumProcessingService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MuseumProcessingController {
    private final MuseumProcessingService service;

    @Operation(summary = "Ready to use")
    @PostMapping("/describeImage")
    public ResponseEntity<DescribedImageResponse> describeImage(@RequestParam String imageUrl) {
        DescribedImageResponse result = service.describeImage(imageUrl);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Ready to use")
    @GetMapping("/metmuseum/departments")
    public ResponseEntity<MetmuseumDepartmentResponse> getDepartments() {
        MetmuseumDepartmentResponse result = service.getDepartments();
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Ready to use")
    @GetMapping("/metmuseum/departments/{departmentId}/objects")
    public ResponseEntity<MetmuseumSearchResponse> searchObjectsByDepartmentId(@PathVariable Integer departmentId) {
        MetmuseumSearchResponse result = service.searchObjectsByDepartmentId(departmentId);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Ready to use")
    @PostMapping("/metmuseum/objects/byQuery")
    public ResponseEntity<MetmuseumSearchResponse> searchObjectsByQuery(@RequestParam String query) {
        MetmuseumSearchResponse result = service.searchObjectsByQuery(query);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Ready to use")
    @GetMapping("/metmuseum/objects/{objectId}")
    public ResponseEntity<MetmuseumObjectResponse> getMetmuseumObject(@PathVariable Integer objectId) {
        MetmuseumObjectResponse result = service.getMetmuseumObject(objectId);
        return ResponseEntity.ok().body(result);
    }

}
