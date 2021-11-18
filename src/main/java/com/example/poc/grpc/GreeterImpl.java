package com.example.poc.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreeterImpl extends com.example.poc.grpc.GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(com.example.poc.grpc.Hello.HelloRequest request, StreamObserver<com.example.poc.grpc.Hello.HelloReply> responseObserver) {
        com.example.poc.grpc.Hello.HelloReply reply = com.example.poc.grpc.Hello.HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void sayHelloAgain(com.example.poc.grpc.Hello.HelloRequest request, StreamObserver<com.example.poc.grpc.Hello.HelloReply> responseObserver) {
        com.example.poc.grpc.Hello.HelloReply reply = com.example.poc.grpc.Hello.HelloReply.newBuilder()
                .setMessage("Hello again ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
