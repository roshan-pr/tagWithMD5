def md5sum(file) {
    def fileContents = readFile(file).replaceAll("[\n\r]", "")
    java.security.MessageDigest.getInstance("MD5").digest(fileContents.getBytes()).encodeHex().toString()
}

pipeline {
    agent any
    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5')
    }
    stages {
        stage('Create tag') {
            when {
                changeset 'Dockerfile'
            }
            steps {
                sh """
                    docker build . -t "dockerimage:${md5sum('Dockerfile')}" -f ./Dockerfile
                """
            }
        }
        stage('Use the image') {

            steps {
                sh """
                    echo tag : ${md5sum('Dockerfile')}
                    docker images
                """
            }
        }
    }
}