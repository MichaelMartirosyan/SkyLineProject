package com.skyline.skylineproject.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Billionaires {
    //TODO add @Id and @Entity
    private String id;
    private String firstName;
    private String lastName;
    private String career;
}
