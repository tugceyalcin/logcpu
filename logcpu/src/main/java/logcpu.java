import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class logcpu {

    private static final Logger logger = LogManager.getLogger(logcpu.class);

    public static void main (String[]args)
    {
        try {
            // We are running "dir" and "ping" command on cmd
            Process p1=  Runtime.getRuntime().exec("cmd.exe /c echo off");
            // Process p2 = Runtime.getRuntime().exec("cmd.exe /c @for /f \"skip=1\" %p in ('wmic cpu get loadpercentage') do @echo %p%");
            BufferedReader in = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            String bos = null;
            if((bos=in.readLine())!= null ){
                System.out.println(bos);
            }

        } catch (Exception e) {
            System.out.println("exception");
            e.printStackTrace();
        }

        while(true){

            try {
                // We are running "dir" and "ping" command on cmd
                //Process p1=  Runtime.getRuntime().exec("cmd.exe /c echo off");
                Process p1 = Runtime.getRuntime().exec("cmd.exe /c @for /f \"skip=1\" %p in ('wmic cpu get loadpercentage') do @echo %p%");
                BufferedReader in = new BufferedReader(new InputStreamReader(p1.getInputStream()));
                String bos = null;
                if((bos=in.readLine())!= null ){
                 //   System.out.println(bos);
                    logger.info(bos);
                }

            } catch (Exception e) {
                System.out.println(" exception");
                e.printStackTrace();
            }

        }
    }
}
