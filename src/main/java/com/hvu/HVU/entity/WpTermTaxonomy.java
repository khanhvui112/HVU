package com.hvu.HVU.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wp_term_taxonomy")
public class WpTermTaxonomy {
    @Id
    @Column(columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer termTaxonomyId;

    @Column(columnDefinition = "bigint(20)")
    private Integer termId;

    @Size(max = 32)
    private String taxonomy;

    @Column(columnDefinition= "longtext")
    private String description;

    @Column(columnDefinition = "bigint(10)")
    private Integer termGroup;

    @Column(columnDefinition = "bigint(20)")
    private Integer parent;

    @Column(columnDefinition = "bigint(20)")
    private Integer count;
}
