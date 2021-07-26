package com.mitrais.pos.service.impl;

import com.mitrais.pos.entity.Menu;
import com.mitrais.pos.repository.MenuRepository;
import com.mitrais.pos.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<Menu> showMenu(String type, String category) {
        if (type != null && category != null) {
            return menuRepository.findByTypeAndCategory(type, category);
        } else if (type != null) {
            return menuRepository.findByType(type);
        } else if (category != null) {
            return menuRepository.findByCategory(category);
        } else {
            return menuRepository.findAll();
        }
    }

    @Override
    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }
}
