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
@Entity(name = "CommentsEntity")
@Table(name = "comments")
public class CommentsEntity implements Serializable, Persistable<Long> {
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
    private Long adminId;
    
    @Column(name = "message", nullable = false, unique = false)
    private String message;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", nullable = false, updatable = false)
    private OrderEntity orderId;
    
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
    
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
    
    public Long getAdminId() {
        return adminId;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public OrderEntity getOrderEntityId() {
        return orderId;
    }
    
    public void setOrderEntityId(OrderEntity orderId) {
        this.orderId = orderId;
    }
}
