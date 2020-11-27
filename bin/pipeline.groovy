pipeline {
    agent any
    stages {
        stage('停止正在运行的容器') {
            steps {
                echo "停止正在运行的容器..."
                sh 'docker ps -f name=config-center -q | xargs --no-run-if-empty docker container stop'
                sh 'docker ps -a -f name=config-center -q | xargs --no-run-if-empty docker container rm'
            }
        }
        stage('拉取代码') {
            steps {
                echo '拉取代码...'
                // Get some code from a GitHub repository
                git url: 'https://github.com/iotat-software/spring-cloud-demo-producer.git', branch: 'main'

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('构建jar包') {
            steps {
                echo "开始构建jar包..."
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.skip=true clean package"
            }
        }
        stage('打包Docker镜像') {
            steps {
                echo "打包Docker镜像..."
                sh "cd producer-demo-starter/src/main/Docker && docker build -t iotat/producer-demo -f ./Dockerfile ../../../"
            }
        }
        stage('启动Docker镜像') {
            steps {
                echo "docker image start..."
                sh "docker run -d -p 18080:18080 -v /home/iotat/logs:/logs/ --restart=always --name producer-demo iotat/producer-demo "
            }
        }
    }
}
