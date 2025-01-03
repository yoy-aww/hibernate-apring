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