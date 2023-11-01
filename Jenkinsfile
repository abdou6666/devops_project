pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    def gitUrl = 'https://github.com/abdou6666/devops_project.git'
                    def branchName = 'anis'  // Specify your branch name here
                    def gitCredentialsId = 'noreply'  // Specify your Git credentials ID here

                    checkout([$class: 'GitSCM',
                        branches: [[name: branchName]],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [[$class: 'CloneOption', depth: 1, noTags: true, reference: '', shallow: true]],
                        userRemoteConfigs: [[url: gitUrl, credentialsId: gitCredentialsId]]
                    ])
                }
            }
        }



    }
}
