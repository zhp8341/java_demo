package zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-04-15
 * @time 15:28
 */
public class RegisterWatcher implements Watcher {

    final static String znode = "/zk-sync-test";


    @Override
    public void process(WatchedEvent event) {
        try {
            System.out.println("ZNode event " + event.toString());
            if (event.getType().equals(Watcher.Event.EventType.NodeDeleted)) {
                System.out.println("ZNode " + znode + " is deleted");
            }
        }
        catch(Exception ie) {
            ie.printStackTrace();
        }

    }
}
