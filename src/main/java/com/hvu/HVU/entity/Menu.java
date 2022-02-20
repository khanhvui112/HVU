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
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meId;

    @Column(name = "me_name")
    @Size(max = 100)
    @Nationalized
    private String meName;

    @Column(name = "me_link")
    @Size(max = 255)
    @Nationalized
    private String meLink;

    private boolean status = true;

    @Column(name = "parent_id")
    private Long parentId;

}
