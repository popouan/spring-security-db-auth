# Spring Security DB Auth

## 项目简介
本项目是一个基于 Spring Boot、Spring Security 和 MyBatis 的实战练习，实现了基于数据库的用户认证与角色鉴权。

## 技术栈
- Spring Boot
- Spring Security
- MyBatis
- Thymeleaf
- MySQL

## 测试账号
- 管理员: `adams` / `123` (拥有 admin 和 normal 权限)
- 普通用户: `billy` / `123` (仅有 normal 权限)

## 运行方式
1. 导入数据库并执行建表 SQL。
2. 修改 `application.properties` 中的数据库连接账号密码。
3. 启动 `Application` 主类，访问 `http://localhost:8080/`。
