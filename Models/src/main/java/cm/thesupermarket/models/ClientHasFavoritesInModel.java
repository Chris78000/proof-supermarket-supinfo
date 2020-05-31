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
public class ClientHasFavoritesInModel {

    @Min(value = 1L)
    @Positive
    private Long clientId;

    @Min(value = 1L)
    @Positive
    private Long productId;

    public ClientHasFavoritesInModel() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
