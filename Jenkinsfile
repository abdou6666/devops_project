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
        stage("SonarQube Analysis") {
        //     steps {
        //         // Set Java 11 for this stage
        //         tool name: 'JAVA_HOME', type: 'jdk'
        //         withEnv(["JAVA_HOME=${tool name: 'JAVA_HOME', type: 'jdk'}"]) {
        //             withSonarQubeEnv('sonarQube') {
        //                 script {
        //                     def scannerHome = tool 'SonarQubeScanner'
        //                     withEnv(["PATH+SCANNER=${scannerHome}/bin"]) {
        //                         sh '''
        //                             mvn sonar:sonar \
        //                                 -Dsonar.java.binaries=target/classes
        //                         '''
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
           
        stage('Clean Workspace') {
            steps {
                deleteDir()
       }
}
    }
}
