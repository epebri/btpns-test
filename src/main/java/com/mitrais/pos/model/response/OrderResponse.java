package com.mitrais.pos.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private String tableNo;
    private String status;
    private Long menuId;
    private Long total;
    private Long price;
    private Long totalPrice;
    private String menuName;
    private Long chefId;
    private String chefName;
    private Long waiterId;
    private String waiterName;
}
