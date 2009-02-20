package helloworld;

import org.terracotta.executor.DistributedExecutorService;
import org.terracotta.message.routing.Router;
import org.terracotta.message.topology.Topology;
import org.springframework.core.task.TaskExecutor;

/**
 * Created by vkatson
 * Date: 19.02.2009
 * Time: 14:37:35
 */
public class SpringCompatibleDistributedExecutorService
        extends DistributedExecutorService
        implements TaskExecutor {

    public SpringCompatibleDistributedExecutorService(String topologyName) {
        super(topologyName);
    }

    public SpringCompatibleDistributedExecutorService(String topologyName, Router router, String... routingIDs) {
        super(topologyName, router, routingIDs);
    }

    public SpringCompatibleDistributedExecutorService(String topologyName, Topology.Factory topologyFactory, Router router, String... routingIDs) {
        super(topologyName, topologyFactory, router, routingIDs);
    }
}

