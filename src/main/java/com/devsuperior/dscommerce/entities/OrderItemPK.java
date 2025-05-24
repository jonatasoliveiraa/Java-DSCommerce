package com.devsuperior.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Embeddable
@NoArgsConstructor
public class OrderItemPK {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(getOrder(), that.getOrder()) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getOrder());
        result = 31 * result + Objects.hashCode(getProduct());
        return result;
    }
}
