/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
 * @author ryank
 */
@Entity(name = "ProductsType")
@Table(name = "products_type")
public class ProductsTypeEntity implements Serializable, Persistable<Long> {

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

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "creation_date", nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "last_modified_date", nullable = true, updatable = true)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @OneToMany(mappedBy = "products_type_id", cascade = CascadeType.ALL, orphanRemoval = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final List<ProductsEntity> ProductsEntityList;

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public boolean isNew() {
        return Id == null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductsTypeEntity(List<ProductsEntity> ProductsEntityList) {
        this.ProductsEntityList = ProductsEntityList;
    }

    @PrePersist
    @PreUpdate
    protected void prePersistAndPreUpdate() {
        Validate.notNull(creationDate, "createDate must not be null");
        //   Validate.notNull(sexId, "sexId can't be null");
        //   Validate.notNull(countryId, "countryId can't be null");
        Validate.isTrue(creationDate.getTime() < System.currentTimeMillis(), "creationDate cannot be in the past");
    }

}
