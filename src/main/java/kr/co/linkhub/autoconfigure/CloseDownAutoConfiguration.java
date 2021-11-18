package kr.co.linkhub.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.CloseDownService;
import com.popbill.api.closedown.CloseDownServiceImp;

import kr.co.linkhub.autoconfigure.properties.CloseDownProperties;

@Configuration
@ConditionalOnClass(CloseDownService.class)
@EnableConfigurationProperties(CloseDownProperties.class)
public class CloseDownAutoConfiguration extends CommonAutoConfiguration{
    @Autowired
    private CloseDownProperties closeDownProperties;

    @Lazy
    @Bean(name = "CloseDownService")
    @ConditionalOnMissingBean
    public CloseDownService closeDownServiceConfig() {
        return getInstance(closeDownProperties, CloseDownServiceImp.class);
    }
}
