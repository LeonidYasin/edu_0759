/*Лабораторная работа #7
Мульти поточный прокси чекер методом 2 и 3 с 3мя попытками.
*/



import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C://temp/ip.txt");
            FileOutputStream fos3 = new FileOutputStream("C://temp/good_ip.txt");
            FileOutputStream fos2 = new FileOutputStream("C://temp/good_ip2.txt");

            int i;
            String proxy = "";
            while((i=fis.read()) != -1){
                if(i==13) continue;
                else if(i==10){
                    String ip = proxy.split(":")[0];
                    String port = proxy.split(":")[1];


                    //Второй способ

                    new Thread(new MyRunnableThread(
                            "checking "+ ip,
                            ip, port, fos2)).start();


                    // Третий способ

                    new Thread(new Runnable() {
                        @Override
                        public void run() {


                            if (checkProxy(ip, Integer.parseInt(port)))
                                saveProxyIpToFile(fos3, ip, port);
                            else if (checkProxy(ip, Integer.parseInt(port)))
                                saveProxyIpToFile(fos3, ip, port);
                            else if (checkProxy(ip, Integer.parseInt(port)))
                                saveProxyIpToFile(fos3, ip, port);

                        }
                    }).start();









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
            urlConnection.setConnectTimeout(5000); // 5 seconds
            urlConnection.connect();
            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            int i;
            StringBuilder result = new StringBuilder();
            while ((i=reader.read()) != -1){
                result.append((char)i);
            }
            System.out.println("Proxy result: "+result + ":"+port+" - Ok " + ip+":"+port );
            return true;

        } catch (Exception exception) {
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

class MyRunnableThread implements Runnable{
    private String task;
    private String ip;
    private String port;
    private FileOutputStream fos;

    public MyRunnableThread(String task, String ip, String port, FileOutputStream fos) {
        this.task = task;
        this.ip = ip;
        this.port = port;
        this.fos = fos;
    }

    @Override
    public void run() {


        if (Main.checkProxy(ip, Integer.parseInt(port)))
            Main.saveProxyIpToFile(fos, ip, port);
        else if (Main.checkProxy(ip, Integer.parseInt(port)))
            Main.saveProxyIpToFile(fos, ip, port);
        else if (Main.checkProxy(ip, Integer.parseInt(port)))
            Main.saveProxyIpToFile(fos, ip, port);




    }
}

