## Compilar la biblioteca climateDataReader


Nos paramos en la carpeta del código de la biblioteca

```bash
cd climateDataReader/src/
```

Generar el archivo .class

```bash
javac -cp ../../lib/*:.  climatedatareader/ClimateDataReader.java
```


A partir del archivo .class generamos la librería climateDataREaderStatic.jar

```bash
jar cvfe ../../lib/climateDataReader.jar climatedatareader/ClimateDataReader.class climatedatareader/*.class
```

Se vuelve a la carpeta principal del proyecto

```bash
cd ../..
```

## Compilar la biblioteca climateDataReaderStatic

Nos paramos en la carpeta del código de la biblioteca

```bash
cd climateDataReaderStatic/src/
```

Generar el archivo .class

```bash
javac -cp ../../lib/*:.  climatedatareader/ClimateDataReaderImpl.java
```


A partir del archivo .class generamos la librería climateDataREaderStatic.jar

```bash
jar cvfe ../../lib/climateDataReaderStatic.jar climatedatareader/ClimateDataReaderImpl.class
```

Se vuelve a la carpeta principal del proyecto

```bash
cd ../..
```

## Compilar la biblioteca climateDataReaderSMN


Nos paramos en la carpeta del código de la biblioteca

```bash
cd climateDataReaderSMN/src/
```

Generar el archivo .class (tener en cuenta de no agregar climateDataReaderStatic.jar al classpath)

```bash
javac -cp ../../lib/json-simple-1.1.jar:../../lib/climateDataReader.jar:.  climatedatareader/ClimateDataReaderImpl.java
```

A partir del archivo .class generamos la librería climateDataREaderSMN.jar

```bash
jar cvfe ../../lib/climateDataReaderSMN.jar climatedatareader/ClimateDataReaderImpl.class climatedatareader/*.class
```

Se vuelve a la carpeta principal del proyecto

```bash
cd ../..
```

## Compilamos el servidor con climateDataReaderStatic.jar

Nos paramos en la carpeta del código de la biblioteca

```bash
cd HTTPServer/src/
```

Generar el archivo .class (tener en cuenta de no agregar climateDataReaderStatic.jar al classpath)

```bash
javac -cp ../../lib/json-simple-1.1.jar:../../lib/climateDataReader.jar:../../lib/climateDataReaderStatic.jar:.  httpserver/HttpServer.java
```
## Ejecutar el Server con climateDataReaderStatic.jar

```bash
java -cp ../../lib/json-simple-1.1.jar:../../lib/climateDataReader.jar:../../lib/climateDataReaderStatic.jar:. httpserver.HttpServer 8080
```

## Compilamos el servidor con climateDataReaderSMN.jar

Nos paramos en la carpeta del código de la biblioteca

```bash
cd HTTPServer/src/
```

Generar el archivo .class (tener en cuenta de no agregar climateDataReaderStatic.jar al classpath)

```bash
javac -cp ../../lib/json-simple-1.1.jar:../../lib/climateDataReader.jar:../../lib/climateDataReaderSMN.jar:.  httpserver/HttpServer.java
```
## Ejecutar el Server con climateDataReaderSMN.jar

```bash
java -cp ../../lib/json-simple-1.1.jar:../../lib/climateDataReader.jar:../../lib/climateDataReaderSMN.jar:. httpserver.HttpServer 8080
```
