pipeline {
    agent any
    stages {
        stage('Verificar Repositório') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/bernardoironside/BernardoEmissor.git']]])
            }
        }

        stage('Instalar Dependências') {
            steps {
                script {
                    env.PATH = "/usr/bin:$PATH"
                    bat 'mvn clean install'
                }
            }
        }


        stage('Construir Imagem Docker') {
            steps {
                script {
                    def appName = 'emissor'
                    def imageTag = "${appName}:${env.BUILD_ID}"

                    // Construir a imagem Docker
                    bat "docker build -t ${imageTag} ."
                }
            }
        }

        stage('Fazer Deploy') {
            steps {
                script {
                    def appName = 'emissor'
                    def imageTag = "${appName}:${env.BUILD_ID}"

                    // Parar e remover o container existente, se houver
            		bat "docker stop ${appName} || exit 0"
            		bat "docker rm -v ${appName} || exit 0"  // Remover o container e os volumes associados

                    // Executar o novo container
                    bat "docker-compose up -d --build"
                }
            }
        }
    }
    post {
        success {
            echo 'Deploy realizado com sucesso!'
        }
        failure {
            echo 'Houve um erro durante o deploy.'
        }
    }
}
