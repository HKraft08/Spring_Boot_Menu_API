package com.example.spring_boot_menu_api.service;

import com.example.spring_boot_menu_api.dto.MenuRequest;
import com.example.spring_boot_menu_api.dto.MenuResponse;
import com.example.spring_boot_menu_api.entity.Menu;
import com.example.spring_boot_menu_api.exception.ResourceNotFoundException;
import com.example.spring_boot_menu_api.repository.MenuRepository;
import jakarta.transaction.Transactional;

import java.nio.file.ReadOnlyFileSystemException;

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

    //Update menu item
    @Transactional
    public MenuResponse updateItem(Long id, MenuRequest request) {

        Menu menu = findByIdOrThrow(id);

        menu.setItemName(request.itemName());
        menu.setExpiryDate(request.expiryDate());
        menu.setPrice(request.price());

        Menu updatedMenu = menuRepository.save(menu);

        return mapToResponse(updatedMenu);
    }

    private MenuResponse mapToResponse(Menu menu) {

        return new MenuResponse(
                menu.getId(),
                menu.getItemName(),
                menu.getExpiryDate(),
                menu.getPrice()
        );
    }

    private Menu findByIdOrThrow(Long id) {

        return menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("A menu item does not exist with ID: " + id));
    }
}
