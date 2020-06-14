/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtoassembler;

import cm.thesupermarket.domain.OrderEntity;
import cm.thesupermarket.models.OrderInModel;
import cm.thesupermarket.models.OrderOutModel;
import com.google.gson.Gson;

/**
 *
 * @author Chris
 */
public interface DtoToEntity {
    public OrderEntity buildOrderDto(OrderInModel data);
}
