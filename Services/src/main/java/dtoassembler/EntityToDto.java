/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtoassembler;

import cm.thesupermarket.domain.ClientEntity;
import cm.thesupermarket.models.ClientOutModel;

/**
 *
 * @author ryank
 */
public interface EntityToDto {

    public ClientOutModel buildClientDto(ClientEntity clientE);
    
}
