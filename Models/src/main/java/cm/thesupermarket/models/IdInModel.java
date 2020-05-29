/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

/**
 *
 * @author ryank
 */
public class IdInModel {

    @Min(value = 1L)
    @Positive
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

}
