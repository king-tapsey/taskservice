node{
  stage('SCM Checkout') {
   git 'https://github.com/king-tapsey/taskservice/tree/main'
  }
  stage('Compile-Package'){
     def mvnHome = tool name: 'maven3', type: 'maven'
     sh "${mvnHome}/bin/mvn package"
  }
  
}  
