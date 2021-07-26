package com.mitrais.pos.repository;

import com.mitrais.pos.entity.Order;
import com.mitrais.pos.model.response.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("Select new com.mitrais.pos.model.response.OrderResponse(o.id, o.tableNo, o.status, o.menuId, " +
            "o.total, o.price, o.totalPrice, o.menuName, c.id, c.name, w.id, w.name) " +
            "FROM Order o " +
            "LEFT JOIN User c ON c.id = o.chefId " +
            "LEFT JOIN User w ON w.id = o.waiterId " +
            "ORDER BY o.id ASC")
    List<OrderResponse> getAllData();

    @Query("Select new com.mitrais.pos.model.response.OrderResponse(o.id, o.tableNo, o.status, o.menuId, " +
            "o.total, o.price, o.totalPrice, o.menuName, c.id, c.name, w.id, w.name) " +
            "FROM Order o " +
            "LEFT JOIN User c ON c.id = o.chefId " +
            "LEFT JOIN User w ON w.id = o.waiterId " +
            "WHERE o.status = ?1 ORDER BY o.id ASC")
    List<OrderResponse> findByStatus(String status);


}
