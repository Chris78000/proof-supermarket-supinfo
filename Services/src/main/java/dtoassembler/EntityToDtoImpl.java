/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtoassembler;

import cm.thesupermarket.domain.OrderEntity;
import cm.thesupermarket.helpers.DateUtils;
import cm.thesupermarket.models.OrderOutModel;

/**
 *
 * @author Chris
 */
public class EntityToDtoImpl implements EntityToDto {
    @Override
    public OrderOutModel buildOrderDto(OrderEntity orderE) {
        OrderOutModel data = new OrderOutModel();
        data.setId(orderE.getId());
        data.setClientId(orderE.getClientId());
        data.setPurchaseId(orderE.getPurchaseId());
        data.setQuantity(orderE.getQuantity());
        data.setOrderDate(DateUtils.convertMillisToDate(orderE.getOrderDate()));
        data.setEstimatedDate(DateUtils.convertMillisToDate(orderE.getEstimatedDate()));
        
        return data;
    }
}
