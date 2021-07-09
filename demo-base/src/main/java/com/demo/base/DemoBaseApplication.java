package com.demo.base;

import com.demo.base.config.IpConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;


@Slf4j
@SpringBootApplication
public class DemoBaseApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(DemoBaseApplication.class, args);
        Environment env = application.getEnvironment();

        String ip = InetAddress.getLocalHost().getHostAddress();

        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        if (path==null || path.isEmpty()) {
            path = "";
        }
        //if (port==null || port.isEmpty()) {
        //    log.info("can't not get port, so we set it as 8080");
        //    port = "8080";
        //}
        log.info("\n----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "Local访问网址: \t\thttp://localhost:" + port + path + "\n\t" +
                "External访问网址: \thttp://" + ip + ":" + port + path + "\n\t" +
                "----------------------------------------------------------");
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        log.info("当前项目进程号：" + jvmName.split("@")[0]);
    }

}
