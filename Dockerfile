FROM openjdk:8-jdk

ARG JAR_FILE=mall.jar
USER root
# 设置时区 安装ps命令
ENV TZ=Asia/Shanghai
RUN set -eux; \
    ln -snf /usr/share/zoneinfo/$TZ /etc/localtime; \
    echo $TZ > /etc/timezone; \
    apt-get update && apt-get install -y procps && apt-get install -y maven
# 新建应用目录
ARG HOME=/data/mall
RUN mkdir -p ${HOME}/{config,log,bin,h2db,file,code};ls -la ${HOME}
# build jar
ADD ./ $HOME/code/
WORKDIR $HOME/code
RUN set -eux;ls -la;mvn clean install -DskipTests && cp $HOME/code/target/$JAR_FILE $HOME

# 启动脚本
ADD ./file/* $HOME/file/
ADD ./h2db/* $HOME/h2db/
ADD ./boot.sh $HOME/bin/
WORKDIR $HOME/bin
ENTRYPOINT sh boot.sh start

# 端口
EXPOSE 8081