package com.phyex0.elasticsearch.model;

import jakarta.annotation.Generated;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document(indexName = "user")
public class User {

    @Id
    @Generated({})
    private UUID id;

    @Field(type = FieldType.Text)
    private String firstName;

    @Field(type = FieldType.Text)
    private String middleName;

    @Field(type = FieldType.Text)
    private String lastName;

    @Field(type = FieldType.Text)
    private String phoneNumber;

    @Field(type = FieldType.Text)
    private String address;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Order> orders = new ArrayList<>();
}
