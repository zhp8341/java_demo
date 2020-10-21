package zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-04-17
 * @time 16:52
 */
public class LeaderSelectorDemo {


    public static void main(String[] args) throws Exception {
        CuratorClient2 curatorClient2=new CuratorClient2();

        CuratorFramework client=curatorClient2.getClient();
        final  String node_name_leader = "/zk-sync-test/leader";

        LeaderSelector leaderSelector = new LeaderSelector(client, node_name_leader, new LeaderSelectorListenerAdapter() {

            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {
                System.out.println("成为leader了");
                Thread.sleep(1000*20);  //sleep 10秒
                //注意当takeLeadership方法返回之后，相当于放弃成为leader了
                System.out.println("放弃成为leader");
            }

        });

        //leaderSelector.autoRequeue();
        leaderSelector.start();

        TimeUnit.HOURS.sleep(1);
    }
}
