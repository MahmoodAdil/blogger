pipeline {
    agent any
    
    parameters {
        string(name: 'SL_USERNAME', defaultValue: '', description: 'Softlayer username')
        password(name: 'SL_API_KEY', defaultValue: 'SECRET', description: 'Softlayer API key')
        booleanParam(name: 'SL_VIRTUAL_GUEST', defaultValue: false, description: 'Tell to the job when is being run on a VM or a Baremetal. (By default unset means VSI -- Virtual Machine)')
        file(name: 'hostnames.txt', description: 'hostnames file')
    }
    stages {
        stage ('Initialize') {
            environment {
                DISPLAYNAME = "BOOTSTRAP"
            }
            steps {
                script {
                    currentBuild.displayName = "${env.DISPLAYNAME}-#${env.BUILD_NUMBER}"
                    currentBuild.description = ""
                    }
                    echo 'Initializing..'
                    echo "Hello ${params.SL_USERNAME}"
                    echo "Password: ${params.SL_API_KEY}"
                    echo "The build number is ${env.BUILD_NUMBER}"
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
    }
}
