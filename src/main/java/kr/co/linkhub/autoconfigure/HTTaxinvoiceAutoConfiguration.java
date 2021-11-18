package kr.co.linkhub.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.HTTaxinvoiceService;
import com.popbill.api.hometax.HTTaxinvoiceServiceImp;

import kr.co.linkhub.autoconfigure.properties.HTTaxinvoiceProperties;

@Configuration
@ConditionalOnClass(HTTaxinvoiceService.class)
@EnableConfigurationProperties(HTTaxinvoiceProperties.class)
public class HTTaxinvoiceAutoConfiguration extends CommonAutoConfiguration{
    @Autowired
    private HTTaxinvoiceProperties htTaxinvoiceProperties;

    @Lazy
    @Bean(name = "HTTaxinvoiceService")
    @ConditionalOnMissingBean
    public HTTaxinvoiceService htTaxinvoiceServiceConfig() {
        return getInstance(htTaxinvoiceProperties, HTTaxinvoiceServiceImp.class);
    }
}
