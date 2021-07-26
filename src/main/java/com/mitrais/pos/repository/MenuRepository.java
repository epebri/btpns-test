package com.mitrais.pos.repository;

import com.mitrais.pos.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByTypeAndCategory(String type, String category);

    List<Menu> findByType(String type);

    List<Menu> findByCategory(String category);
}
