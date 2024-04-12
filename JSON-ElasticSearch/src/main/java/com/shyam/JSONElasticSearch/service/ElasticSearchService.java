package com.shyam.JSONElasticSearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shyam.JSONElasticSearch.model.ElasticModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;


@Service
@RequiredArgsConstructor
@Slf4j
public class ElasticSearchService {
    private final RestHighLevelClient client;
    private final ElasticsearchRepository elasticsearchRepository;
    private final ObjectMapper objectMapper;

    public void saveJsonFile(String index, MultipartFile multipartFile) throws IOException {
        log.info("Uploading json file to index", index);
        String jsonString = new String(multipartFile.getBytes());
        ElasticModel elasticModel = objectMapper.readValue(jsonString, ElasticModel.class);
        IndexRequest request = new IndexRequest(index);
        request.source(jsonString, XContentType.JSON);
        try {
            client.index(request, RequestOptions.DEFAULT);
            elasticsearchRepository.save(elasticModel);
            log.info("Successfully uploaded JSON file to index {}", index);
        } catch (IOException exception) {
            log.error("Failed to upload JSON file to index {}", index, exception);
            throw exception;
        }
    }
}