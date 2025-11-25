pipeline {
  agent any

  options {
    timestamps()
    skipStagesAfterUnstable()
  }

  environment {
    AWS_REGION   = 'us-east-1'      // ajuste se precisar
    IMAGE_NAME   = 'banco-api'
    // Configure no job/folder:
    // ECR_REGISTRY=123456789012.dkr.ecr.us-east-1.amazonaws.com
    // Credencial: ecr:<region>:<credentialsId> (ex.: ecr:us-east-1:aws-credentials)
  }

  stages {
    stage('Clone repository') {
      steps {
        checkout scm
      }
    }

    stage('Unit Tests') {
      steps {
        script {
          docker.image('maven:3.9-eclipse-temurin-17').inside {
            sh 'mvn -B clean verify'
          }
        }
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('Build image') {
      steps {
        script {
          def imageTag = env.GIT_TAG ?: env.BUILD_NUMBER
          app = docker.build("${IMAGE_NAME}:${imageTag}")
        }
      }
    }

    stage('Deploy (push to ECR)') {
      when { buildingTag() } // só publica se for build de tag
      steps {
        script {
          def tag = env.GIT_TAG ?: env.BUILD_NUMBER
          if (!env.ECR_REGISTRY) {
            error "Defina ECR_REGISTRY (ex.: 123456789012.dkr.ecr.us-east-1.amazonaws.com) nas variáveis do job."
          }
          docker.withRegistry("https://${env.ECR_REGISTRY}", "ecr:${AWS_REGION}:aws-credentials") {
            app.push(tag)
          }
        }
      }
    }
  }
}
