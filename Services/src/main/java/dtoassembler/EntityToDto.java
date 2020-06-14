/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtoassembler;

import cm.thesupermarket.domain.OrderEntity;
import cm.thesupermarket.models.OrderOutModel;

/**
 *
 * @author Chris
 */
public interface EntityToDto {
    public OrderOutModel buildOrderDto(OrderEntity orderE);
}
