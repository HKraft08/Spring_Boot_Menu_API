package com.example.spring_boot_menu_api.controller;

import com.example.spring_boot_menu_api.dto.MenuRequest;
import com.example.spring_boot_menu_api.dto.MenuResponse;
import com.example.spring_boot_menu_api.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/menu")
public class MenuController {

    private final MenuService menuService;

    MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    //Create menu item
    @PostMapping
    public ResponseEntity<MenuResponse> createItem(@Valid @RequestBody MenuRequest request) {

        MenuResponse response = menuService.createItem(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }

    //Update menu item
    @PutMapping("/{id}")
    public ResponseEntity<MenuResponse> updateItem(
            @PathVariable Long id, @Valid @RequestBody MenuRequest request) {

        return ResponseEntity.ok(menuService.updateItem(id, request));
    }

    //Delete menu item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {

        menuService.deleteItem(id);

        return ResponseEntity.noContent().build();
    }
}
