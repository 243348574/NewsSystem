package org.tian.news.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    /**
     * 根据地址获取链接对象
     * @param url
     * @return HttpURLConnection
     * @throws IOException
     */
    public static HttpURLConnection getConnection(String url) throws IOException {
        URL realUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        return connection;
    }

    /**
     * 获取链接响应内容
     * @param connection
     * @return
     * @throws IOException
     */
    public static String getConnectionResponse(HttpURLConnection connection) throws IOException {
        String response = "";
        if (connection.getResponseCode() == 200) {
            InputStream is = connection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // 10MB的缓存
            byte[] buffer = new byte[10485760];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            response = baos.toString();
        }
        return response;
    }


}
