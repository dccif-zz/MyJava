package top.dccif.Merge;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsynTaskService {

    @Async
    public void executeAsynsTask(Integer i) {
        System.out.println("executeAsynsTask: " + i);
    }

}
