pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'anis', url: 'https://github.com/abdou6666/devops_project.git'
            }
        }

        stage('Clean compile maven') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Clean Specific Files') {
            steps {
                sh 'rm -rf *.txt'
            }
        }

        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }
    }
}
