package kr.co.linkhub.autoconfigure.properties;

public interface PopbillProperties {

    public String getLinkId();
    public void setLinkId(String linkID);

    public String getSecretKey();
    public void setSecretKey(String secretKey);

    public boolean isTest();
    public void setTest(boolean isTest);

    public boolean isUseStaticIp();
    public void setUseStaticIp(boolean useStaticIP);

    public boolean isUseGaIp();
    public void setUseGaIp(boolean useGAIP);

    public boolean isUseLocalTimeYn();
    public void setUseLocalTimeYn(boolean useLocalTimeYN);

    public boolean isIpRestrectOnOff();
    public void setIpRestrectOnOff(boolean isIPRestrectOnOff);
    
    public String getAuthUrl();
    public void setAutUrl(String authURL);
    
    public String getServiceUrl();
    public void setServiceUrl(String servicdURL);
    
    public String getTestServiceUrl();
    public void setTestServiceUrl(String testServiceURL);
    
    public String getProxyIp();
    public void setProxyIp(String proxyIP);
    
    public Integer getProxyPort();
    public void setProxyPort(Integer proxyPort);

}
