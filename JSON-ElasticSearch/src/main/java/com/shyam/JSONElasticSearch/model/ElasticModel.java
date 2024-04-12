package com.shyam.JSONElasticSearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "json")
@Builder
public class ElasticModel {
    @Id
    private Long id;
}
