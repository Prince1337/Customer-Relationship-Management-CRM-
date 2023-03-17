pipeline {
  agent any
  stages {

    stage('Build') {
      steps {
		dir('backend') {
			sh 'sudo chmod +x gradlew'
			sh './gradlew --no-daemon clean build'
			sh './gradlew --no-daemon test'
		}
      }
    }

    stage('Test on Development Environment') {
      environment {
        DB_HOST = 'db-dev'
        DB_NAME = 'mysql'
      }
      post {
        always {
          sh 'docker-compose -f docker-compose.yml down --remove-orphans'
        }
      }
      steps {
        sh 'docker-compose -f docker-compose.yml up -d mysql'
        sh 'docker-compose -f docker-compose.yml run --rm customerrelationshipmanagementcrm ./gradlew --no-daemon test'
      }
    }

  }
}
