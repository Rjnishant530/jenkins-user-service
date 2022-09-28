pipeline {
    agent any

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
               
               sh 'docker build -t user-service:latest'
           }

       }

    }
}
