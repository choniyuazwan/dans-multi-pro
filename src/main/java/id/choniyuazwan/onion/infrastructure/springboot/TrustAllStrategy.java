package id.choniyuazwan.onion.infrastructure.springboot;

import org.apache.http.ssl.TrustStrategy;
import org.springframework.context.annotation.Configuration;

import java.security.cert.X509Certificate;

@Configuration
public class TrustAllStrategy implements TrustStrategy {

    @Override
    public boolean isTrusted(final X509Certificate[] chain, final String authType) {
        return true;
    }
}