package testboot.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import testboot.demo.config.IpConfiguration;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(DemoApplication.class, args);
        Environment env = application.getEnvironment();

        String ip = InetAddress.getLocalHost().getHostAddress();

        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        if (path==null || path.isEmpty()) {
            path = "";
        }

        log.info("\n----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "Local访问网址: \t\thttp://localhost:" + port + path + "\n\t" +
                "External访问网址: \thttp://" + ip + ":" + port + path + "\n\t" +
                "----------------------------------------------------------");
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        log.info("当前项目进程号：" + jvmName.split("@")[0]);

        IpConfiguration ipconfig = application.getBean(IpConfiguration.class);
        InetAddress   address = InetAddress.getLocalHost();
        System.out.println("端口号"+address.getHostAddress()+",ip:"+ipconfig.getPort());
    }

}
