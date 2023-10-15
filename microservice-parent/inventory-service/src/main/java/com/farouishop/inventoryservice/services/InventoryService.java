package com.farouishop.inventoryservice.services;

import com.farouishop.inventoryservice.dto.InventoryResponse;
import com.farouishop.inventoryservice.model.Inventory;

import java.util.List;

public interface InventoryService {
    public List<InventoryResponse> isInStock(List<String> skuCodes);
}
