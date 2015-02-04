mvn clean install

if [ $? -eq 0 ]; then
    java -jar target/csvdiff.jar
else
    echo "Build failed."
fi
