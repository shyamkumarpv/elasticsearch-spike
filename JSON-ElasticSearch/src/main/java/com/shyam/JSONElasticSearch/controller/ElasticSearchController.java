package com.shyam.JSONElasticSearch.controller;

import com.shyam.JSONElasticSearch.service.ElasticSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ElasticSearchController {
    private final ElasticSearchService elasticSearchService;

    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        elasticSearchService.saveJsonFile("json", multipartFile);
    }
}