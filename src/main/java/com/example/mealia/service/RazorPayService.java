package com.example.mealia.service;
import com.razorpay.RazorpayClient;
import com.razorpay.Order;
import com.razorpay.Payment;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorPayService {

    private RazorpayClient client;

    @Value("${razorpay.key}")
    private String razorpayKey;

    @Value("${razorpay.secret}")
    private String razorpaySecret;

    public void RazorpayService() throws Exception {
        this.client = new RazorpayClient(razorpayKey, razorpaySecret);
    }

    public Order createOrder(int amount, String currency) throws Exception {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // Amount in paise (i.e., INR 100 = 10000 paise)
        orderRequest.put("currency", currency);
        orderRequest.put("receipt", "txn_123456");

        return client.orders.create(orderRequest);
    }

    public Payment fetchPayment(String paymentId) throws Exception {
        return client.payments.fetch(paymentId);
    }
}

