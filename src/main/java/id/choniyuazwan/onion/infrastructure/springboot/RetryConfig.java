package id.choniyuazwan.onion.infrastructure.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.ResourceAccessException;

import java.io.IOException;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableRetry
public class RetryConfig {
    @Value("${retry.maxDelay}")
    private long maxDelay;

    @Value("${retry.maxAttempts}")
    private int maxAttempts;
    
    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(maxDelay);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        Map<Class<? extends Throwable>, Boolean> retryAbleExceptions = new HashMap<>();
        retryAbleExceptions.put(ConnectException.class, Boolean.TRUE);
        retryAbleExceptions.put(IOException.class, Boolean.TRUE);
        retryAbleExceptions.put(ResourceAccessException.class, Boolean.TRUE);
        
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(maxAttempts, retryAbleExceptions); 
        retryTemplate.setRetryPolicy(retryPolicy);

        retryTemplate.registerListener(new DefaultListenerSupport());
        return retryTemplate;
    }
}
