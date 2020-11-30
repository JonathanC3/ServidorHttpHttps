package ejemploservidorhttp.https;

public class Main {
	public static int port = 8000;
	public static void main(String[] args) {
                System.out.println("Iniciando el servidor https");
		ServidorHttps httpsServer = new ServidorHttps();
		httpsServer.Start(port);
		
	}
}
