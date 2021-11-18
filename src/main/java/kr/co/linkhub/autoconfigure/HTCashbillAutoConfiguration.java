package kr.co.linkhub.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.HTCashbillService;
import com.popbill.api.hometax.HTCashbillServiceImp;

import kr.co.linkhub.autoconfigure.properties.HTCashbillProperties;

@Configuration
@ConditionalOnClass(HTCashbillService.class)
@EnableConfigurationProperties(HTCashbillProperties.class)
public class HTCashbillAutoConfiguration extends CommonAutoConfiguration{
    @Autowired
    private HTCashbillProperties htCashbillProperties;

    @Lazy
    @Bean(name = "HTCashbillService")
    @ConditionalOnMissingBean
    public HTCashbillService htCashbillServiceConfig() {
        return getInstance(htCashbillProperties, HTCashbillServiceImp.class);
    }
}
