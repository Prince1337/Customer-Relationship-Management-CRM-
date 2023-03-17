pipeline {
    agent any
	
	tools {
        // Definiere die Node.js-Version, die auf dem Jenkins-Server installiert werden soll
        nodejs 'node'
        // Define the Gradle version to be used for building the application
        gradle 'Gradle'
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
					sh 'chmod +x gradlew'
                    sh './gradlew clean build'
                }
            }
        }
        
        stage('Test SpringBoot') {
            steps {
                dir('backend') {
					sh 'chmod +x gradlew'
                    sh './gradlew test'
                }
            }
        }

        stage('Package SpringBoot') {
            steps {
                dir('backend') {
					sh 'chmod +x gradlew'
                    sh './gradlew bootJar'
                }
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
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
