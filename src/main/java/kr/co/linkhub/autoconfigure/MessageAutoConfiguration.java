package kr.co.linkhub.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.MessageService;
import com.popbill.api.message.MessageServiceImp;

import kr.co.linkhub.autoconfigure.properties.MessageProperties;

@Configuration
@ConditionalOnClass(MessageService.class)
@EnableConfigurationProperties(MessageProperties.class)
public class MessageAutoConfiguration extends CommonAutoConfiguration{
    @Autowired
    private MessageProperties messageProperties;

    @Lazy
    @Bean(name = "MessageeService")
    @ConditionalOnMissingBean
    public MessageService messageServiceConfig() {
        return getInstance(messageProperties, MessageServiceImp.class);
    }
}
