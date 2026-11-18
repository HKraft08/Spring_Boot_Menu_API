package com.example.spring_boot_menu_api.repository;

import com.example.spring_boot_menu_api.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
