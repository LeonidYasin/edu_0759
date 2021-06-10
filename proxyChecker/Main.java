import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C://temp/ip.txt");
            FileOutputStream fos = new FileOutputStream("C://temp/good_ip.txt");


            int i;
            String proxy = "";
            while((i=fis.read()) != -1){
                if(i==13) continue;
                else if(i==10){
                    String ip = proxy.split(":")[0];
                    String port = proxy.split(":")[1];
                    if(checkProxy(ip, Integer.parseInt(port)))
                        saveProxyIpToFile(fos,ip,port);
                    proxy = "";
                }else if(i!=9){
                    proxy += (char) i;
                }else{
                    proxy += ":";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean checkProxy(String ip, int port){
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip,port));
            URL url = new URL("https://vozhzhaev.ru/test.php");

            URLConnection urlConnection = url.openConnection(proxy);
            // urlConnection.setConnectTimeout(100); // 5 seconds
            // urlConnection.connect();
            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            int i;
            StringBuilder result = new StringBuilder();
            while ((i=reader.read()) != -1){
                result.append((char)i);
            }
            System.out.println("Proxy result: "+result + ":"+port+" - Ok " + ip+":"+port );
            return true;

        } catch (IOException exception) {
            System.out.println("ip:" +ip+":"+port+" - не работает! " + exception.getMessage());
            return false;
        }
    }

    public static void saveProxyIpToFile(FileOutputStream fos, String ip, String port)
    {
        try {
            fos.write((ip+":"+port+"\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

   /*     good_ip.txt
        59.124.224.180:4378
        139.5.132.245:8080
        68.183.54.155:8080
        159.65.14.136:8080
        128.199.124.73:8080
        68.183.54.155:8080
        167.71.171.14:8080
        23.251.138.105:8080
        167.71.167.1:8080
        14.241.111.38:8080
        93.117.72.27:43631
*/