//package zk;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.retry.ExponentialBackoffRetry;
//
///**
// * @author zhuhuipei
// * @Description:
// * @date 2020-04-15
// * @time 13:55
// */
//public class CuratorCreateSessionDemo {
//    final static String node_name = "zk-sync-test";
//
//    private final static String CONNECTSTRING = "pre-hadoop-master001:2181,pre-hadoop-master002:2181,pre-hadoop-master003:2181";
//
//    public static void main(String[] args) throws Exception {
//
//        CuratorFramework curatorFramework = CuratorFrameworkFactory
//                .builder()
//                .connectString(CONNECTSTRING)
//                .sessionTimeoutMs(5000)
//                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
//                .namespace(node_name)
//                .build();
//        curatorFramework.start();
//
//        curatorFramework.c create().forPath("/127.0.0.1");
//
//        System.out.println("success");
//    }
//}
