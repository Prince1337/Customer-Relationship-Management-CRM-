pipeline {
    agent any
	
	tools {
        // Definiere die Node.js-Version, die auf dem Jenkins-Server installiert werden soll
        nodejs 'node'
		// Define the JDK version to be used for building the application
        // Define the Gradle version to be used for building the application
    }

    stages {
	
		stage('Install Gradle') {
            steps {
                sh 'wget https://services.gradle.org/distributions/gradle-6.7.1-bin.zip'
                sh 'unzip -d /opt gradle-6.7.1-bin.zip'
            }
        }
       
        stage('Build SpringBoot') {
            steps {
				dir('backend') {
					echo 'executing gradle ...'
					sh 'chmod +x gradlew'
					sh 'which gradle'
					sh 'gradle init'
					sh 'gradle wrapper'
					sh './gradlew -v'
					sh './gradlew build'
				}
            }
        }
		
		stage('Test SpringBoot') {
            steps {
                dir('backend') {
					sh 'chmod +x gradlew'
					sh './gradlew tasks'
                    sh './gradlew test'
                }
            }
        }
		
		stage('Build Angular') {
            steps {
                dir('frontend/crm-project') {
                    sh 'npm install'
                    sh 'npm run build'
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
