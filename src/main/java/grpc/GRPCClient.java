package grpc;

import java.util.concurrent.TimeUnit;

import com.grpc.helloworld.GreeterGrpc;
import com.grpc.helloworld.HelloWorldProto.HelloReply;
import com.grpc.helloworld.HelloWorldProto.HelloRequest;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
public class GRPCClient {

  private final GreeterGrpc.GreeterBlockingStub greeterBlocStub;

  /**
   * 构造使用现有通道访问服务端的客户端
   */
  public GRPCClient(Channel channel) {
    // 'channel'在这里是Channel,而不是ManagedChannel,所有它负责关闭

    // 向代码传递通道可以使代码更容易测试，也可以更容易地重用通道。
    // 同时这里创建的是同步(阻塞)RPC服务。
    greeterBlocStub = GreeterGrpc.newBlockingStub(channel);
  }

  /** 向服务端发送请求 */
  public void greet(String name) {
    System.out.println("Will try to greet " + name + " ...");
    HelloRequest request = HelloRequest.newBuilder().setName(name).build();
    HelloReply response;
    try {
      response = greeterBlocStub.sayHello(request);
      System.out.println(greeterBlocStub.test2(request));
    } catch (StatusRuntimeException e) {
      System.out.println("WARNING, RPC failed: Status=" + e.getStatus());
      return;
    }
    System.out.println("Greeting: " + response.getMessage());
  }

  /**
   * 客户端启动入口，可以支持填写2个参数，否则使用默认值。 第1个参数是用户名。 第2个参数是目标服务器，格式IP:Port。
   */
  public static void main(String[] args) throws Exception {
    String user = "world";
    // 访问本机在50051端口上运行的服务
    String target = "localhost:50051";
    // 命令行用法帮助，允许将用户名和目标服务器作为命令行参数传入。
    if (args.length > 0) {
      if ("--help".equals(args[0])) {
        System.err.println("Usage: [name [target]]");
        System.err.println("");
        System.err.println("  name    The name you wish to be greeted by. Defaults to " + user);
        System.err.println("  target  The server to connect to. Defaults to " + target);
        System.exit(1);
      }
      user = args[0];
    }
    if (args.length > 1) {
      target = args[1];
    }

    // 创建到服务器的通信通道，通道是线程安全的和可重用的。
    // 通常在应用程序开始时创建通道，并重用直到应用程序关闭。
    ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
    try {
      GRPCClient client = new GRPCClient(channel);
      client.greet(user);
    } finally {
      // ManagedChannel使用像线程和TCP连接这样的资源。
      // 为了防止泄漏这些资源，通道应该在不再使用时关闭。
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
