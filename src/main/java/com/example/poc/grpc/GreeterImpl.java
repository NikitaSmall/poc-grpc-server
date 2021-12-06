package com.example.poc.grpc;

import io.grpc.stub.StreamObserver;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import net.devh.boot.grpc.server.service.GrpcService;

import static com.example.poc.config.Config.INSTRUMENTATION_NAME_GRPC;

@GrpcService
public class GreeterImpl extends com.example.poc.grpc.GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(com.example.poc.grpc.Hello.HelloRequest request, StreamObserver<com.example.poc.grpc.Hello.HelloReply> responseObserver) {
        Span span = GlobalOpenTelemetry.get().getTracer(INSTRUMENTATION_NAME_GRPC).spanBuilder("received the grpc request for hello endpoint").startSpan();
        span.addEvent("received name parameter: " + request.getName());
        com.example.poc.grpc.Hello.HelloReply reply = com.example.poc.grpc.Hello.HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

        span.addEvent("sent the response successfully");
        span.end();
    }

    @Override
    public void sayHelloAgain(com.example.poc.grpc.Hello.HelloRequest request, StreamObserver<com.example.poc.grpc.Hello.HelloReply> responseObserver) {
        Span span = GlobalOpenTelemetry.get().getTracer(INSTRUMENTATION_NAME_GRPC).spanBuilder("received the grpc request for hello again endpoint").startSpan();
        span.addEvent("received name parameter: " + request.getName());
        com.example.poc.grpc.Hello.HelloReply reply = com.example.poc.grpc.Hello.HelloReply.newBuilder()
                .setMessage("Hello again ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
        span.addEvent("sent the response successfully");
        span.end();
    }
}
