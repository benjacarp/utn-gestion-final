package edu.utn.gestion.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by martin on 25/12/15.
 */
@Entity
@Table(name = "order_to_supplier")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    @OneToMany(targetEntity = OrderDetail.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_detail_id", referencedColumnName = "id", nullable = false)
    private final List<OrderDetail> orderDetails = new ArrayList<>();

    /**
     * No-args constructor. Creates a new instance of <code>Order</code>.
     */
    public Order() {}

    /**
     * Creates a new instance of <code>Order</code>.
     *
     * @param status
     */
    public Order(OrderStatusEnum status) {
        this.status = status;
    }

    /**
     * Creates a new instance of <code>Order</code>.
     *
     * @param id
     * @param status
     */
    public Order(long id, OrderStatusEnum status) {
        this.id = id;
        this.status = status;
    }

    /**
     * Creates a new instance of <code>Order</code>.
     *
     * @param status
     * @param orderDetails
     */
    public Order(OrderStatusEnum status, List<OrderDetail> orderDetails) {
        this.creationDate = new Date();
        this.status = status;
        this.orderDetails.addAll(orderDetails);
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}