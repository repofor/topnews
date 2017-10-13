package tech.topnews.blog.entities;

import javax.persistence.*;

@Entity
class AdBlocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String placeholder;

    @Column(nullable = false)
    private String body;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Language language;
}
