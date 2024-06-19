package com.phyex0.elasticsearch.repository;

import com.phyex0.elasticsearch.model.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, UUID> {

    List<User> findAll();

    @Query("{\"bool\": {\"must\": [{\"range\": {\"orders.orderDate\": {\"gt\": \"?0\"}}}]}}")
    List<User> getByDateFilter(String localDate);
}
