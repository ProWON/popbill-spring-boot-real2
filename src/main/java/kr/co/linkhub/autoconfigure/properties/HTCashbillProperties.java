package kr.co.linkhub.autoconfigure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "popbill.htcashbillservice")
public class HTCashbillProperties implements PopbillProperties{
    private String LinkID;
    private String SecretKey;
    private boolean isTest;
    private boolean useStaticIP;
    private boolean useGAIP;
    private boolean useLocalTimeYN;
    private boolean isIPRestrectOnOff;
    
    private String AuthURL;
    private String ServiceURL;
    private String TestServiceURL;
    
    private String ProxyIP;
    private Integer ProxyPort;

    HTCashbillProperties() {
        useStaticIP = false;
        useGAIP = false;
        useLocalTimeYN = true;
        isIPRestrectOnOff = true;
        
        AuthURL = null;
        ServiceURL = null;
        TestServiceURL = null;
        
        ProxyIP = null;
        ProxyPort = null;
    }

    @Override
    public String getLinkId() {
        return LinkID;
    }
    @Override
    public void setLinkId(String linkID) {
        LinkID = linkID;
    }

    @Override
    public String getSecretKey() {
        return SecretKey;
    }
    @Override
    public void setSecretKey(String secretKey) {
        SecretKey = secretKey;
    }

    @Override
    public boolean isTest() {
        return isTest;
    }
    @Override
    public void setTest(boolean isTest) {
        this.isTest = isTest;
    }

    @Override
    public boolean isUseStaticIp() {
        return useStaticIP;
    }
    @Override
    public void setUseStaticIp(boolean useStaticIP) {
        this.useStaticIP = useStaticIP;
    }

    @Override
    public boolean isUseGaIp() {
        return useGAIP;
    }
    @Override
    public void setUseGaIp(boolean useGAIP) {
        this.useGAIP = useGAIP;
    }

    @Override
    public boolean isUseLocalTimeYn() {
        return useLocalTimeYN;
    }
    @Override
    public void setUseLocalTimeYn(boolean useLocalTimeYN) {
        this.useLocalTimeYN = useLocalTimeYN;
    }

    @Override
    public boolean isIpRestrectOnOff() {
        return isIPRestrectOnOff;
    }
    @Override
    public void setIpRestrectOnOff(boolean isIPRestrectOnOff) {
        this.isIPRestrectOnOff = isIPRestrectOnOff;
    }

    @Override
    public String getAuthUrl() {
        return AuthURL;
    }
    @Override
    public void setAutUrl(String authURL) {
        AuthURL = authURL;
    }

    @Override
    public String getServiceUrl() {
        return ServiceURL;
    }
    @Override
    public void setServiceUrl(String serviceURL) {
        ServiceURL = serviceURL;
    }

    @Override
    public String getTestServiceUrl() {
        return TestServiceURL;
    }
    @Override
    public void setTestServiceUrl(String testServiceURL) {
        TestServiceURL = testServiceURL;
    }

    @Override
    public String getProxyIp() {
        return ProxyIP;
    }
    @Override
    public void setProxyIp(String proxyIP) {
        ProxyIP = proxyIP;
    }

    @Override
    public Integer getProxyPort() {
        return ProxyPort;
    }
    @Override
    public void setProxyPort(Integer proxyPort) {
        ProxyPort = proxyPort;
    }

}
