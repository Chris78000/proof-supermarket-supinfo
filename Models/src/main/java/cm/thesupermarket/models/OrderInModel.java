/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.models;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.Validate;

/**
 *
 * @author Chris
 */
public class OrderInModel {
    private Long id;
    private Long clientId;
    private Long purchaseId;
    private Date orderDate;
    private int quantity;
    
    public OrderInModel() {   
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Validate.isTrue(id > 0, "Json data can't contains empty or null element");
        this.id = id;
    }
    
    public Long getClientId() {
        return clientId;
    }
    
    public void setClientId(Long clientId) {
        Validate.isTrue(id > 0, "Json data can't contains empty or null element");
        this.clientId = clientId;
    }
    
    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        Validate.isTrue(id > 0, "Json data can't contains empty or null element");
        this.purchaseId = purchaseId;
    }
    
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        Validate.isTrue(orderDate != null, "Json data can't contains empty or null element");
        this.orderDate = orderDate;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
