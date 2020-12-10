package com.example.demo.model;

import lombok.Data;
import org.hibernate.Criteria;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.criterion.Projections;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "infect_rec")
public class InfectRec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="create_date_time")
    private LocalDateTime createDateTime;

    @Column(name="random_id")
    private String randomId;


}
