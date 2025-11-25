// Docker workflow with per-stage agents, aligned to CloudBees/Jenkins docs.
pipeline {
  agent none

  options {
    timestamps()
    skipStagesAfterUnstable()
  }

  environment {
    AWS_REGION    = 'us-east-1'
    IMAGE_NAME    = 'banco-api'
    // Configure no job/folder:
    // ECR_REGISTRY=123456789012.dkr.ecr.us-east-1.amazonaws.com
    // ECR_CREDENTIAL=ecr:us-east-1:aws-credentials
  }

  stages {
    stage('Unit Tests') {
      agent {
        docker {
          image 'maven:3.9.11-eclipse-temurin-21-alpine'
          args '-v $HOME/.m2:/root/.m2' // cache do Maven
        }
      }
      steps {
        sh 'mvn -B clean verify'
      }
      post {
        always { junit 'target/surefire-reports/*.xml' }
      }
    }

    stage('Build image') {
      agent {
        docker { image 'docker:27-cli' }
      }
      steps {
        script {
          sh 'docker version'
          def imageTag = env.GIT_TAG ?: env.BUILD_NUMBER
          sh "docker build -t ${IMAGE_NAME}:${imageTag} ."
          env.BUILT_IMAGE_TAG = imageTag
        }
      }
    }

    stage('Push to ECR') {
      when { buildingTag() } // só publica builds disparados por tag
      agent {
        docker { image 'docker:27-cli' }
      }
      steps {
        script {
          def tag = env.BUILT_IMAGE_TAG ?: (env.GIT_TAG ?: env.BUILD_NUMBER)
          if (!env.ECR_REGISTRY || !env.ECR_CREDENTIAL) {
            error "Defina ECR_REGISTRY e ECR_CREDENTIAL (ecr:<region>:<credId>) nas variáveis do job."
          }
          docker.withRegistry("https://${env.ECR_REGISTRY}", env.ECR_CREDENTIAL) {
            sh "docker tag ${IMAGE_NAME}:${tag} ${ECR_REGISTRY}/${IMAGE_NAME}:${tag}"
            sh "docker push ${ECR_REGISTRY}/${IMAGE_NAME}:${tag}"
            // Descomente se quiser também 'latest':
            // sh "docker tag ${IMAGE_NAME}:${tag} ${ECR_REGISTRY}/${IMAGE_NAME}:latest"
            // sh "docker push ${ECR_REGISTRY}/${IMAGE_NAME}:latest"
          }
        }
      }
    }
  }
}
