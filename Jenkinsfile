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

        stage('Run Docker Compose') {
            steps {
                script {
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/anis']],
                        userRemoteConfigs: [[url: 'https://github.com/abdou6666/devops_project.git']]
                    ])
            
                    // Define the path to the docker-compose.yml file
                    def composeFilePath = "/var/lib/jenkins/workspace/Anis_Ammar_5TWIN3/docker-compose.yml"

                    // Run the docker-compose command with the file path
                    sh "docker-compose up -d"
                }
            }
        }
    }
}
