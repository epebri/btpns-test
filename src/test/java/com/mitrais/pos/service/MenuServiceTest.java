package com.mitrais.pos.service;

import com.mitrais.pos.entity.Menu;
import com.mitrais.pos.repository.MenuRepository;
import com.mitrais.pos.service.impl.MenuServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class MenuServiceTest {
    @InjectMocks
    private MenuService menuService = new MenuServiceImpl();

    @Mock
    private MenuRepository menuRepository;

    @Test
    void showMenuTest() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(1L, "Nasi Goreng", "F", "MAIN", 1000L));
        menus.add(new Menu(2L, "Ayam Kampung", "F", "MAIN", 2000L));
        Mockito.when(menuRepository.findAll())
                .thenReturn(menus);

        List<Menu> menuList = menuService.showMenu(null, null);

        Assertions.assertTrue(menuList.size() > 0);
    }

    @Test
    void showMenuByCategoryTest() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(1L, "Nasi Goreng", "F", "MAIN", 1000L));
        Mockito.when(menuRepository.findByCategory("MAIN"))
                .thenReturn(menus);

        List<Menu> menuList = menuService.showMenu(null, "MAIN");

        Assertions.assertEquals("MAIN", menuList.get(0).getCategory());
    }

    @Test
    void showMenuByTypeTest() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(1L, "Nasi Goreng", "F", "MAIN", 1000L));
        Mockito.when(menuRepository.findByType("F"))
                .thenReturn(menus);

        List<Menu> menuList = menuService.showMenu("F", null);

        Assertions.assertEquals("F", menuList.get(0).getType());
    }

    @Test
    void getMenuByIdTest() {
        Mockito.when(menuRepository.findById(1L))
                .thenReturn(Optional.of(new Menu(1L, "Nasi Goreng", "F", "MAIN", 1000L)));

        Optional<Menu> menu = menuService.getMenuById(1L);

        Assertions.assertEquals(1L, menu.get().getId());
    }
}