package com.automation.property;

import com.automation.SpringBaseTestNGTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testng.annotations.Test;

import javax.annotation.PropertyKey;
import java.io.IOException;
import java.util.Properties;



//@ExtendWith(SpringExtension.class)
//@TestPropertySource(locations = "classpath:data1.properties")


@EnableAutoConfiguration
@PropertySource(ignoreResourceNotFound = true, value = "classpath:data1.properties")

public class Props extends SpringBaseTestNGTest {

    @Value("${name}")
    private String password;
/*
    @Value("${name}")
    private String name;*/

    @Test
    public void propTest() throws IOException {

         System.out.println(password);
    }
}
