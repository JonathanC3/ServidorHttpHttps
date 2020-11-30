# Servidor Http y Https
Estos son los servidores tanto http como https

Software de servidor elaborado por Maria Orocú,José Quirós, Jonathan Castro y Pablo Castillo

### Requerimentos para ejecutar correctamente este proyecto:
* En primer lugar se requiere el NetBeans 8.2 con todas las opciones disponibles a ser posibles, ya que este cuenta con el JDK y el JAVA 8 correctamente.

https://netbeans.org/downloads/8.2/rc/

* Se requiere la generación del certificado SSL, específicamente para desarrollar el proyecto https, ya que le permite crear una clave para que el cliente se pueda conectar correctamente.

Se abre la consola de comandos, y se pega el siguiente código:
keytool -genkeypair -keyalg RSA -alias self_signed -keypass passhttps -keystore https.keystore -storepass passhttps

Y generar la certificación de la clave correctamente para su uso en este proyecto.
### 

![httpsCertCorrecto](https://user-images.githubusercontent.com/37557466/100566459-b1d06680-328b-11eb-964b-c7fd26b33c24.PNG)

### Tecnologías Utilizadas
- Java
- HTML
- CSS
- Certificado SSL

### Referencias 
Las siguientes referencias ayudaron para desarrollar el presente trabajo
- http://www.herongyang.com/Cryptography/keytool-Generating-Private-Key.html
para poder generar correctamente el certificado de ssl
- http://www.herongyang.com/JDK/HTTPS-Server-Test-Program-HttpsHello.html
proyecto base que utilizar https
- https://www.youtube.com/watch?v=LJjIaCKuzoc&t=7s
- https://www.youtube.com/watch?v=NXXCDA4ZkwY&t=587s
Estos videos ayudaron en el desarrollo del servidor http


