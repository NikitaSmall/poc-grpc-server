package com.example.poc.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import static com.example.poc.PocServerApplication.logger;

@GrpcService
public class GreeterImpl extends com.example.poc.grpc.GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(com.example.poc.grpc.Hello.HelloRequest request, StreamObserver<com.example.poc.grpc.Hello.HelloReply> responseObserver) {
        logger.info("received the grpc request for hello endpoint");
        logger.info("received name parameter: " + request.getName());
        com.example.poc.grpc.Hello.HelloReply reply = com.example.poc.grpc.Hello.HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

        logger.info("sent the response successfully");
    }

    @Override
    public void sayHelloAgain(com.example.poc.grpc.Hello.HelloRequest request, StreamObserver<com.example.poc.grpc.Hello.HelloReply> responseObserver) {
        logger.info("received the grpc request for hello again endpoint");
        logger.info("received name parameter: " + request.getName());
        com.example.poc.grpc.Hello.HelloReply reply = com.example.poc.grpc.Hello.HelloReply.newBuilder()
                .setMessage("Hello again ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
        logger.info("sent the response successfully");
    }
}
