/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.repository;

import cm.thesupermarket.domain.ProductsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ryank
 */

@Repository("IProductsTypeRepository")
public interface IProductsTypeRepository extends JpaRepository<ProductsTypeEntity, Long>{
    
}
