package com.mitrais.pos.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    @JsonProperty("table_no")
    private String tableNo;
    @JsonProperty("menu_id")
    private Long menuId;
    @JsonProperty("total")
    private Long total;
    @JsonProperty("chef_id")
    private Long chefId;
    @JsonProperty("waiter_id")
    private Long waiterId;
}
