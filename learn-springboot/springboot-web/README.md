## springboot-web

springboot 对 web 开发常见功能介绍。

### JSON 支持

- @RestController
- 不管返回的是对象还是对象嵌套集合，均可自动转换为 JSON

### 请求传参

- 直接接收对象，只要是 User 属性将会自动填充。@RequestMapping(name="/getUser", method= RequestMethod.POST)
- 使用 URL 传参，方法参数中使用注解 @PathVariable。 @RequestMapping(value="get/{name}", method=RequestMethod.GET)

### 数据校验

SpringBoot 的参数校验依赖于 hibernate-validator 来进⾏。

使⽤ Hibernate Validator 校验数据，需要定义⼀ 个接收的数据模型，使⽤注解的形式描述字段校验的规则。

- @Valid 参数前⾯添加 @Valid 注解，代表此对象使⽤了参数校验； 
- BindingResult 参数校验的结果会存储在此对象中，可以根据属性判断是否校验通过，校验不通过可以将 错误信息打印出来。

### 自定义 filter

推荐使用 FilterRegistrationBean，支持自定义过滤器的优先级。

⾃定义 Filter 两个步骤：

- 实现 Filter 接⼝，实现其中的 doFilter() ⽅法 
- 添加 @Configuration 注解，将⾃定义 Filter 加⼊过滤链

### 配置文件

application.yml 和 application.properties。

#### 读取单个配置项

- 使⽤ @Value 属性。@Value("${neo.title}")

#### 读取多个配置

通常会定义⼀个对象来 接收多个配置项，⽅便在项⽬中使⽤。

- @Component 的定义为实例，⽅便在 Spring Boot 项⽬中引⽤；
- @ConfigurationProperties(prefix="neo")。以 neo 开头的属性会⾃动赋值到对象的属性中。

#### 自定义配置文件

在 resources ⽬录下创建⼀个 other.properties ⽂件。

- @Component
- @ConfigurationProperties(prefix="other")
- @PropertySource("classpath:other.properties")