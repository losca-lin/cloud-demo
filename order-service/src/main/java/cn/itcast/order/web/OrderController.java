package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId
            , @RequestHeader(value = "Truth",required = false) String Truth) {
        System.out.println(Truth);
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }

    @GetMapping("/update")
    public String update(){
        return "订单更新中...";
    }

    @GetMapping("/query")
    public String query(){
        // 查询商品
        orderService.queryGoods();
        // 查询订单
        System.out.println("查询订单");
        return "订单查询中...";
    }

    @GetMapping("/save")
    public String saveOrder() {
        // 查询商品
        orderService.queryGoods();
        // 查询订单
        System.err.println("新增订单");
        return "新增订单成功";
    }

}
