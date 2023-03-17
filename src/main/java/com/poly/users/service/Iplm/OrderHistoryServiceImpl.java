package com.poly.users.service.Iplm;

import com.poly.users.DTO.OrderDto;
import com.poly.users.DTO.OrderHistoryDto;
import com.poly.users.entity.Order;
import com.poly.users.entity.OrderHistory;
import com.poly.users.repository.OrderHistoryRepository;
import com.poly.users.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryRepository orderHistoryRepo;

    @Override
    public List<OrderHistoryDto> saveAll(List<OrderHistoryDto> orderHistoriesDto) {
        List<OrderHistory> orderHistories = orderHistoriesDto.stream().map(OrderHistory :: toEntity).collect(Collectors.toList());
        return this.orderHistoryRepo.saveAll(orderHistories).stream().map(OrderHistory :: toDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderHistoryDto> getByOrderId(Integer orderId) {
        return this.orderHistoryRepo.getAllByOrderId(orderId).stream().map(OrderHistory :: toDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getAllByUsername(String username) {
        return this.orderHistoryRepo.getAllOrderReturnByUsername(username).stream().map(Order:: toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        this.orderHistoryRepo.deleteById(id);
    }
}
