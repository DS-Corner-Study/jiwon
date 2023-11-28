package com.springboot.jpa.data.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="provider")
public class Provider extends BaseEntity {

    @Id
    @GenerateValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy="provider", fetch=FetchType.EAGER)
    @ToString.Exclude
    private List<Product> productList=new ArrayList<>();
}
