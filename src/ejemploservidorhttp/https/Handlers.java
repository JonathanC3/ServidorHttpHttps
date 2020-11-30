package ejemploservidorhttp.https;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Handlers {

    static final File WEB_ROOT = new File("C:/Users/jcast/OneDrive/Documents/NetBeansProjects/ServidorHttp/src/pages/");
    static final String DEFAULT_FILE = "index.html";
    static final String FILE_NOT_FOUND = "404.html";
    static final String METHOD_NOT_SUPPORTED = "not_supported.html";

    public static class RootHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            byte[] encoded = Files.readAllBytes(
                    Paths.get(WEB_ROOT + "/" + DEFAULT_FILE));
            he.sendResponseHeaders(200, encoded.length);
            he.getResponseHeaders().set("Content-Type", "text/html;charset=utf-8");
            OutputStream os = he.getResponseBody();
            os.write(encoded);
            os.close();
        }
    }

    public static class RootHandlerPrueba implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            byte[] encoded = Files.readAllBytes(
                    Paths.get(WEB_ROOT + "/" + DEFAULT_FILE));
            he.sendResponseHeaders(200, encoded.length);
            he.getResponseHeaders().set("Content-Type", "text/html;charset=utf-8");
            //he.getResponseHeaders().set("Content-Type", "image/jpeg");
            OutputStream os = he.getResponseBody();
            os.write(encoded);
            os.close();
        }
    }

    public static class SecundariaHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            byte[] encoded = Files.readAllBytes(
                    Paths.get(WEB_ROOT + "/" + "secundaria.html"));
            he.sendResponseHeaders(200, encoded.length);
            he.getResponseHeaders().set("Content-Type", "text/html;charset=utf-8");
            OutputStream os = he.getResponseBody();
            os.write(encoded);
            os.close();
        }
    }

    public static class TerciariaHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            byte[] encoded = Files.readAllBytes(
                    Paths.get(WEB_ROOT + "/" + "terciaria.html"));
            he.sendResponseHeaders(200, encoded.length);
            he.getResponseHeaders().set("Content-Type", "text/html");
            OutputStream os = he.getResponseBody();
            os.write(encoded);
            os.close();
        }
    }

    public static class EchoHeaderHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            Headers headers = he.getRequestHeaders();
            Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
            String response = "";
            for (Map.Entry<String, List<String>> entry : entries) {
                response += entry.toString() + "\n";
            }
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }
    }

    public static class EchoGetHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            // parse request
            Map<String, Object> parameters = new HashMap<String, Object>();
            URI requestedUri = he.getRequestURI();
            String query = requestedUri.getRawQuery();
            parseQuery(query, parameters);
            // send response
            String response = "";
            for (String key : parameters.keySet()) {
                response += key + " = " + parameters.get(key) + "\n";
            }
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }

    }

    public static class EchoPostHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            System.out.println("Served by /echoPost handler...");
            // parse request
            Map<String, Object> parameters = new HashMap<String, Object>();
            InputStreamReader isr = new InputStreamReader(he.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String query = br.readLine();
            parseQuery(query, parameters);
            // send response
            String response = "";
            for (String key : parameters.keySet()) {
                response += key + " = " + parameters.get(key) + "\n";
            }
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();

        }
    }

    @SuppressWarnings("unchecked")
    public static void parseQuery(String query, Map<String, Object> parameters) throws UnsupportedEncodingException {

        if (query != null) {
            String pairs[] = query.split("[&]");

            for (String pair : pairs) {
                String param[] = pair.split("[=]");

                String key = null;
                String value = null;
                if (param.length > 0) {
                    key = URLDecoder.decode(param[0], System.getProperty("file.encoding"));
                }

                if (param.length > 1) {
                    value = URLDecoder.decode(param[1], System.getProperty("file.encoding"));
                }

                if (parameters.containsKey(key)) {
                    Object obj = parameters.get(key);
                    if (obj instanceof List<?>) {
                        List<String> values = (List<String>) obj;
                        values.add(value);
                    } else if (obj instanceof String) {
                        List<String> values = new ArrayList<String>();
                        values.add((String) obj);
                        values.add(value);
                        parameters.put(key, values);
                    }
                } else {
                    parameters.put(key, value);
                }
            }
        }
    }
}
