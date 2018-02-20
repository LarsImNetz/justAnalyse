# Script hat Democharakter, es soll zeigen, wie man neue Maven Projekte anlegen kann.
# create mongodb pom.xml
# mvn archetype:generate -DgroupId=privat.lla -DartifactId=mongodb -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
# mvn archetype:generate -DgroupId=privat.lla -DartifactId=fail-tests    -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
mvn archetype:generate -DgroupId=privat.lla -DartifactId=helloworld -B -DarchetypeArtifactId=java8-junit4-quickstart -DarchetypeGroupId=org.spilth -Dversion=1.0.0
