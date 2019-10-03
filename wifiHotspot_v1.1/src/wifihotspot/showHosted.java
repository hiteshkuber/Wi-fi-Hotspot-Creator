package wifihotspot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class showHosted {

 
 public static String showNet() throws IOException {
 int flag=0;
 Process p= Runtime.getRuntime().exec("cmd /c netsh wlan show hostednetwork");

 String s,s1="";
    System.out.println(p.getOutputStream());
    BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(p.getInputStream()));
    while((s=stdInput.readLine())!=null){
     if(s.equals("Hosted network status   "))
        flag=1;
     if(flag==1)
        s1+=s+'\n';
    }
    return s1;
 }

 public static String netDetails() throws IOException {
 int flag=1;
 Process p= Runtime.getRuntime().exec("cmd /c netsh wlan show hostednetwork");

 String s,s1="";
    System.out.println(p.getOutputStream());
    BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(p.getInputStream()));
    while((s=stdInput.readLine())!=null){
     if(s.equals("Hosted network status   "))
        flag=0;
     if(flag==1)
        s1+=s+'\n';
    }
    return s1;
 }

}