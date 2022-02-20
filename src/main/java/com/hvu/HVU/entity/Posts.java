package com.hvu.HVU.entity;

import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long poId;

    @Column(name = "title")
    @Size(max = 255)
    @Nationalized
    private String title;

    @Column(name = "description")
    @Size(max = 8000)
    @Nationalized
    private String description;

    @Column(name = "image")
    @Size(max = 255)
    @Nationalized
    private String image;

    @CreatedDate
    private LocalDate createdDate;

}
