package cc.tianny.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/8/4
 * Time: 10:12 上午
 * Description: No Description
 */
@Component
@ConfigurationProperties(prefix="other")
@PropertySource(value = "classpath:other.properties")
public class OtherProperties {
    private String title;
    private String blog;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
