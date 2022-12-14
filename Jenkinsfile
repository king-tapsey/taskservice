node{
    stage ("checkout")  {
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jenkins-key', url: 'https://github.com/king-tapsey/taskservice/']]])
     }
  
    stage('Compile-Package') {
//         sh "export set MAVEN_OPTS=\" -DCONFIG_SERVER_URI='http://192.168.10.45:8081' \""
        def mvnHome = tool name: 'maven3', type: 'maven'
        sh "${mvnHome}/bin/mvn package -DCONFIG_SERVER_URI=http://192.168.10.45:8081"
    }
    stage('Maven Build'){
        steps{
            def mvnHome = tool name: 'maven3', type: 'maven'
            sh "mvn clean package"
        }
    }
    stage ('SonarQube Analysis')  {
       def mvnHome = tool name: 'maven3', type: 'maven'
        withSonarQubeEnv('SonarQube') {      
        sh "${mvnHome}/bin/mvn clean verify sonar:sonar"
       }
    }
  
   stage ('Code coverage')  {
       jacoco()
   }
}
