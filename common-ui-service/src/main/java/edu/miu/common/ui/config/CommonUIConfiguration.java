package edu.miu.common.ui.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix="ui")
@PropertySource(value = "${app.ui-profile}", factory = YamlPropertySourceFactory.class)
public class CommonUIConfiguration {

    private Map<String, String> urls;

    private List<String> camelCaseList;

    private List<NavbarItem> navbarItems;

    @Data
    public static class NavbarItem  {

        private String title;

        private String url;

        private List<NavbarItem> subItems;

    }

}