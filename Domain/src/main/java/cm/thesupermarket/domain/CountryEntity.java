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
@Entity(name = "CountryEntity")
@Table(name = "country")
public class CountryEntity implements Serializable, Persistable<Long> {

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

    @Column(name = "creation_date", nullable = true, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "last_modified_date", nullable = true, updatable = true)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "country_name", nullable = false, unique = true)
    private String name;

    @Column(name = "iso_code", nullable = true, unique = true)
    private String iso_code;

    @Column(name = "tel_indicative_code", nullable = false, unique = false)
    private String tel_indicative_code;

    @Column(name = "currency_name", nullable = false, unique = false)
    private String currency_name;

    @Column(name = "currency_symbol", nullable = true, unique = false)
    private String currency_symbol;

    @Column(name = "currency_code", nullable = true, unique = false)
    private String currency_code;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "countryId", cascade = CascadeType.ALL, orphanRemoval = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final List<ClientEntity> ClientEntityList;

    @OneToMany(mappedBy = "countryId", cascade = CascadeType.ALL, orphanRemoval = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final List<ShippingAddressEntity> ShippingAddressEntityList;

    public CountryEntity() {
        this.ClientEntityList = new ArrayList<>();
        this.ShippingAddressEntityList = new ArrayList<>();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso_code() {
        return iso_code;
    }

    public void setIso_code(String iso_code) {
        this.iso_code = iso_code;
    }

    public String getTel_indicative_code() {
        return tel_indicative_code;
    }

    public void setTel_indicative_code(String tel_indicative_code) {
        this.tel_indicative_code = tel_indicative_code;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    @PrePersist
    @PreUpdate
    protected void prePersistAndPreUpdate() {
        Validate.notNull(creationDate, "createDate must not be null");

        Validate.isTrue(creationDate.getTime() < System.currentTimeMillis(), "creationDate cannot be in the past");
    }

}
