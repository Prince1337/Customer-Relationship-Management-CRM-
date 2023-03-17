pipeline {
    agent any
	


    stages {
        stage('Build Angular') {
            steps {
                dir('frontend/crm-project') {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }
        
        stage('Build SpringBoot') {
            steps {
                dir('backend') {
                    sh './gradlew build'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker-compose build'
            }
        }
	}
}
