package com.controller;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beans.Order;
import com.service.OrderService;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/list")
    public String list(Model model) {
        List<Order> orders = orderService.getOrders();
        model.addAttribute("orders", orders);
        return "order/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        List<Order> order = orderService.getOrders();
        model.addAttribute("order", order);
        return "order/add";
    }

    @PostMapping("/save")
    public String save(Order order, RedirectAttributes redirectAttributes) {
        order.setOrderDate(new Date()); // 设置订单日期为当前日期时间

        orderService.saveOrder(order);
        redirectAttributes.addFlashAttribute("msg", "添加成功！");
        return "redirect:/order/list";
    }

    @GetMapping("/edit")
    public String edit(Integer orderNumber, Model model) {
        Order order = orderService.getOrderByOrderNumber(orderNumber);
        List<Order> orderList = orderService.getOrders();
        model.addAttribute("order", order);
        return "order/edit";
    }

    @PostMapping("/update")
    public String update(Order order, RedirectAttributes redirectAttributes) {
        orderService.updateOrder(order);
        redirectAttributes.addFlashAttribute("msg", "修改成功！");
        return "redirect:/order/list";
    }

    @GetMapping("/delete")
    public String delete(Integer id, RedirectAttributes redirectAttributes) {
        orderService.deleteOrder(id);
        redirectAttributes.addFlashAttribute("msg", "删除成功！");
        return "redirect:/order/list";
    }
    
    
}