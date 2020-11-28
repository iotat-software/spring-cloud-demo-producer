FROM java:8
MAINTAINER pang 'starry-sky-zhang@foxmail.com'
VOLUME /tmp
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone \
&& apt install wget \
&& wget 'http://iotat.cn/hosts/hosts' \
&& cat hosts >> /etc/hosts
COPY target/producer-demo-starter-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
