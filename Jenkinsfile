pipeline {
  agent any
  stages {
    
	stage('Checkout Code') {
          steps {
            git(url: 'https://github.com/Prince1337/Customer-Relationship-Management-CRM-.git', branch: 'main')
          }
        }

    stage('Build') {
            steps {
                sh "./gradlew clean build"
                sh "docker-compose -f docker-compose.dev.yml build"
            }
    }
        
	stage('Test on Development Environment') {
		environment {
			DB_HOST = "db-dev"
			DB_NAME = "my-app-dev-db"
		}
		steps {
			sh "docker-compose -f docker-compose.yml up -d mysql"
			sh "docker-compose -f docker-compose.yml run --rm customerrelationshipmanagementcrm ./gradlew test"
		}
		post {
			always {
				sh "docker-compose -f docker-compose.dev.yml down -v"
			}
		}
	}

  }
}