package kr.co.linkhub.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.KakaoService;
import com.popbill.api.kakao.KakaoServiceImp;

import kr.co.linkhub.autoconfigure.properties.KakaoProperties;

@Configuration
@ConditionalOnClass(KakaoService.class)
@EnableConfigurationProperties(KakaoProperties.class)
public class KakaoAutoConfiguration extends CommonAutoConfiguration{
    @Autowired
    private KakaoProperties kakaoProperties;

    @Lazy
    @Bean(name = "KakaoService")
    @ConditionalOnMissingBean
    public KakaoService kakaoServiceConfig() {
        return getInstance(kakaoProperties, KakaoServiceImp.class);
    }
}
