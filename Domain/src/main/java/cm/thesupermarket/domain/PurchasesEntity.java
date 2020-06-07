/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import org.apache.commons.lang.Validate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

/**
 *
 * @author ryank
 */
@Entity(name = "PurchasesEntity")
@Table(name = "purshases")
public class PurchasesEntity implements Serializable, Persistable<Long> {

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

    @Positive
    @Min(value = 1)
    @Column(name = "quantity", nullable = false, unique = false)
    private int quantity;

    @Column(name = "purchases_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchases_date;

    @Column(name = "creation_date", nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "last_modified_date", nullable = true, updatable = true)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    
     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suppliers_id", nullable = false)
    private SuppliersEntity suppliers_id;
     
      @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id", nullable = false)
    private ProductsEntity products_id;

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public boolean isNew() {
        return Id == null;
    }

    @PrePersist
    @PreUpdate
    protected void prePersistAndPreUpdate() {
        Validate.notNull(creationDate, "createDate must not be null");
           Validate.notNull(products_id, "products_id can't be null");
           Validate.notNull(suppliers_id, "suppliers_id can't be null");
        Validate.isTrue(creationDate.getTime() < System.currentTimeMillis(), "creationDate cannot be in the past");
    }
}
