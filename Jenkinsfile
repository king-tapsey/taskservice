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

  stage ('Nexus upload')  {
        nexusArtifactUploader(
        nexusVersion: 'nexus3',
        protocol: 'http',
        nexusUrl: 'http://192.168.10.45:8085',
        groupId: 'myGroupId',
        version: '1.0-SNAPSHOT',
        repository: 'taskservice-official-repository',
        credentialsId: 'NEXUS_CRED',
        artifacts: [
            [artifactId: 'taskservice',
             classifier: '',
             file: '/workspace/Task-service-official\ pipline/target/taskservice-0.0.1-SNAPSHOT.jar',
             type: 'jar']
        ]
     )
    }
    }
}
