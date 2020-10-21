package zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatch;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-04-17
 * @time 17:23
 */
public class LeaderLatchDemo {

    public static void main(String[] args) throws Exception {
        CuratorClient2 curatorClient2=new CuratorClient2();
        CuratorFramework client=curatorClient2.getClient();
        final  String node_name_leader = "/zk-sync-test/leader";
        LeaderLatch leaderLatch = new LeaderLatch(client, node_name_leader);
        leaderLatch.start();
        leaderLatch.await();//阻塞等待自己有领导权
        System.out.println("LeaderLatchDemo 成为leader了");

        TimeUnit.HOURS.sleep(1);

    }
}
