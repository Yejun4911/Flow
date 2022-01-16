package com.flow.backend.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name="fix")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ColumnDefault("0")
    private int checked;

}
