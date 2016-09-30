/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.IOException;

/**
 *
 * @author jalfonzo
 */
public class Rest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClientProtocolException, IOException {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope("dev.*******.com", AuthScope.ANY_PORT),
                new UsernamePasswordCredentials("*****", "******"));

        DefaultHttpClient client = new DefaultHttpClient();
        client.setCredentialsProvider(credsProvider);

        String url = "http://dev.******.com:18081/path/to/service/id.xml";

        HttpGet get = new HttpGet(url);
        ResponseHandler<String> handler = new BasicResponseHandler();
        String resp = client.execute(get, handler);

        System.out.println(resp);
    }

}
