/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

/**
 *
 * @author ryank
 */
public class ClientHasShippingCardInModel {

    @Min(value = 1)
    @Positive
    private Long clientId;

    @Min(value = 1)
    @Positive
    private Long shippingCardId;

    @Min(value = 1)
    @Positive
    private Long productsId;

    public ClientHasShippingCardInModel() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getShippingCardId() {
        return shippingCardId;
    }

    public void setShippingCardId(Long shippingCardId) {
        this.shippingCardId = shippingCardId;
    }

    public Long getProductsId() {
        return productsId;
    }

    public void setProductsId(Long productsId) {
        this.productsId = productsId;
    }

}
