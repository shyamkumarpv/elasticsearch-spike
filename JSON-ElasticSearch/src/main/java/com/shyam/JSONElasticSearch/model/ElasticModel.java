package com.shyam.JSONElasticSearch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "resume")
public class ElasticModel {
    private Long id;
}
