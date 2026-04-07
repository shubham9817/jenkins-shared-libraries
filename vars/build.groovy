def call(){
  sh 'whoami'
  sh 'docker-compose build'
}
