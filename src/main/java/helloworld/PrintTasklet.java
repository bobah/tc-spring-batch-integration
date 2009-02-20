package helloworld;

import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.File;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author tareq.abedrabbo
 */
public class PrintTasklet implements Tasklet {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.print(message + "\n");
        System.out.println("++++++++++++++++++++++++++++++++++++++");

        File file = new File("./tc-spring-batch-output.txt");
        Writer output = new BufferedWriter(new FileWriter(file, true));
        output.append(message).append("\n").append("===================").append("\n");
        output.close();

        return RepeatStatus.FINISHED;
    }
}
