/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import cm.thesupermarket.models.OrderInModel;
import cm.thesupermarket.models.OrderOutModel;
import cm.thesupermarket.models.SortModel;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author Chris
 */
public interface IOrder {
    public void delete(OrderInModel dataJson);

    public OrderOutModel create(OrderInModel dataJson);
    
    public OrderOutModel update(OrderInModel data);

    public List<OrderOutModel> getAll(SortModel sortModel);

    public OrderOutModel getOrderById(OrderInModel dataJson);
}
