pipeline {
    agent any

    stages {
        stage('Checkout') {
          stage('Checkout Git Project') {
            steps {
                script {
                    def gitUrl = 'https://github.com/abdou6666/devops_project.gi'
                    def branchName = 'anis'
                    def gitCredentialsId = 'noreply'
                    checkout([$class: 'GitSCM',
                        branches: [[name: branchName]],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [[$class: 'CloneOption', depth: 1, noTags: true, reference: '', shallow: true]],
                        userRemoteConfigs: [[url: gitUrl, credentialsId: gitCredentialsId]]
                    ])
                }
            }
        }
            
         stage('Build Test Project') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('BUILD Backend') {
            steps {
                // Use Java 8 for this stage
                withEnv(["JAVA_HOME=${tool name: 'JAVA_8_HOME', type: 'jdk'}"]) {
                    sh 'mvn clean install'
                }
            }
        }
            
        stage('Build Image') {
             steps {
                 script {
                     checkout([
                         $class: 'GitSCM',
                         branches: [[name: '*/anis']],
                         userRemoteConfigs: [[url: 'https://github.com/abdou6666/devops_project.git']]
                    ])

                     // Build the front Docker image
                   def Image = docker.build('anisammar422/devops', '-f /var/lib/jenkins/workspace/Anis_Ammar_5TWIN3/Dockerfile .')

                     // Authentification Docker Hub avec des informations d'identification secrètes
                withCredentials([string(credentialsId: 'docker', variable: 'pwd')]) {
                         sh "docker login -u anisammar422 -p ${pwd}"
                         // Poussez l'image Docker
                         Image.push()
                     }
                 }
             }
         }


        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }
    }
}
