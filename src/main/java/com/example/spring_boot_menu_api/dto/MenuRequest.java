package com.example.spring_boot_menu_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MenuRequest(
        @NotBlank(message = "Item name is required")
        @Size(max = 100, message = "Item name must not exceed 100 characters")
        String itemName,

        @NotNull(message = "Expiry date is required")
        @FutureOrPresent(message = "Expiry date cannot be in the past")
        @JsonFormat(pattern = "yyyy/MM/dd")
        LocalDate expiryDate,

        @NotNull(message = "Item price is required")
        @DecimalMin(value = "0.01", message = "Item price must be greater than 0")
        BigDecimal price
) {
}
