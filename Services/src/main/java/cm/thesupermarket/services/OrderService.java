/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.thesupermarket.services;

import cm.thesupermarket.domain.OrderEntity;
import cm.thesupermarket.models.OrderInModel;
import cm.thesupermarket.models.OrderOutModel;
import cm.thesupermarket.models.SortModel;
import cm.thesupermarket.repository.IOrderRepository;
import dtoassembler.DtoToEntity;
import dtoassembler.EntityToDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chris
 */
@Service
public class OrderService implements IOrder {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final IOrderRepository orderRepository;
    private final DtoToEntity dtoToEntity;
    private final EntityToDto entityToDto;

    @Autowired
    public OrderService(
            @Qualifier("IOrderRepository") IOrderRepository orderRepository,
            DtoToEntity dtoToEntity,
            EntityToDto entityToDto
    ) {
        this.orderRepository = orderRepository;
        this.entityToDto = entityToDto;
        this.dtoToEntity = dtoToEntity;
    }

    @PostConstruct
    public void init() {
        log.info("Initializing " + getClass().getSimpleName() + " ...");
        Validate.notNull(orderRepository, "clientRepository can't be null");
        log.info(getClass().getSimpleName() + " successfully initialized");
    }

    @Override
    @Transactional
    public void delete(OrderInModel data) {
        Validate.notNull(data, "data can't be empty or null");
        OrderEntity orderE = dtoToEntity.buildOrderDto(data);
        orderRepository.delete(orderE);
    }

    @Override
    @Transactional
    public OrderOutModel create(OrderInModel data) {
        Validate.notNull(data, "data can't be empty or null");
        OrderEntity orderE = dtoToEntity.buildOrderDto(data);
        return entityToDto.buildOrderDto(orderRepository.save(orderE));
    }

    @Override
    @Transactional
    public OrderOutModel update(OrderInModel data) {
        Validate.notNull(data, "data can't be empty or null");
        OrderEntity orderE = dtoToEntity.buildOrderDto(data);
        return entityToDto.buildOrderDto(orderRepository.save(orderE));
    }

    @Override
    @Transactional
    public List<OrderOutModel> getAll(SortModel sortModel) {
        Validate.notNull(sortModel != null, "dataJson can't be empty or null");

        Page<OrderEntity> orderE = orderRepository.findAll(PageRequest.of(sortModel.getPage(), sortModel.getSize()));
        List<OrderOutModel> data = new ArrayList<>();
        orderE.forEach((cnsmr) -> {
            data.add(entityToDto.buildOrderDto(cnsmr));
        });

        return data;
    }

    @Override
    @Transactional
    public OrderOutModel getOrderById(OrderInModel data) {
        Validate.notNull(data, "data can't be empty or null");
        OrderEntity orderE = dtoToEntity.buildOrderDto(data);
        OrderEntity dataOut = orderRepository.getOne(orderE.getId());
        return entityToDto.buildOrderDto(dataOut);

    }
}
