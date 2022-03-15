docker container prune -f
docker image prune -f
docker system prune -a --volumes -f
docker rmi -f $(docker images -aq) -f
docker rm -vf $(docker ps -aq)
