//package top.dccif.config;
//
//import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.AsyncConfigurer;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.Executor;
//
//@Configuration
//@ComponentScan("top.dccif")
//@EnableAsync
//public class TaskExectorConfig implements AsyncConfigurer {
//    @Override
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskExecutor tastExecutor = new ThreadPoolTaskExecutor();
//        tastExecutor.setCorePoolSize(10);
//        tastExecutor.setMaxPoolSize(20);
//        tastExecutor.setQueueCapacity(500);
//        tastExecutor.initialize();
//        return tastExecutor;
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        return null;
//    }
//}
