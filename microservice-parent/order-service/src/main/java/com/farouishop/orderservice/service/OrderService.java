package com.farouishop.orderservice.service;

import com.farouishop.orderservice.dtos.InventoryResponse;
import com.farouishop.orderservice.dtos.OrderLineItemsDto;
import com.farouishop.orderservice.dtos.OrderRequest;
import com.farouishop.orderservice.model.Order;
import com.farouishop.orderservice.model.OrderLineItems;
import com.farouishop.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService{
    private final OrderRepository orderRepository;
    private final WebClient webClient;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItemsList=orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItems(orderLineItemsList);
        List<String> skuCodes=order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        //Call Inventory Service,and place order if product is in stock
        InventoryResponse[] inventoryResponseArray=webClient.get()
        //http:localhost:8082/api/inventory?sku-code=dell&sku-code=sumsung&sku-code=iphone
                        .uri("http://localhost:8082/api/inventory",
                                uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                        .retrieve()
                        .bodyToMono(InventoryResponse[].class)
                        .block();
        boolean allProductsInStock=Arrays.stream(inventoryResponseArray)
                .allMatch(InventoryResponse::isInStock);
        if(allProductsInStock)orderRepository.save(order);
        else {
            throw new IllegalArgumentException("Product not in store please try again");
        }
    }
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;

    }

}
