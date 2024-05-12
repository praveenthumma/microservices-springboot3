package com.tp.ms.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.ms.inventoryservice.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    public boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}
