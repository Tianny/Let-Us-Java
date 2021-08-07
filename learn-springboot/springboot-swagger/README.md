## Swagger2

### 创建 SwaggerConfig 配置类

- @Configuration，启动时加载此类 
- @EnableSwagger2，表示此项⽬启⽤ Swagger API ⽂档 
- .apis(RequestHandlerSelectors.basePackage("com.neo.xxx")) 指定需要扫描的包路径