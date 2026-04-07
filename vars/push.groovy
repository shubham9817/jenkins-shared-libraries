

def call(){
    echo 'pushing the image to dockerhub'
    withCredentials([usernamePassword(
      credentialID: 'dockerhub-cred',
      passwordVariable: 'dockerHubPass', 
      usernameVariable: 'dockerHubUser')])
                    
    sh 'docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}' 
    sh 'docker image tag django_app:latest ${env.dockerHubUser}/django_app:latest'
    sh 'docker push ${env.dockerHubUser}/django_app:latest'
}
