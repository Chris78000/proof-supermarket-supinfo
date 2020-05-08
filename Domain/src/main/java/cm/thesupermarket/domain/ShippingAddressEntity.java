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
@Entity(name = "ShippingAddressEntity")
@Table(name = "shipping_address")
public class ShippingAddressEntity implements Serializable, Persistable<Long> {

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

    @OneToMany(mappedBy = "shippingAddressId", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final List<ClientHasShippingAddressEntity> clientHasShippingAddressList;

    @Column(name = "creation_date", nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "last_modified_date", nullable = true, updatable = true)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "zipCode", nullable = false, unique = false)
    private String zipode;

    @Column(name = "description", nullable = false, unique = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId", nullable = false)
    private CountryEntity countryId;

    public ShippingAddressEntity() {
        this.clientHasShippingAddressList = new ArrayList<>();
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getZipode() {
        return zipode;
    }

    public void setZipode(String zipode) {
        this.zipode = zipode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CountryEntity getCountryId() {
        return countryId;
    }

    public void setCountryId(CountryEntity countryId) {
        this.countryId = countryId;
    }

    @PrePersist
    @PreUpdate
    protected void prePersistAndPreUpdate() {
        Validate.notNull(creationDate, "createDate must not be null");
        Validate.notNull(countryId, "countryId can't be null");
        Validate.isTrue(creationDate.getTime() < System.currentTimeMillis(), "creationDate cannot be in the past");
    }
}
