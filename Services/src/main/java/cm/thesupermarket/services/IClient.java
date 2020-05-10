/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import cm.thesupermarket.models.ClientOutModel;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author ryank
 */
public interface IClient {

    public void delete(String dataJson);

    public ClientOutModel create(String dataJson);

    public ClientOutModel update(String dataJson);

    public List<ClientOutModel> getAll(String dataJson);

    public ClientOutModel getClientById(String dataJson);
    //        Inscription ins = new Gson().fromJson(json, Inscription.class);  convertir json en classe
}
