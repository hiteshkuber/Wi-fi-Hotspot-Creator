/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wifihotspot;

import java.io.PrintWriter;

/**
 *
 * @author hiteshkuber
 */
public class WifiHotspot {

    public static int hostNet(String ssid,String key) 
    {
		String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command);
		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
	                stdin.println("netsh wlan set hostednetwork mode=allow ssid="+ssid+" key="+key);
                        Thread.sleep(1000);
	                stdin.println("netsh wlan start hostednetwork");
	                stdin.close();
	                p.waitFor();
	    	} catch (Exception e) {
                        return 0;
		}
        return 1;
    }
    public static int stopNet()
    {
		String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command);
		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
	                stdin.println("netsh wlan stop hostednetwork");
	                stdin.close();
	                p.waitFor();
	    	} catch (Exception e) {
                        return 0;
		}
        return 1;
    }
    /*
    public static int usersActive()
    {
		String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command);
		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
	                stdin.println("netsh wlan show hostednetwork");
	                stdin.close();
	                p.waitFor();
	    	} catch (Exception e) {
                        return 0;
		}
        return 1;
    }*/
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
