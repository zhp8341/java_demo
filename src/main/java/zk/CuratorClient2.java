package zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-04-15
 * @time 14:14
 */
public class CuratorClient2 {

    final static String node_name = "/zk-sync-test";
    final static String node_name_leader = "/zk-sync-test/leader";
    private final static String ZK_ADDRESS = "pre-hadoop-master001:2181,pre-hadoop-master002:2181,pre-hadoop-master003:2181";

    private CuratorFramework client = null;

    public CuratorFramework getClient() {
        return client;
    }

    public CuratorClient2() throws Exception {
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

        Stat stat_leader = client.checkExists().forPath(node_name_leader);
        if (stat_leader == null) {
            client.create().forPath(node_name_leader);
        }

       //this.zkWatch(node_name,client);

    }


    public static void main(String[] args) throws Exception {
        final CuratorClient2 curatorClient = new CuratorClient2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    curatorClient.client.create().withMode(CreateMode.EPHEMERAL).forPath(node_name + "/node3", "init3".getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        curatorClient.client.create().withMode(CreateMode.EPHEMERAL).forPath(node_name + "/node4", "init4".getBytes());



        Thread.sleep(1000 * 600);


    }




}
