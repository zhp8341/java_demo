package zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-04-15
 * @time 14:14
 */
public class CuratorClient {

    final static String node_name = "/zk-sync-test";
    private final static String ZK_ADDRESS = "pre-hadoop-master001:2181,pre-hadoop-master002:2181,pre-hadoop-master003:2181";

    private CuratorFramework client = null;

    public CuratorClient() throws Exception {
        //重试策略,重试3次,间隔2S
        RetryPolicy retryPolicy = new RetryNTimes(3, 3000);
        client = CuratorFrameworkFactory.builder()
                .connectString(ZK_ADDRESS)
                .sessionTimeoutMs(1000*600)
                .connectionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .build();
        client.start();

        Stat stat = client.checkExists().forPath(node_name);
        if (stat == null) {
            client.create().forPath(node_name);

        }
       this.zkWatch(node_name,client);

    }


    public static void main(String[] args) throws Exception {
        final CuratorClient curatorClient = new CuratorClient();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    curatorClient.client.create().withMode(CreateMode.EPHEMERAL).forPath(node_name + "/node1", "".getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        curatorClient.client.create().withMode(CreateMode.EPHEMERAL).forPath(node_name + "/node2", "".getBytes());

        curatorClient.client.setData().forPath(node_name + "/node2/1","data".getBytes());
        curatorClient.client.setData().forPath(node_name + "/node2/2","data2".getBytes());
        Thread.sleep(1000 * 600);


    }

    private  void zkWatch(String path, CuratorFramework client) throws Exception {
//        NodeCache cn = new NodeCache(client, path);
//        cn.getListenable().addListener(new NodeCacheListener() {
//            @Override
//            public void nodeChanged() throws Exception {
//                System.out.println("===============");
//            }
//        });
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, path, true);
        pathChildrenCache.start();
        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
                System.out.println("事件:" + event.getType());
                System.out.println("数据:" + event.getData().getPath() + "," + new String(event.getData().getData()));
            }
        };
        pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);

    }



}
