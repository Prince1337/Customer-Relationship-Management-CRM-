pipeline {
  agent any
  stages {
    
	stage('Checkout Code') {
          steps {
            git(url: 'https://github.com/Prince1337/Customer-Relationship-Management-CRM-.git', branch: 'main')
          }
        }
		
	stage('Install Node.js and npm') {
		  steps {
			sh 'curl -sL https://deb.nodesource.com/setup_14.x | sudo -E bash -'
			sh 'sudo apt-get install -y nodejs'
		  }
		}

    stage('Build') {
            steps {
                sh "./gradlew clean build"
                sh "docker-compose -f build"
            }
    }
        
	stage('Test on Development Environment') {
		environment {
			DB_HOST = "db-dev"
			DB_NAME = "mysql"
		}
		steps {
			sh "docker-compose -f docker-compose.yml up -d mysql"
			sh "docker-compose -f docker-compose.yml run --rm customerrelationshipmanagementcrm ./gradlew test"
		}
		post {
			always {
				sh "docker-compose -f docker-compose.yml down -v"
			}
		}
	}

  }
}