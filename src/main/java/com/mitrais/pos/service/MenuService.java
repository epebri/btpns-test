package com.mitrais.pos.service;

import com.mitrais.pos.entity.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    List<Menu> showMenu(String type, String category);

    Optional<Menu> getMenuById(Long id);
}
