package helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.launch.JobLauncher;
import org.terracotta.executor.DistributedWorkerService;
import org.terracotta.executor.DistributedExecutorService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * Created by vkatson
 * Date: 19.02.2009
 * Time: 12:03:26
 */
public class Scheduler {

    public static void main(String[] args)
            throws
            Exception,
            JobExecutionAlreadyRunningException, JobInstanceAlreadyCompleteException {

//        Thread.sleep(10000L);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("simpleJob.xml");

        Job printJob = (Job) ctx.getBean("printJob");
        JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");

        Map<String, JobParameter> jobParameterMap = new HashMap<String, JobParameter>();
        jobParameterMap.put("printJob", new JobParameter("preved"));

//        startWorkers();

/*
        ExecutorService executor = new SpringCompatibleDistributedExecutorService("myTopology");
        for (int i = 0; i < 10; ++i) {
            executor.submit(new Runnable() {
                public void run() {
                    System.out.println("PREVED");
                }
            });
        }
*/
        jobLauncher.run(printJob, new JobParameters(jobParameterMap));
    }

    public static void startWorkers() throws Exception {
        DistributedWorkerService worker1 = new DistributedWorkerService("myTopology");
        worker1.start();
    }

}
