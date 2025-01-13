# 进入项目根目录（包含 pom.xml 的目录）
cd 你的项目路径

# 清理并安装依赖
mvn clean install

# 运行项目
mvn spring-boot:run

# 常用的 maven 命令
# 只编译项目
mvn compile

# 运行测试
mvn test

# 打包项目（生成 jar 文件）
mvn package

# 强制更新依赖
mvn clean install -U

# 其他说明
本项目有 JPA 功能
### 1. 数据库配置在 application.yml 中
   此处配置用到的 数据库的名称、用户名、密码、场景名称。都需要您自己创建
### 2. 数据库连接地址为 jdbc:postgresql://localhost:5432/postgres?currentSchema=aww_test
   需要您创建一个数据库, 数据库名称是postgres，并新建场景名称为 aww_test
### 3. 数据库用户名和密码在 application.yml 中
   需要您创建一个用户，并设置密码
### 4. 数据库表结构在 src/main/resources/schema.sql 中
   基于 hibernate 创建表结构。会自动在 aww_test 场景下创建表结构
### 5. 数据库数据在 src/main/resources/data.sql 中
   需要您创建数据

### 可打开的页面
#### http://localhost:8080/hello 测试接口
#### http://localhost:8080/swagger-ui/#/  接口文档

#### 若提示需要输入账号密码，则输入 admin/password ，见 application.yml
