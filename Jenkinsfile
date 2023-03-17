  agent any
  stages {

    stage('Build') {
      steps {
		dir('backend') {
			sh 'chmod 755 gradlew'
			sh './gradlew clean build'
			sh './gradlew test'
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
          sh 'docker-compose -f docker-compose.yml down -v'
        }

      }
      steps {
        sh 'docker-compose -f docker-compose.yml up -d mysql'
        sh 'docker-compose -f docker-compose.yml run --rm customerrelationshipmanagementcrm ./gradlew test'
      }
    }

  }
}