package com.poly.users.service;

import com.poly.users.DTO.OrderDto;
import com.poly.users.DTO.OrderHistoryDto;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistoryDto> saveAll(List<OrderHistoryDto> orderHistoriesDto);
    List<OrderHistoryDto> getByOrderId(Integer orderId);
    List<OrderDto> getAllByUsername(String username);
    void delete(Integer id);
}
