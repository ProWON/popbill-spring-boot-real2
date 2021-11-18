package kr.co.linkhub.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.EasyFinBankService;
import com.popbill.api.easyfin.EasyFinBankServiceImp;

import kr.co.linkhub.autoconfigure.properties.EasyFinBankProperties;

@Configuration
@ConditionalOnClass(EasyFinBankService.class)
@EnableConfigurationProperties(EasyFinBankProperties.class)
public class EasyFinBankAutoConfiguration extends CommonAutoConfiguration{
    @Autowired
    private EasyFinBankProperties easyFinBankProperties;

    @Lazy
    @Bean(name = "EasyFinBankService")
    @ConditionalOnMissingBean
    public EasyFinBankService easyFinBankServiceConfig() {
        return getInstance(easyFinBankProperties, EasyFinBankServiceImp.class);
    }
}
