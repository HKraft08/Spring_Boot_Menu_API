package com.example.spring_boot_menu_api.service;

import com.example.spring_boot_menu_api.dto.MenuRequest;
import com.example.spring_boot_menu_api.dto.MenuResponse;
import com.example.spring_boot_menu_api.entity.Menu;
import com.example.spring_boot_menu_api.repository.MenuRepository;
import jakarta.transaction.Transactional;

public class MenuService {

    private final MenuRepository menuRepository;

    MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    //Create menu item
    @Transactional
    public MenuResponse createItem(MenuRequest request) {

        Menu menu = new Menu();

        menu.setItemName(request.itemName());
        menu.setExpiryDate(request.expiryDate());
        menu.setPrice(request.price());

        Menu savedItem = menuRepository.save(menu);

        return mapToResponse(savedItem);
    }

    private MenuResponse mapToResponse(Menu menu) {

        return new MenuResponse(
                menu.getId(),
                menu.getItemName(),
                menu.getExpiryDate(),
                menu.getPrice()
        );
    }
}
