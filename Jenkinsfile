pipeline {
    agent any

     environment {
        GIT_URL = "https://github.com/Jin-Tae/soul.git"
    }

    stages {
        stage('pull') {
            steps {
                git url: "$GIT_URL", branch: "main", poll: true, changelog: true
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