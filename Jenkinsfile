pipeline {
    agent {
        docker {
			 // Run the pipeline inside a Docker container
            // using Maven with JDK 17
            image 'maven:3.9.6-eclipse-temurin-17'
        }
    }
    stages {
        stage('Checkout') {
            steps {
            	echo "Code started in docker"
                // Pull code from Git
                checkout scm
            }
        }
        stage('Build & Test') {
            steps {
				// Clean previous builds and run Maven tests inside the container
                // Run Maven build & tests inside container
                sh 'mvn clean test'
                echo "Code executed in docker"
            }
        }
        stage('Report') {
            steps {
                // Archive test results & HTML reports
                junit '**/target/surefire-reports/*.xml'
                publishHTML([
					allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output'
					reportFiles: 'ExtentReport.html'
                    reportName: 'Extent Report'
                    reportTitles: 'Automation Test Execution Report'
                ])
            }
        }
    }
}