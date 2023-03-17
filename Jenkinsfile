pipeline {
	agent any

	stages {
		stage('Build and Test Frontend') {
		  steps {
			dir('frontend/crm-project') {
				sh 'npm install'
				sh 'npm run test'
			}
		  }
		}

		stage('Build and Test Backend') {
		  steps {
			dir('backend') {
			  sh './gradlew clean build'
			  sh './gradlew test'
			}
		  }
		}

		stage('Docker Compose') {
		  steps {
			sh 'docker-compose up --build -d'
		  }
		}

		stage('Deploy') {
		  steps {
			sh 'docker-compose down'
			sh 'docker-compose up -d'
		  }
		}
	}
}