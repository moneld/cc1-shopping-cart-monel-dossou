package me.moneld.cc1_panner_achat_monel_dossou.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.Objects;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
@NotNull
    private Integer customerId;
    @NotNull
    private Integer productId;
    @NotNull
    private Integer quantity;
    @NotNull
    private Integer amount;


    private String status = "IN_PROGRESS";


    private  Date cratedAt = new Date();

    public Cart() {
    }

    public Cart(Integer customerId, Integer productId, Integer quantity, Integer amount) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
        this.cratedAt = cratedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(Date cratedAt) {
        this.cratedAt = cratedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart cart)) return false;
        return Objects.equals(getId(), cart.getId()) && Objects.equals(getCustomerId(), cart.getCustomerId()) && Objects.equals(getProductId(), cart.getProductId()) && Objects.equals(getQuantity(), cart.getQuantity()) && Objects.equals(getAmount(), cart.getAmount()) && Objects.equals(getStatus(), cart.getStatus()) && Objects.equals(getCratedAt(), cart.getCratedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerId(), getProductId(), getQuantity(), getAmount(), getStatus(), getCratedAt());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", cratedAt=" + cratedAt +
                '}';
    }
}
