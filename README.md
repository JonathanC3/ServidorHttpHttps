# Servidor Http y Https
Estos son los servidores tanto http como https

Software de servidor elaborado por María Orocú, José Quirós, Jonathan Castro y Pablo Castillo

En este apartado se detallará el software que se debe instalar para ejecutar este proyecto y cuales son los pasos a seguir.

### Requerimentos para ejecutar correctamente este proyecto:

- En primer lugar se requiere el IDE de Netbeans que permite crear y ejecutar proyectos en el lenguaje de programación java. 
  Para desarrollar este proyecto se utilizó la versión 8.2. Este se puede instalar desde su página oficial, en el siguiente enlace:                                               https://netbeans.apache.org/download/index.html
  
- Herramientas de desarrollo para JAVA (JDK) como su nombre lo dice son herramientas que permiten la creación de proyectos en este lenguaje de programación. El cual fue elegido   para la creación de este proyecto. Se puede descargar en: https://www.oracle.com/technetwork/es/java/javase/downloads/index.html

- Se requiere la generación del certificado SSL, específicamente para desarrollar el proyecto https, ya que le permite crear una clave para que el cliente se pueda conectar correctamente.

Se abre la consola de comandos, y se pega el siguiente código:
keytool -genkeypair -keyalg RSA -alias self_signed -keypass passhttps -keystore https.keystore -storepass passhttps

Y generar la certificación de la clave correctamente para su uso en este proyecto.
### 

![httpsCertCorrecto](https://user-images.githubusercontent.com/37557466/100566459-b1d06680-328b-11eb-964b-c7fd26b33c24.PNG)

A continuación, por medio de una serie de capturas de pantalla se detallarán los pasos a seguir para clonar el proyecto y ejecutarlo. 

# Clonando el proyecto

1. Se debe abrir el IDE de Netbeans.

2. Seleccionar la opción Team/ Equipo en la barra principal. 

![WhatsApp Image 2020-11-29 at 10 47 56 PM](https://user-images.githubusercontent.com/28690419/100569868-fc0a1580-3294-11eb-9910-0773577a25c4.jpeg)

3. Luego de seleccionar Team/Equipo se despliegan una serie de opciones, de las cuales se elegirá Git y seguidamente Clone.
![Captura de pantalla (411)](https://user-images.githubusercontent.com/28690419/86814230-5a143300-c03e-11ea-8728-37b471a8f03e.png)

4. Se desplegará una ventana "Clone Repository" en la que se solicita el enlace del repositorio, las credenciales de la cuenta en GitHub y la ruta deseada para clonar el proyecto. Luego de esto dar click en Next. 
![Captura de pantalla (12)](https://user-images.githubusercontent.com/28690419/100570774-265cd280-3297-11eb-84aa-bc24dc663935.png)

El enlace del repositorio se puede copiar desde la sección de code como se muestra en la siguiente imagen.
![Captura de pantalla (11)](https://user-images.githubusercontent.com/28690419/100570692-f7466100-3296-11eb-9404-09b2886698f8.png)

5. Se mostrará la siguiente ventana y es necesario seleccionar la rama que desea clonar, seguidamente selecciona el botón de Next.
![Captura de pantalla (13)](https://user-images.githubusercontent.com/28690419/100570896-6e7bf500-3297-11eb-9543-015a715f0b89.png)

6. Finalmente es necesario presionar el botón de Finish y el proyecto quedará clonado correctamente. 
![Captura de pantalla (14)](https://user-images.githubusercontent.com/28690419/100570942-85224c00-3297-11eb-8772-9727bbb7a83c.png)

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


