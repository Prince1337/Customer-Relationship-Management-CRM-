pipeline {
  agent any
  stages {
    stage('Build and Test Frontend') {
      parallel {
        stage('Build and Test Frontend') {
          steps {
            dir(path: 'frontend/crm-project') {
              sh 'npm run test'
            }

          }
        }

        stage('Checkout Code') {
          steps {
            git(url: 'https://github.com/Prince1337/Customer-Relationship-Management-CRM-.git', branch: 'main')
          }
        }

      }
    }

    stage('Build and Test Backend') {
      steps {
        dir(path: 'backend') {
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