pipeline {
    agent any
	
	tools {
        // Definiere die Node.js-Version, die auf dem Jenkins-Server installiert werden soll
        nodejs 'node-14.17.0'
    }

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
