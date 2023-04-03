pipeline {
    agent any

     environment {
        GIT_URL = "https://github.com/Jin-Tae/soul.git"
        repository = "monta010/sping"  //docker hub id와 repository 이름
        DOCKERHUB_CREDENTIALS = credentials('dockerhub') // jenkins에 등록해 놓은 docker hub credentials 이름
        // dockerImage = '' 
    }

    stages {
        stage('Gralde_Clean_Build') {
            steps {
                sh './gradlew clean build -x test'
            }
            post{
                success{
                    echo "Gradle Success!!"
                }
                failure{
                    echo "Gradle failed"
                }
            }
        } 
        stage('Docker_build') {
            steps {
                sh 'docker build -t monta010@sping .''
            }
        }
        stage('Docker_Login') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin' // docker hub 로그인
            }
        }
        stage('Docker_Hub_Image_Push'){
            steps{
                sh 'docker push $repository:$BUILD_NUMBER' //docker push
            }
        }
    }
}