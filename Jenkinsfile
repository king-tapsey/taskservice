node{
    stage ("checkout")  {
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jenkins-key', url: 'https://github.com/king-tapsey/taskservice/']]])
     }
  
    stage('Maven-Build') {
//         sh "export set MAVEN_OPTS=\" -DCONFIG_SERVER_URI='http://192.168.10.45:8081' \""
        def mvnHome = tool name: 'maven3', type: 'maven'
        sh "${mvnHome}/bin/mvn clean install -DCONFIG_SERVER_URI=http://192.168.10.45:8081"
    }
    stage ('SonarQube Analysis')  {
       def mvnHome = tool name: 'maven3', type: 'maven'
        withSonarQubeEnv('SonarQube') {      
        sh "${mvnHome}/bin/mvn clean verify sonar:sonar"
       }
         
   stage ('Code coverage')  {
       jacoco()
   }
}
        
def getVersion(){
    
}
