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
@Table(name = "departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depId;

    @Column(name = "name")
    @Size(max = 255)
    @Nationalized
    private String depName;

    private boolean status = true;

    @Column(name = "link")
    @Size(max = 255)
    @Nationalized
    private String link;

    @Column(name = "icon")
    @Size(max = 100)
    private String icon;

}
