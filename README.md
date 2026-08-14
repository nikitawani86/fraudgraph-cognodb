git init
git remote add origin "URL"
git push


//Docker Commands
dcoker run -it -p 1025:1025 <image-name>


//Creating  your own customize image
dcoker buiild -t "image-name" 

//Port mapping
docker run -it -p 8080:8080 "image-name"

//changing env variable -- changing port mapping here from 8000 to 4000
docker run -it -e PORT=4000 -p 4000:4000 "image-name"