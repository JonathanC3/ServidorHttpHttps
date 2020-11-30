package ejemploservidorhttp.https;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManagerFactory;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;
import java.io.File;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ServidorHttps {
	private int port;
	private HttpsServer server;
	private static String protocol = "TLS";
        
	public void Start(int port) {
		try {
			this.port = port;
			// load certificate
			
			char[] storepass = "passhttps".toCharArray();
			char[] keypass = "passhttps".toCharArray();
			String alias = "self_signed";
			FileInputStream fIn = new FileInputStream("C:\\Users\\jcast\\OneDrive\\Documents\\NetBeansProjects\\Ejemplo ServidorHttp\\src\\ejemploservidorhttp\\data\\https.keystore");
			KeyStore keystore = KeyStore.getInstance("JKS");
			keystore.load(fIn, storepass);

			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(keystore, keypass);

			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			tmf.init(keystore);

			server = HttpsServer.create(new InetSocketAddress(port), 0);
			
			SSLContext sslContext = SSLContext.getInstance(protocol);
			sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
			server.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
				public void configure(HttpsParameters params) {
					try {
						// initialise the SSL context
						SSLContext c = SSLContext.getDefault();
						SSLEngine engine = c.createSSLEngine();
						params.setNeedClientAuth(false);
						params.setCipherSuites(engine.getEnabledCipherSuites());
						params.setProtocols(engine.getEnabledProtocols());

						// get the default parameters
						SSLParameters defaultSSLParameters = c.getDefaultSSLParameters();
						params.setSSLParameters(defaultSSLParameters);
					} catch (Exception ex) {
						ex.printStackTrace();
						System.out.println("Error para crear el servidor HTTPS ");
					}
				}
			});

			System.out.println("El servidor https inicia en el puerto " + port);
                        //redirecciones a las otras páginas web
			server.createContext("/", new Handlers.RootHandler());
			server.createContext("/secundaria.html", new Handlers.SecundariaHandler());
                        server.createContext("/terciaria.html", new Handlers.TerciariaHandler());
                        server.setExecutor(null);
                        server.start();
                        int finalizar=JOptionPane.showConfirmDialog(null, "¿Quieres detener el servidor HTTPS?", "¿Pregunta?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (finalizar==JOptionPane.YES_OPTION){
                            Stop();
                        }else if(finalizar==JOptionPane.NO_OPTION){
                            
                        } 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Stop() {
		server.stop(0);
		System.out.println("El servidor se detuvo");
	}
}
