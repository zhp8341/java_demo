package grpc;

import com.grpc.helloworld.GreeterGrpc;
import com.grpc.helloworld.HelloWorldProto;
import com.grpc.helloworld.HelloWorldProto.HelloReply;
import com.grpc.helloworld.HelloWorldProto.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {


  @Override
  public void sayHelloAgain(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    super.sayHelloAgain(request, responseObserver);
  }

  @Override
  public void test2(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    super.test2(request, responseObserver);
  }

  @Override
  public void test3(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    super.test3(request, responseObserver);
  }

  @Override
  public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
    System.out.println(HelloWorldProto.TransferStatus.values());
    HelloReply reply = HelloReply.newBuilder().setMessage("[GreeterImpl]Hello " + req.getName()).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
//
//  @Override
//  public void sayHelloAgain(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
//    HelloReply reply = HelloReply.newBuilder().setMessage("[GreeterImpl]Hello again " + req.getName()).build();
//    responseObserver.onNext(reply);
//    responseObserver.onCompleted();
//  }
}
