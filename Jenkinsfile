pipeline {
    agent any
    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5')
    }
    stages {
        stage ('load groovy script') {
            steps {
                script {
                    groovy = load 'fileDigest.groovy'
                }
            }
        }
        stage('Create tag') {
            when {
                changeset 'Dockerfile'
            }
            steps {
                sh """
                    docker build . -t "dockerimage:${groovy.md5sum('Dockerfile')}" -f ./Dockerfile
                """
            }
        }
        stage('Use the image') {

            steps {
                sh """
                    echo tag : ${groovy.md5sum('Dockerfile')}
                    docker images
                """
            }
        }
    }
}