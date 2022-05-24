package com.baoan;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.examples.lib.HelloReply;
import net.devh.boot.grpc.examples.lib.HelloRequest;
import net.devh.boot.grpc.examples.lib.HelloServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author wang xiao
 * @date 2022/5/24
 */
@GrpcService
public class MyHelloService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void test(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("111").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


}
