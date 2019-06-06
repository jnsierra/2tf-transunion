# 2tf-transunion

##Instalación
Maven proyect por medio de spring boot

##Instalación certificado SSL JVM

[Windows]

Se debe correr el siguiente comando; nos ubicamos en la ruta bin del JDK

Ejemplo

C:\Program Files\Java\jdk1.8.0_211\bin

y corremos lo siguiente (Cambiando las rutas que corresponda según sea el caso)

keytool -import -alias cifin -keystore "C:\Program Files\Java\jdk1.8.0_211\jre\lib\security\cacerts" -file "C:\repository\codesoftware\2tf-transunion\src\main\resources\cifin.cer"

keytool -import -alias cifin -keystore "C:\Program Files\Java\jre1.8.0_211\lib\security\cacerts" -file "C:\repository\codesoftware\2tf-transunion\src\main\resources\cifin.cer"


Luego de esto solicitara una clave la cual es por default "changeit"

###Nota: La consola (cmd) se debe ejecutar como administrador