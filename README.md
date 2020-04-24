# oh-spring-cloud-demo
spring-cloud 整体微服务demo

基础组件包含：服务注册与发现、服务消费、负载均衡、熔断器、智能路由、配置管理


# 统一依赖管理(spring-cloud-dependencies)
# 服务注册与发现(spring-cloud-eureka)
# 服务提供(spring-cloud-service-provider)
# 服务消费(spring-cloud-service-consumer-fegin)
# 熔断监控(spring-cloud-hystrix)
# 熔断监控可视化

1. 添加入口类@EnableHystrixDashboard 注解
2. 添加依赖
```$xslt
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
```
3. 添加配置类HystrixDashboardConfiguration

4. web地址 http://localhost:8765/hystrix
![image](docs/images/hystrix_dashboard.png)

# 路由网关统一访问

zuul提供路由转发和请求过滤

## 请求过滤

filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
pre：可以在请求被路由之前调用
route：在路由请求时候被调用
post：在route和error过滤器之后被调用
error：处理请求时发生错误时被调用

filterOrder：通过int值来定义过滤器的执行顺序

shouldFilter：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效

run：过滤器的具体逻辑。在该函数中，我们可以实现自定义的过滤逻辑，来确定是否要拦截当前的请求，不对其进行后续的路由，或是在请求路由返回结果之后，对处理结果做一些加工等。

# 分布式配置中心
## 服务端（spring-cloud-config）

```$xslt
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```

{application} 就是应用名称，对应到配置文件上来，就是配置文件的名称部分，例如我上面创建的配置文件。

{profile} 就是配置文件的版本，我们的项目有开发版本、测试环境版本、生产环境版本，对应到配置文件上来就是以 application-{profile}.yml 加以区分，例如application-dev.yml、application-sit.yml、application-prod.yml。

{label} 表示 git 分支，默认是 master 分支，如果项目是以分支做区分也是可以的，那就可以通过不同的 label 来控制访问不同的配置文件了。

上面的 5 条规则中，我们只看前三条，因为我这里的配置文件都是 yml 格式的。根据这三条规则，我们可以通过以下地址查看配置文件内容:

**注意配置文件命名格式:**
{application}-{profile}.yml
例如：fegin-dev.yml



环境

    1. 开发环境 dev
    2. 测试环境 test
    3. 生产环境 prod

启动项目添加参数  --spring.profiles.active=prod

## 客户端

1. 添加依赖

```$xslt
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

2. 添加配置


# 服务链路追踪(spring-cloud-zipkin)
## 服务端
可使用docker 搭建服务端
```$xslt
docker run -d -p 9411:9411 openzipkin/zipkin
```

## 客户端

1. 添加依赖

```$xslt
<!--链路追踪-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```
2. 配置
```$xslt
spring:
  zipkin:
    base-url: http://192.168.137.101:9411
```


# 服务监控(spring-cloud-service-admin)


