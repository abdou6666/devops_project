pipeline {
    agent any
 
    stages {
        stage('Checkout') {
            steps {
                // Utilisation de Git pour récupérer le code
                git branch: 'anis', url: 'https://github.com/abdou6666/devops_project.git'
            }
        }
 
        stage('Clean compile maven') {
            steps {
                // Exécution des commandes Maven
                sh 'mvn clean compile'
            }
        }
           
        stage('Clean Workspace') {
            steps {
                deleteDir()
       }
}
    }
}
