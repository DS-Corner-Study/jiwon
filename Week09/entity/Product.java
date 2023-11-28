package com.springboot.jpa.data.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

/*
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
*/

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name="product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long number;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private Integer price;

    @Column(nullable=false)
    private Integer stock;

    @OneToOne(mappedBy="product")
    @ToString.Exclude
    private ProductDetail productDetail;

    private LocalDataTime createdAt;

    private LocalDataTime updatedAt;
}


