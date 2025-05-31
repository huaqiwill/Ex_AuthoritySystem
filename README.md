# 权限管理系统（Authority System）

## 项目介绍

权限管理系统是一个基于Spring Boot和Spring Security的后台权限管理框架，实现了用户认证、授权、角色管理、权限控制等功能。系统采用前后端分离架构，后端提供REST API接口，支持JWT令牌认证。

## 功能特点

- **用户管理**：用户信息的增删改查，用户状态管理
- **角色管理**：角色的创建、编辑、删除和权限分配
- **权限管理**：细粒度的权限控制，支持菜单权限和按钮权限
- **安全认证**：基于Spring Security的认证和授权
- **JWT令牌**：使用JWT实现无状态的用户认证
- **跨域支持**：配置了CORS跨域资源共享

## 技术栈

- **后端框架**：Spring Boot 2.6.6
- **安全框架**：Spring Security
- **ORM框架**：MyBatis-Plus 3.5.1
- **数据库**：MySQL
- **缓存**：Redis
- **认证**：JWT 0.9.1
- **JSON处理**：FastJSON 1.2.80
- **其他**：Lombok, Spring Boot DevTools

## 系统架构

系统采用分层架构设计：

- **控制层（Controller）**：处理HTTP请求，返回响应
- **服务层（Service）**：实现业务逻辑
- **数据访问层（DAO）**：与数据库交互
- **实体层（Entity）**：数据模型
- **配置层（Config）**：系统配置，包括安全配置、MyBatis配置等
- **工具类（Utils）**：提供通用功能

## 安装说明

### 环境要求

- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+
- Redis

### 安装步骤

1. 克隆项目到本地

```bash
git clone [项目地址]
cd authority-system
```

2. 创建数据库

```sql
CREATE DATABASE db_authority_system CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
```

3. 修改配置文件

编辑 `src/main/resources/application.properties` 文件，配置数据库连接信息：

```properties
spring.datasource.url=jdbc:mysql://localhost/db_authority_system?useUnicode=true&characterEncoding=UTF-8&serverTimeZone=Asia/Shanghai
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. 编译运行

```bash
mvn clean package
java -jar target/authority-system-1.0.jar
```

或者使用Maven插件运行：

```bash
mvn spring-boot:run
```

## 使用说明

### 接口说明

- 登录接口：`/api/user/login`
- 用户相关接口：`/api/user/**`
- 角色相关接口：`/api/role/**`
- 权限相关接口：`/api/permission/**`

### 认证流程

1. 用户通过登录接口获取JWT令牌
2. 将JWT令牌添加到请求头中进行后续请求
3. 服务器验证JWT令牌的有效性
4. 根据用户权限决定是否允许访问请求的资源

## 开发指南

### 添加新功能

1. 创建实体类（Entity）
2. 创建数据访问接口（Mapper）
3. 创建服务接口（Service）和实现类（ServiceImpl）
4. 创建控制器（Controller）
5. 配置权限和路由

### 权限控制

系统使用Spring Security进行权限控制，可以通过以下方式配置：

- 在Controller方法上使用`@PreAuthorize`注解
- 在Spring Security配置类中配置URL访问权限
- 通过数据库动态配置权限

## 贡献指南

欢迎贡献代码，提交问题和改进建议。请遵循以下步骤：

1. Fork项目
2. 创建特性分支 (`git checkout -b feature/your-feature`)
3. 提交更改 (`git commit -m 'Add some feature'`)
4. 推送到分支 (`git push origin feature/your-feature`)
5. 创建Pull Request
