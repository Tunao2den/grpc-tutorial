package com.tuna.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import java.lang.String;

@GrpcService
public class DemoServiceImpl extends DemoServiceGrpc.DemoServiceImplBase{
    @Override
    public void hello(DemoRequest request, StreamObserver<DemoResponse> responseObserver) {
        String demoRequest = request.getMessage();
        System.out.println("sending your message:" + demoRequest + "...");

        DemoResponse demoResponse = DemoResponse.newBuilder()
                .setMessage(demoRequest + " (a message from server!)")
                .build();

        responseObserver.onNext(demoResponse);
        responseObserver.onCompleted();
    }
}
