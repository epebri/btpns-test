package com.mitrais.pos.controller;

import com.mitrais.pos.entity.Menu;
import com.mitrais.pos.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menus")
    public ResponseEntity<List<Menu>> getAllMenus(@RequestParam(required = false) String type, @RequestParam(required = false) String category) {
           try {
               List<Menu> menus = menuService.showMenu(type, category);
               return new ResponseEntity<>(menus, HttpStatus.OK);
           } catch (Exception e) {
               e.printStackTrace();
               return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
           }
    }
}
