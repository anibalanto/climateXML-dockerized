## Compilar la biblioteca climateDataReaderStatic

Generar el archivo .class

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

Se vuelve a la carpeta principal del proyecto

```bash
cd ../..
```

## Compilar la biblioteca climateDataReaderSMN

Generar el archivo .class

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

Se vuelve a la carpeta principal del proyecto

```bash
cd ../..
```

## Compilamos el servidor

```bash
javac -cp json-simple-1.1.jar:climateDataReader/dist/climateDataReader.jar:climateDataReaderStatic.jar:HTTPServer/src HTTPServer/src/httpserver/HttpServer.java
```

## Ejecutar el Server con climateDataREaderStatic.jar

```bash
java -cp json-simple-1.1.jar:climateDataReader/dist/climateDataReader.jar:climateDataReaderStatic.jar:HTTPServer/src/  httpserver/HttpServer 8081
```

## Ejecutar el Server con climateDataREaderSMN.jar

```bash
java -cp json-simple-1.1.jar:climateDataReader/dist/climateDataReader.jar:climateDataReaderSMN.jar:HTTPServer/src/  httpserver/HttpServer 8081
```

