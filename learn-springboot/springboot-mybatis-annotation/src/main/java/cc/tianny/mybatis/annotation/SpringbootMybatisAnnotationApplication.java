package cc.tianny.mybatis.annotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 对 Mapper 包的扫描
@MapperScan("cc.tianny.mybatis.annotation.mapper")
public class SpringbootMybatisAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisAnnotationApplication.class, args);
    }
}
