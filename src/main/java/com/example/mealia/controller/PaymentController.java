package com.example.mealia.controller;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mealia.service.RazorPayService;
import com.razorpay.Order;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private RazorPayService razorpayService;

    @PostMapping("/create-order")
    public ResponseEntity<Map<String, String>> createOrder(@RequestBody Map<String, Object> data) {
        try {
            int amount = (int) data.get("amount");
            String currency = (String) data.get("currency");
            Order order = razorpayService.createOrder(amount, currency); // Assumes you have a service that creates orders
            Map<String, String> response = new HashMap<>();
            response.put("orderId", order.get("id"));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}


