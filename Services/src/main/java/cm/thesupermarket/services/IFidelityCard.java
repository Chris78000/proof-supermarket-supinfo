/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import cm.thesupermarket.models.FidelityCardInModel;
import cm.thesupermarket.models.FidelityCardOutModel;
import cm.thesupermarket.models.IdInModel;

/**
 *
 * @author ryank
 */
public interface IFidelityCard {
    
    public void createFidelityCard(FidelityCardInModel data);
    public void updateFidelityCard(FidelityCardInModel data);
    public void removeFidelityCard(FidelityCardInModel data);
    public FidelityCardOutModel getFidelityCard(IdInModel data);
}
