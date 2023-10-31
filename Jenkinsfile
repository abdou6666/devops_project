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
        //stage("SonarQube Analysis") {
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
       stage('Build and Push front Image') {
             steps {
                 script {
                     checkout([
                         $class: 'GitSCM',
                         branches: [[name: '*/anis']],
                         userRemoteConfigs: [[url: 'https://github.com/Mohamed-Rouahi/Project-devops-frontend.git']]
                    ])

                     // Build the front Docker image
                   def Image = docker.build('anisammar/devops', '-f /var/lib/jenkins/workspace/Project-devops/Dockerfile .')

                     // Authentification Docker Hub avec des informations d'identification secrètes
                     withCredentials([string(credentialsId: 'docker', variable: 'pwd')]) {
                        sh "docker login -u medrouahi -p ${pwd}"
                         // Poussez l'image Docker
                         Image.push()
                     }
                 }
             }
         }
           
//         stage('Clean Workspace') {
//             steps {
//                 deleteDir()
//        }
// }
    }
}
