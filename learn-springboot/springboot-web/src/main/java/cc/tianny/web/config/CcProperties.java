package cc.tianny.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/8/4
 * Time: 10:11 上午
 * Description: No Description
 */
@Component
@ConfigurationProperties(prefix="cc")
public class CcProperties {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
