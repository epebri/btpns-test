package com.mitrais.pos.controller;

import com.mitrais.pos.entity.Menu;
import com.mitrais.pos.model.response.ResponseHandler;
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
    public ResponseEntity<ResponseHandler> getAllMenus(@RequestParam(required = false) String type, @RequestParam(required = false) String category) {
        ResponseHandler response = new ResponseHandler();
        try {
            List<Menu> menus = menuService.showMenu(type, category);
            response.setCode(200L);
            response.setMessage("Get Data menu success!");
            response.setData(menus);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(500L);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
