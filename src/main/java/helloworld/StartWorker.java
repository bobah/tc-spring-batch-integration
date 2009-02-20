package helloworld;

import org.terracotta.executor.DistributedWorkerService;

/**
 * Created by vkatson
 * Date: 19.02.2009
 * Time: 14:46:50
 */
public class StartWorker {
    public static void main(String[] args) throws Exception {
        DistributedWorkerService worker = new DistributedWorkerService("myTopology");
        worker.start();
    }
}
