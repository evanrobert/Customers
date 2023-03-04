package com.example.CustomersProject.Domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="books")
@Getter
@Setter
@Builder

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String genre;
    private Integer releaseYear;
    private Integer review;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Override
    public String toString(){return "title:" + title + "released in:" + releaseYear + "genre:" + genre + "review" + review;}


}
