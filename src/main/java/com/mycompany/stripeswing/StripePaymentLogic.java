/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stripeswing;

/**
 *
 * @author ASUS
 */

//sk_test_51QeIHhEDZgu5gmswmQDnrBpKyFHVMmM6TeZr6s7FpfcSnPz2swoC9nD0URqJj6sYnj3mF7VcRDovTCR6fSRbv5cP00lt0xKPUK

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stripe.Stripe;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class StripePaymentLogic {
    private String name_customer;
    private double amount;
    public String StripePaymentLogic(String name_customer, double amount)  {
        Stripe.apiKey = "sk_test_51QeIHhEDZgu5gmswmQDnrBpKyFHVMmM6TeZr6s7FpfcSnPz2swoC9nD0URqJj6sYnj3mF7VcRDovTCR6fSRbv5cP00lt0xKPUK"; // Thay thế bằng khóa bí mật của Stripe

        try {
//            String name = "John Doe"; // Thay thế bằng tên người dùng
//            long amount = 1000000; // Thay thế bằng số tiền thanh toán (ví dụ: 1000000 VND)
////            String cardNumber = "4242424242424242"; // Thay thế bằng số thẻ của bạn
//            int expMonth = 12; // Thay thế bằng tháng hết hạn của thẻ
//            int expYear = 2023; // Thay thế bằng năm hết hạn của thẻ
//            String cvc = "123"; // Thay thế bằng mã CVC của thẻ
            // Tạo PaymentMethod sử dụng token thử nghiệm
            
            this.name_customer=name_customer;
            this.amount=amount;
            String paymentMethodId = createPaymentMethod();
            if (paymentMethodId == null) {
                return "error";
            }

            // Tạo PaymentIntent
            PaymentIntentResponse paymentIntentResponse = createPaymentIntent((long)amount, "VND", paymentMethodId);
            if (paymentIntentResponse == null) {
                return "error";
            }

            // Xác nhận thanh toán
            confirmPayment(paymentIntentResponse.getId(), paymentMethodId, name_customer);
            return paymentIntentResponse.getId();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    private static String createPaymentMethod() throws Exception {
//        String cardNumber = "4242424242424242"; // Thay thế bằng số thẻ của bạn
//        int expMonth = 12; // Thay thế bằng tháng hết hạn của thẻ
//        int expYear = 2023; // Thay thế bằng năm hết hạn của thẻ
//        String cvc = "123"; // Thay thế bằng mã CVC của thẻ
        URL url = new URL("https://api.stripe.com/v1/payment_methods");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + Stripe.apiKey);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String body = "type=card&card[token]=tok_visa"; 
        //String body = "type=card&card[number]=" + cardNumber + "&card[exp_month]=" + expMonth + "&card[exp_year]=" + expYear + "&card[cvc]=" + cvc;
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(body.getBytes(StandardCharsets.UTF_8));
        os.close();

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) { // HTTP OK
            Scanner scanner = new Scanner(connection.getInputStream());
            String response = scanner.useDelimiter("\\A").next();
            scanner.close();

            JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
            return jsonObject.get("id").getAsString(); // Trả về PaymentMethod ID
        } else {
            Scanner scanner = new Scanner(connection.getErrorStream());
            String response = scanner.useDelimiter("\\A").next();
            scanner.close();
            System.out.println("Failed to create PaymentMethod: " + response);
            return null;
        }
    }

    private static PaymentIntentResponse createPaymentIntent(long amount, String currency, String paymentMethodId) throws Exception {
        URL url = new URL("https://api.stripe.com/v1/payment_intents");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + Stripe.apiKey);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // Thêm tham số automatic_payment_methods[enabled] và automatic_payment_methods[allow_redirects]
        String body = "amount=" + amount + "&currency=" + currency + "&payment_method=" + paymentMethodId
                    + "&automatic_payment_methods[enabled]=true"
                    + "&automatic_payment_methods[allow_redirects]=never";
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(body.getBytes(StandardCharsets.UTF_8));
        os.close();

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) { // HTTP OK
            Scanner scanner = new Scanner(connection.getInputStream());
            String response = scanner.useDelimiter("\\A").next();
            scanner.close();

            JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
            return new PaymentIntentResponse(jsonObject.get("id").getAsString(), jsonObject.get("client_secret").getAsString());
        } else {
            Scanner scanner = new Scanner(connection.getErrorStream());
            String response = scanner.useDelimiter("\\A").next();
            scanner.close();
            System.out.println("Failed to create PaymentIntent: " + response);
            return null;
        }
    }

    private String confirmPayment(String paymentIntentId, String paymentMethodId, String name) throws Exception {
        URL url = new URL("https://api.stripe.com/v1/payment_intents/" + paymentIntentId + "/confirm");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + Stripe.apiKey);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // Chỉ gửi tham số payment_method
        String body = "payment_method=" + paymentMethodId;
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(body.getBytes(StandardCharsets.UTF_8));
        os.close();

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) { // HTTP OK
            Scanner scanner = new Scanner(connection.getInputStream());
            String response = scanner.useDelimiter("\\A").next();
            scanner.close();

            JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
            String status = jsonObject.get("status").getAsString();
            String paymentIntentIdResponse = jsonObject.get("id").getAsString();
            return paymentIntentIdResponse;
        } else {
            Scanner scanner = new Scanner(connection.getErrorStream());
            String response = scanner.useDelimiter("\\A").next();
            scanner.close();
            //System.out.println("Failed to confirm payment: " + response);
            return "Error";
        }
    }

    private static class PaymentIntentResponse {
        private final String id;
        private final String clientSecret;

        public PaymentIntentResponse(String id, String clientSecret) {
            this.id = id;
            this.clientSecret = clientSecret;
        }

        public String getId() {
            return id;
        }

        public String getClientSecret() {
            return clientSecret;
        }
    }
}











