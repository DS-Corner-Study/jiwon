package com.springboot.jpa.data.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String code;

    private String name;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="category_id")
    private List<Product> products=new ArrayList<>();
}
