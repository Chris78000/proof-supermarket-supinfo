/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import cm.thesupermarket.models.ClientModel;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author ryank
 */
public interface IClient {

    public void delete(Long id);

    public ClientModel create(String dataJson);

    public ClientModel update(String dataJson);

    public List<ClientModel> getAll();

    public ClientModel getClientById(String dataJson);
    //        Inscription ins = new Gson().fromJson(json, Inscription.class);  convertir json en classe
}
