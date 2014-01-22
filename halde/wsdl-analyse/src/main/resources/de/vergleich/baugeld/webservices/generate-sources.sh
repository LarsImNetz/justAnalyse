if [ -e HelloWorld.wsdl ]; then

    WSDL=HelloWorld.wsdl
else
    WSDL=http://localhost:8080/services?wsdl
fi

"c:/Program Files/java/jdk1.6.0_38/bin/wsimport.exe" -Xnocompile -d ../../../../../../../src/main/java -keep -p de.vergleich.baugeld.hello.with.wsimport ${WSDL}
