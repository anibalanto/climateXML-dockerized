Compilar la librería climateDataReaderStatic generando el archivo .class

```bash
javac -cp json-simple-1.1.jar:climateDataReader/dist/climateDataReader.jar:climateDataReaderStatic/src/  climateDataReaderStatic/src/climatedatareader/ClimateDataReaderImpl.java
```

Nos paramos en la carpeta del código de la biblioteca

```bash
cd climateDataReaderStatic/src/
```

A partir del archivo .class generamos la librería climateDataREaderStatic.jar

```bash
jar cvfe ../../climateDataReaderStatic.jar climatedatareader/ClimateDataReaderImpl.class climatedatareader/*.class
```
-------

Compilar la biblioteca climateDataReaderSMN generando el archivo .class

```bash
javac -cp json-simple-1.1.jar:climateDataReader/dist/climateDataReader.jar:climateDataReaderSMN/src/  climateDataReaderSMN/src/climatedatareader/ClimateDataReaderImpl.java
```

Nos paramos en la carpeta del código de la biblioteca

```bash
cd climateDataReaderSMN/src/
```

A partir del archivo .class generamos la librería climateDataREaderSMN.jar

```bash
jar cvfe ../../climateDataReaderSMN.jar climatedatareader/ClimateDataReaderImpl.class climatedatareader/*.class
```
-------

Compilamos el servidor

```bash
javac -cp json-simple-1.1.jar:climateDataReader/dist/climateDataReader.jar:climateDataReaderStatic.jar:HTTPServer/src HTTPServer/src/httpserver/HttpServer.java
```

-------
ejecutar HTTPServer con el jar climateDataREaderStatic.jar

```bash
java -cp json-simple-1.1.jar:climateDataReader/dist/climateDataReader.jar:climateDataReaderStatic.jar:HTTPServer/src/  httpserver/HttpServer 8081
```

-------

ejecutar HTTPServer con el jar climateDataREaderSMN.jar

```bash
java -cp json-simple-1.1.jar:climateDataReader/dist/climateDataReader.jar:climateDataReaderSMN.jar:HTTPServer/src/  httpserver/HttpServer 8081
```

