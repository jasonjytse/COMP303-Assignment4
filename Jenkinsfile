pipeline {
    agent any

    tools {
        maven "maven"
        git "git"
    }
    environment { 
        GITHUB_PAT = credentials('GitHub_PAT')
        GITHUB_URL = "https://${GITHUB_PAT}@github.com/jasonjytse/COMP303-Assignment4.git"
        DEPLOYMENT_ENV = 'development'
    }

    stages {
        stage('Checkout') {
            steps {
                // Get some code from a GitHub repository
                
                git credentialsId: GITHUB_PAT, branch: 'main', url: GITHUB_URL
            }
        }
        stage('Build') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean package"
            }
        }
        stage('Tests') {
            steps {
                echo("Pretend that unit tests have passed since I haven't written any unit tests for this assignment")
            }
        }
        stage('Deployment') {
            steps {
                script {
                    if (DEPLOYMENT_ENV == 'development') {
                        echo("Deploying to internal development environment")
                    } else if (DEPLOYMENT_ENV == 'quality') {
                        echo("Deploying to quality assurance testing environment")
                    } else if (DEPLOYMENT_ENV == 'staging') {
                        echo("Deploying to staging environment")
                    } else if (DEPLOYMENT_ENV == 'production')  {
                        echo("Deploying to production")
                    } else {
                        echo("DEPLOYMENT_ENV is invalid: current value is ${DEPLOYMENT_ENV}")
                    }
                }
            }
        }
    }
}
