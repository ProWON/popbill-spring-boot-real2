package kr.co.linkhub.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.AccountCheckService;
import com.popbill.api.accountcheck.AccountCheckServiceImp;

import kr.co.linkhub.autoconfigure.properties.AccountCheckProperties;

@Configuration
@ConditionalOnClass(AccountCheckService.class)
@EnableConfigurationProperties(AccountCheckProperties.class)
public class AccountCheckAutoConfiguration extends CommonAutoConfiguration{
    @Autowired
    private AccountCheckProperties accountCheckProperties;

    @Lazy
    @Bean(name = "AccountCheckService")
    @ConditionalOnMissingBean
    public AccountCheckService accountCheckServiceConfig() {
        return getInstance(accountCheckProperties, AccountCheckServiceImp.class);
    }
}
