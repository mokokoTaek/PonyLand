package PonyLand.PonyLand.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class ImgConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:///C:\\Users\\Administrator\\AppData\\Local\\Temp\\2\\tomcat-docbase.80.583775722719295962\\load/")
                                     //경로지정.
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }
}

