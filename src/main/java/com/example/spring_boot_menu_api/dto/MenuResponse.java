package com.example.spring_boot_menu_api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MenuResponse(
        Long id,
        String itemName,
        LocalDate expiryDate,
        BigDecimal price
) {
}
