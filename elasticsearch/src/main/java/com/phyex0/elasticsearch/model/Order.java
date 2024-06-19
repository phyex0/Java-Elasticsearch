package com.phyex0.elasticsearch.model;

import jakarta.annotation.Generated;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document(indexName = "order")
public class Order {

    @Id
    @Generated({})
    private UUID id;

    @Field(type = FieldType.Date)
    private LocalDate orderDate;

    @Field(type = FieldType.Double)
    private Double amount;

    @Field(type = FieldType.Boolean)
    private Boolean status;

    @Field(type = FieldType.Auto)
    private List<String> content = new ArrayList<>();
}
