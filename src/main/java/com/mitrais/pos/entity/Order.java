package com.mitrais.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableNo;
    private String status;
    private Long menuId;
    private Long total;
    private Long price;
    @Column(name = "total_price")
    private Long totalPrice;
    private String menuName;
    private Long chefId;
    private Long waiterId;
}
