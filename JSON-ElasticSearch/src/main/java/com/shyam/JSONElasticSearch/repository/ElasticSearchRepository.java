package com.shyam.JSONElasticSearch.repository;

import com.shyam.JSONElasticSearch.model.ElasticModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticSearchRepository extends ElasticsearchRepository<ElasticModel,Long> {
}
