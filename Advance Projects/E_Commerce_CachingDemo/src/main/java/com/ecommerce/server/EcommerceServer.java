package com.ecommerce.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.util.HibernateUtil;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

public class EcommerceServer {

    private static final ObjectMapper mapper =
            new ObjectMapper();

    private static final ProductDao dao =
            new ProductDao();

    public static void main(String[] args)
            throws IOException {

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8085), 0
        );

        server.createContext("/", exchange -> {

            try {

                String path =
                        exchange.getRequestURI().getPath();

                if (path.equals("/api/products")) {

                    if (!exchange.getRequestMethod()
                            .equals("GET")) {

                        send(exchange, 405,
                                "Method Not Allowed");
                        return;
                    }

                    Object products = dao.getAllProducts();

                    byte[] response =
                            mapper.writeValueAsBytes(products);

                    exchange.getResponseHeaders().set(
                        "Content-Type",
                        "application/json; charset=UTF-8"
                    );

                    exchange.sendResponseHeaders(
                        200, response.length
                    );

                    try (var output =
                            exchange.getResponseBody()) {

                        output.write(response);
                    }

                } else {

                    serveStatic(exchange, path);
                }

            } catch (Exception e) {

                e.printStackTrace();

                if (exchange.getResponseCode() == -1) {
                    send(exchange, 500,
                            "Internal Server Error");
                }
            }
        });

        Runtime.getRuntime().addShutdownHook(
            new Thread(() -> {
                server.stop(0);
                HibernateUtil.shutdown();
            })
        );

        server.start();

        System.out.println(
            "Server running at http://localhost:8085"
        );
    }

    private static void serveStatic(
            HttpExchange exchange, String path)
            throws IOException {

        if (!exchange.getRequestMethod().equals("GET")) {
            send(exchange, 405, "Method Not Allowed");
            return;
        }

        if (path.equals("/")) {
            path = "/index.html";
        }

        if (path.contains("..")) {
            send(exchange, 400, "Invalid path");
            return;
        }

        String resource = "/static" + path;

        try (InputStream input =
                EcommerceServer.class
                    .getResourceAsStream(resource)) {

            if (input == null) {
                send(exchange, 404, "Not Found");
                return;
            }

            byte[] content = input.readAllBytes();

            String contentType = "text/plain";

            if (path.endsWith(".html")) {
                contentType = "text/html; charset=UTF-8";
            } else if (path.endsWith(".css")) {
                contentType = "text/css; charset=UTF-8";
            } else if (path.endsWith(".js")) {
                contentType =
                    "application/javascript; charset=UTF-8";
            }

            exchange.getResponseHeaders().set(
                "Content-Type", contentType
            );

            exchange.sendResponseHeaders(
                200, content.length
            );

            try (var output = exchange.getResponseBody()) {
                output.write(content);
            }
        }
    }

    private static void send(
            HttpExchange exchange,
            int status, String message)
            throws IOException {

        byte[] response =
            message.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().set(
            "Content-Type", "text/plain; charset=UTF-8"
        );

        exchange.sendResponseHeaders(
            status, response.length
        );

        try (var output = exchange.getResponseBody()) {
            output.write(response);
        }
    }
}