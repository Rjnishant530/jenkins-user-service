pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE_NAME='user-service'
        DOCKER_TEMP_CONTAINER_NAME='user-temp-container'
        DOCKER_REPO="rjnishant"
    }

    stages {
        stage('Clean') {
            steps {
                
                sh "mvn clean"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

    	}
    	stage('Compile') {
            steps {
                
                sh "mvn compile"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

         
       }
       stage('Quality') {
            steps {
                
                sh "mvn sonar:sonar"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

         
       }
       stage('Test') {
            steps {
                
                sh "mvn test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

         
       }
       stage('Build') {
            steps {
                
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

         
       }
       stage('Docker Image'){
           steps{
               
               sh 'docker build -t ${DOCKER_REPO}/${DOCKER_IMAGE_NAME}:latest -t ${DOCKER_REPO}/${DOCKER_IMAGE_NAME}:${BUILD_ID} .'
           }

       }
       stage('Integration'){
           steps{
               sh 'docker run -dp 7070:8001 --rm --name ${DOCKER_TEMP_CONTAINER_NAME} ${DOCKER_REPO}/${DOCKER_IMAGE_NAME}:latest'
               sleep 10
               sh 'curl -i http://localhost:7070/api/users'
           }
         }
		stage('docker publish'){
		    
		    steps{
		        withDockerRegistry([credentialsId: 'docker_login', url: '']){
		        sh "docker push ${DOCKER_REPO}/${DOCKER_IMAGE_NAME}:latest"                                                       
		        sh "docker push ${DOCKER_REPO}/${DOCKER_IMAGE_NAME}:${BUILD_ID}"                                                       
		                                                               
		                                                           }

		    }

		}


    }
    post{
        
        always{
            sh 'docker stop ${DOCKER_TEMP_CONTAINER_NAME}'
            sh "docker rmi  ${DOCKER_REPO}/${DOCKER_IMAGE_NAME}:latest ${DOCKER_REPO}/${DOCKER_IMAGE_NAME}:${env.BUILD_ID}"
        }

    }

}
