pipeline {
    agent any

     environment {
        GIT_URL = "https://github.com/Jin-Tae/soul.git"
    }

    stages {
        stage('gradle') {
            steps {
                git 'gradle clean build -x test'
            }
        }
        stage('build') {
           steps {
                sh 'docker build -t soulbrain ./'
           }
        }
        stage('Deploy') {
           steps {
                sh 'docker run -d -p 8080:8080 --name soulbrain soulbrain'
           }
       }
   }
}