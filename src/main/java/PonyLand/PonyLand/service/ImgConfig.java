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
                .addResourceLocations("file:///C:\\Users\\이진혁\\AppData\\Local\\Temp\\tomcat-docbase.80.13049837589883602549\\load/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }
}