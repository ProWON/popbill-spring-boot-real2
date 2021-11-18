package kr.co.linkhub.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.FaxService;
import com.popbill.api.fax.FaxServiceImp;

import kr.co.linkhub.autoconfigure.properties.FaxProperties;

@Configuration
@ConditionalOnClass(FaxService.class)
@EnableConfigurationProperties(FaxProperties.class)
public class FaxAutoConfiguration extends CommonAutoConfiguration{
    @Autowired
    private FaxProperties faxProperties;

    @Lazy
    @Bean(name = "FaxService")
    @ConditionalOnMissingBean
    public FaxService faxServiceConfig() {
        return getInstance(faxProperties, FaxServiceImp.class);
    }
}
