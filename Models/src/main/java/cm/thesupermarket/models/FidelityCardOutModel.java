/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.models;

import java.util.Date;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author ryank
 */
public class FidelityCardOutModel {

    @NotNull
    @NotEmpty
    @Past
    private Date creationDate;

    @NotNull
    @NotEmpty
    @Past
    private Date lastModifiedDate;

    @FutureOrPresent
    @NotNull
    @NotEmpty
    private Date expiredDate;

    @PositiveOrZero
    private Long point;

    @NotNull
    @NotEmpty
    private String numero;

    @Positive
    @Min(value = 1L)
    private Long clientId;

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

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

}
