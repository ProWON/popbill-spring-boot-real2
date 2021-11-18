package kr.co.linkhub.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.CashbillService;
import com.popbill.api.cashbill.CashbillServiceImp;

import kr.co.linkhub.autoconfigure.properties.CashbillProperties;

@Configuration
@ConditionalOnClass(CashbillService.class)
@EnableConfigurationProperties(CashbillProperties.class)
public class CashbillAutoConfiguration extends CommonAutoConfiguration{
    @Autowired
    private CashbillProperties cashbillProperties;

    @Lazy
    @Bean(name = "CashbillService")
    @ConditionalOnMissingBean
    public CashbillService cashbillServiceConfig() {
        return getInstance(cashbillProperties, CashbillServiceImp.class);
    }
}
