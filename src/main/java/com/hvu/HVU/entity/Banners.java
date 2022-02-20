package com.hvu.HVU.entity;

import lombok.*;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import javax.validation.constraints.Size;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "banners")
public class Banners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long baId;

    @Column(name = "ba_name")
    @Size(max = 255)
    @Nationalized
    private String baName;

    @Column(name = "ba_link")
    @Size(max = 255)
    @Nationalized
    private String baLink;

    private boolean status = true;

}
