package ejemploservidorhttp.https;

public class Init {
	public static int port = 9000;
	public static void main(String[] args) {
                System.out.println("Iniciando el servidor https");
		ServidorHttps httpsServer = new ServidorHttps();
		httpsServer.Start(port);
		
	}
}
