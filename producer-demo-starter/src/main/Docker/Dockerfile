FROM java:8
MAINTAINER pang 'starry-sky-zhang@foxmail.com'
VOLUME /tmp
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone \
&& echo '172.17.0.1	iotat.cn' >>/etc/hosts \
&& echo '172.17.0.1	www.iotat.cn' >>/etc/hosts \
&& echo '172.17.0.1	db.iotat.cn' >>/etc/hosts \
&& echo '172.17.0.1	jenkins.iotat.cn' >>/etc/hosts \
&& echo '172.17.0.1	api.iotat.cn' >>/etc/hosts \
&& echo '172.17.0.1	nacos.iotat.cn' >>/etc/hosts \
&& echo '172.17.0.1 zipkin.iotat.cn' >>/etc/hosts
COPY target/producer-demo-starter-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
