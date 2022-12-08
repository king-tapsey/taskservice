node {
    
    stage ("checkout")  {
       checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jenkins-key', url: 'https://github.com/king-tapsey/taskservice/']]])
     }
  
    stage('Compile-Package') {
        def mvnHome = tool name: 'maven3', type: 'maven'
        sh export "set MAVEN_OPTS=\"-DCONFIG_SERVER_URI=HTTP://192.168.10.45:8081\""
        sh "${mvnHome}/bin/mvn package"
    }
}  

