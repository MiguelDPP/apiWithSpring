package com.miguecode.market.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PurchaseItem {
    private long productId;
    private int quantity;
    private BigDecimal total;
    private boolean active;

    // getters and setters

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
