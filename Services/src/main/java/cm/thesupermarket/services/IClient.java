/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import cm.thesupermarket.models.ClientInModel;
import cm.thesupermarket.models.ClientOutModel;
import cm.thesupermarket.models.SortModel;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author ryank
 */
public interface IClient {

    public void delete(ClientInModel dataJson);

    public ClientOutModel create(ClientInModel dataJson);

    public ClientOutModel update(ClientInModel dataJson);

    public List<ClientOutModel> getAll(SortModel sortModel);

    public ClientOutModel getClientById(ClientInModel dataJson);
    //        Inscription ins = new Gson().fromJson(json, Inscription.class);  convertir json en classe
}
