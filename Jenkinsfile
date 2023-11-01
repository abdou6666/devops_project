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
       // stage('Build and Push Back Image') {
       //       steps {
       //           script {
       //               checkout([
       //                   $class: 'GitSCM',
       //                   branches: [[name: '*/anis']],
       //                   userRemoteConfigs: [[url: 'https://github.com/abdou6666/devops_project.git']]
       //              ])

       //               // Build the front Docker image
       //             def Image = docker.build('anisammar422/devops', '-f /var/lib/jenkins/workspace/Anis_Ammar_5TWIN3/Dockerfile .')

       //               // Authentification Docker Hub avec des informations d'identification secrètes
       //          withCredentials([string(credentialsId: 'docker', variable: 'pwd')]) {
       //                   sh "docker login -u anisammar422 -p ${pwd}"
       //                   // Poussez l'image Docker
       //                   Image.push()
       //               }
       //           }
       //       }
       //   }
        stage('Run Docker Compose') {
    steps {
        script {
            checkout([
                $class: 'GitSCM',
                branches: [[name: '*/anis']], 
                userRemoteConfigs: [[url: 'https://github.com/abdou6666/devops_project.git']]
            ])

            // Run the docker-compose command
            sh 'docker compose up -d' 
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


