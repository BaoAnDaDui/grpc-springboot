package com.baoan;

import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.examples.lib.HelloRequest;
import net.devh.boot.grpc.examples.lib.HelloServiceGrpc;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author wang xiao
 * @date 2022/5/24
 */
@Component
public class HelloClient {

    @GrpcClient("client")
    private HelloServiceGrpc.HelloServiceBlockingStub client;

    public String test(String name) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return client.test(request).getMessage();
    }

    @PostConstruct
    public void init() {
        String message = test("123");
        System.out.printf(message);
    }

}
