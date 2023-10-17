package com.farouishop.inventoryservice.controller;

import com.farouishop.inventoryservice.dto.InventoryResponse;
import com.farouishop.inventoryservice.model.Inventory;
import com.farouishop.inventoryservice.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    //http:localhost:8082/api/inventory?skuCode=dell&skuCode=sumsung&skuCode=iphone
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}


