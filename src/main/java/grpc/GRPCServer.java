package grpc;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * gRPC服务启动类,启动时注册添加需要对外提供的服务类
 */
public class GRPCServer {

  private Server server;

  private void start() throws IOException {
    // 服务运行端口
    int port = 50051;
    // 注册对外提供的服务
    server = ServerBuilder.forPort(port).addService(new GreeterImpl()).build().start();
    System.out.println("Server started, listening on " + port);

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // 使用标准错误输出，因为日志记录器有可能在JVM关闭时被重置
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        try {
          GRPCServer.this.stop();
        } catch (InterruptedException e) {
          e.printStackTrace(System.err);
        }
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() throws InterruptedException {
    if (server != null) {
      server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
    }
  }

  /**
   * 在主线程上等待终止，因为grpc库使用守护进程。
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  /**
   * 启动服务Main方法
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    final GRPCServer server = new GRPCServer();
    server.start();
    server.blockUntilShutdown();
  }
}