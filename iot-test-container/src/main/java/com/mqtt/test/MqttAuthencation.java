package com.mqtt.test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.iot.container.AuthencationSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

//@Component
public class MqttAuthencation implements AuthencationSession {
    @Value("${connect.user.name:}")
    private String userName;
    @Value("${connect.user.password:}")
    private String userPassword;
    
    @Override
    public boolean auth(String username, String password)
    {
        if (userName.equals(username) && userPassword.equals(password))
        {
            return true;
        }
        return false;
    }
    
    
    public static void main(String[] args) throws InvalidProtocolBufferException
    {
        Message.register message = Message.register
                .newBuilder()
        .setAppVersion("1.0.0")
        .setChannel("im")
        .setDeviceBrand("HuaWei")
        .setDeviceCode("123321")
        .setDeviceId("ID1DSFLJSD")
        .setDeviceModel("V20")
        .setDeviceType((byte)1)
        .setIp("127.0.0.1")
        .setSystemVersion("10.12.5")
        .setRequestId("IDWAW123123")
        .setLocation("21.312323123123,25.12312323123")
        .setExtend("suibian").build();
   
        System.out.println(message.toByteArray().length);
    
        Message.register  register = Message.register.parseFrom(message.toByteArray());
        System.out.println(register.toString());
        
    
    
    }
}
