package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "image")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    @Id
    @Column(name = "ID", nullable = false)
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("url")
    private String imageUrl;

}
