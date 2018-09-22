/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.sso;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

/**
 * 
 * @author lele
 */
public class Post {

    public Post() throws IOException {
        post001();
    }
    
    public void post001() throws MalformedURLException, IOException{
        // https://login.eveonline.com/oauth/authorize/?response_type=code&redirect_uri=https%3A%2F%2F3rdpartysite.com%2Fcallback&client_id=3rdpartyClientId&scope=characterContactsRead%20characterContactsWrite&state=uniquestate123
        /*
        https://login.eveonline.com/oauth/authorize/
        ?response_type=code&
        redirect_uri=https%3A%2F%2F3rdpartysite.com%2Fcallback&
        client_id=3rdpartyClientId&
        scope=characterContactsRead%20characterContactsWrite&
        state=uniquestate123
        
        */
        
        String url = "https://login.eveonline.com/oauth/authorize";
        String response_type ="?response_type=code&";
        String redirect_uri="redirect_uri=http://localhost/&";
        String client_id="client_id=XXXXXXXXXXXXXXXXXXXX";
        String scope="scope=characterSkillsRead&";
        String state="state=uniquestate123";
        
        String httpsURL = url + response_type + redirect_uri + client_id + scope + state;
        
 
    }
    
    public void example002() throws MalformedURLException, IOException{
        String httpsURL = "https://your.https.url.here/";
        URL myUrl = new URL(httpsURL);
        HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String inputLine;

        while ((inputLine = br.readLine()) != null) {
            System.out.println(inputLine);
        }

        br.close();
        }        
    
    public void example001() throws UnsupportedEncodingException, MalformedURLException, IOException {
        String httpsURL = "https://www.abcd.com/auth/login/";

        String query = "email="+URLEncoder.encode("abc@xyz.com","UTF-8"); 
        query += "&";
        query += "password="+URLEncoder.encode("abcd","UTF-8") ;

        URL myurl = new URL(httpsURL);
        HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
        con.setRequestMethod("POST");

        con.setRequestProperty("Content-length", String.valueOf(query.length())); 
        con.setRequestProperty("Content-Type","application/x-www-form-urlencoded"); 
        con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0;Windows98;DigExt)"); 
        con.setDoOutput(true); 
        con.setDoInput(true); 

        DataOutputStream output = new DataOutputStream(con.getOutputStream());  


        output.writeBytes(query);

        output.close();

        DataInputStream input = new DataInputStream( con.getInputStream() ); 

        for( int c = input.read(); c != -1; c = input.read() ) 
        System.out.print( (char)c ); 
        input.close(); 

        System.out.println("Resp Code:"+con .getResponseCode()); 
        System.out.println("Resp Message:"+ con .getResponseMessage());         

    }
    /*
    https://login.eveonline.com/oauth/authorize/?response_type=code&
        redirect_uri=https%3A%2F%2F3rdpartysite.com%2Fcallback&
        client_id=3rdpartyClientId&
        scope=characterContactsRead%20characterContactsWrite&
        state=uniquestate123
    https://login.eveonline.com/oauth/authorize
    */
    }

