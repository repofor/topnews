package tech.topnews.blog.entities;

import javax.persistence.*;

@Entity
class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 2)
    private String code;
}
