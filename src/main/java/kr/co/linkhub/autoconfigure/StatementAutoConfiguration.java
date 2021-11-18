package kr.co.linkhub.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.StatementService;
import com.popbill.api.statement.StatementServiceImp;

import kr.co.linkhub.autoconfigure.properties.StatementProperties;

@Configuration
@ConditionalOnClass(StatementService.class)
@EnableConfigurationProperties(StatementProperties.class)
public class StatementAutoConfiguration extends CommonAutoConfiguration{
    @Autowired
    private StatementProperties statementProperties;

    @Lazy
    @Bean(name = "StatementService")
    @ConditionalOnMissingBean
    public StatementService statementServiceConfig() {
        return getInstance(statementProperties, StatementServiceImp.class);
    }
    
}
