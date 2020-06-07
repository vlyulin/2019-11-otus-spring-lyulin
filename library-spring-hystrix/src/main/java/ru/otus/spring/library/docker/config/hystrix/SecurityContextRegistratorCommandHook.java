package ru.otus.spring.library.docker.config.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextRegistratorCommandHook extends HystrixCommandExecutionHook {

    @Override
    public <T> void onRunStart(HystrixCommand<T> commandInstance) {
        SecurityContextHolder.setContext(SecurityContextHystrixRequestVariable.getInstance().get());
    }

    /**
     * Clean the SecurityContext
     */
    @Override
    public <T> T onComplete(HystrixCommand<T> commandInstance, T response) {
        SecurityContextHolder.setContext(null);

        return response;
    }

    /**
     * Clean the SecurityContext
     */
    @Override
    public <T> Exception onError(HystrixCommand<T> commandInstance, HystrixRuntimeException.FailureType failureType, Exception e) {
        SecurityContextHolder.setContext(null);

        return e;
    }

}
