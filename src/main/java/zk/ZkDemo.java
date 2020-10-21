package zk;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-04-15
 * @time 10:28
 */
public class ZkDemo {

    final static String node_name = "/zk-sync-test";
    final static String node_name_ip = node_name + "/127.0.0.1";

    private static String zkip = "pre-hadoop-master001:2181,pre-hadoop-master002:2181,pre-hadoop-master003:2181";

    private static ZooKeeper zk;

    static {
        try {
            zk = new ZooKeeper(zkip, 6000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("Receive event " + watchedEvent);
                    if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                        System.out.println("connection is ok");
                    }
                }
            });

            //根节点
            Stat stat = zk.exists(node_name, false);
            if (stat == null) {
                String path1 = zk.create(node_name, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                System.out.println(path1);
            } else {
                System.out.println("节点存在");
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                     System.out.println("=====================");
                    zk.create(node_name_ip, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, new AsyncCallback.StringCallback() {
                        @Override
                        public void processResult(int i, String s, Object o, String s1) {
                            System.out.println(o);
                            System.out.println(i);
                            System.out.println(s1);
                            System.out.println(s);
                        }
                    }, "a");
                }
            }).start();
            Thread.sleep(1000*6000);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {


        byte[] data = zk.getData(node_name_ip, false, null);
        System.out.println(new String(data));
        zk.setData(node_name_ip, "吕金刚".getBytes(), 0);
        byte[] data2 = zk.getData(node_name_ip, false, null);
        System.out.println(new String(data2));

        System.out.println(new String(data));
    }
}
