package cc.tianny.web;

import cc.tianny.web.config.CcProperties;
import cc.tianny.web.config.OtherProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Tianny
 * Date: 2021/8/4
 * Time: 10:14 上午
 * Description: No Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Value("${cc.title}")
    private String title;
    @Resource
    private CcProperties properties;
    @Resource
    private OtherProperties otherProperties;

    @Test
    public void testSingle() {
        System.out.println("title:" + properties.getTitle());
        Assert.assertEquals(title, "title");
    }

    @Test
    public void testMore() throws Exception {
        System.out.println("title:" + properties.getTitle());
        System.out.println("description:" + properties.getDescription());
    }

    @Test
    public void testOther() throws Exception {
        System.out.println("title:" + otherProperties.getTitle());
        System.out.println("blog:" + otherProperties.getBlog());
    }

}

