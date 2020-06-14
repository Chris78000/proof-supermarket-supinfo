/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import org.apache.commons.lang.Validate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

/**
 *
 * @author Chris
 */
@Entity(name = "OrderEntity")
@Table(name = "order")
public class OrderEntity implements Serializable, Persistable<Long> {
    @Id
    @Column(nullable = false, name = "id")
    @GeneratedValue(generator = "ALERT_SEQ_GEN")
    @GenericGenerator(
            name = "ALERT_SEQ_GEN",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                @Parameter(name = "sequence_name", value = "ALERT_SEQ_GEN"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long Id;
    private Long clientId;
    private Long purchaseId;
    
    @Column(name = "orderDate", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    
    @Column(name = "estimatedDate", nullable = false, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date estimatedDate;
    
    @Column(name = "quantity", nullable = false, unique = false)
    private int quantity = 1;
    
    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final List<CommentsEntity> commentsList;
    
    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final List<LitigationEntity> litigationList;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderStateId", nullable = false, updatable = false)
    private OrderStateEntity orderStateId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderTypeId", nullable = false, updatable = false)
    private OrderTypeEntity orderTypeId;
    
    public OrderEntity() {
        this.commentsList = new ArrayList<>();
        this.litigationList = new ArrayList<>();
    }
    
    public void setId(Long Id) {
        this.Id = Id;
    }
    
    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public boolean isNew() {
        return Id == null;
    }
    
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    
    public Long getClientId() {
        return clientId;
    }
    
    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }
    
    public Long getPurchaseId() {
        return purchaseId;
    }
    
    public Date getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    public Date getEstimatedDate() {
        return estimatedDate;
    }
    
    public void setEstimatedDate(Date estimatedDate) {
        this.estimatedDate = estimatedDate;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public OrderStateEntity getOrderStateId() {
        return orderStateId;
    }
    
    public void setOrderStateId(OrderStateEntity orderStateId) {
        this.orderStateId = orderStateId;
    }
    
    public OrderTypeEntity getOrderTypeId() {
        return orderTypeId;
    }
    
    public void setOrderTypeId(OrderTypeEntity orderTypeId) {
        this.orderTypeId = orderTypeId;
    }
    
    @PrePersist
    @PreUpdate
    protected void prePersistAndPreUpdate() {
        Validate.notNull(orderDate, "orderDate must not be null");
        Validate.isTrue(orderDate.getTime() < System.currentTimeMillis(), "creationDate cannot be in the past");
    }
}
