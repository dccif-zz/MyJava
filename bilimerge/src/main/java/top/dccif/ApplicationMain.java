package top.dccif;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.CommandLinePropertySource;
import top.dccif.Merge.AsynTaskService;
import top.dccif.config.TaskExectorConfig;

public class ApplicationMain {

    public static void main(String[] args) {
        CommandLinePropertySource clps = null;

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TaskExectorConfig.class);
        AsynTaskService asynTaskService = ctx.getBean(AsynTaskService.class);
        ctx.getEnvironment().getPropertySources().addFirst(clps);


        for (int i = 0; i < 10; ++i) {
            asynTaskService.executeAsynsTask(i);
        }
        ctx.close();
    }

}
