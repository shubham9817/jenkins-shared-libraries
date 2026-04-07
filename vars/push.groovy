

def call(String credentials){
    echo 'pushing the image to dockerhub'
    withCredentials([usernamePassword(
      credentialID: ${credentials}, 
      passwordVariable: 'dockerHubPass', 
      usernameVariable: 'dockerHubUser')])
                    
    sh 'docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}' 
    sh 'docker image tag django_app:latest ${env.dockerHubUser}/django_app:latest'
    sh 'docker push ${env.dockerHubUser}/django_app:latest'
}
