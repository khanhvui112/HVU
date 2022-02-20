package com.hvu.HVU.entity;

import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wp_terms")
public class WpTerms {
    @Id
    @Column(columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer termId;

    @Size(max = 200)
    private String name;

    @Size(max = 200)
    private String slug;

    @Column(columnDefinition = "bigint(10)")
    private Integer termGroup;

}
