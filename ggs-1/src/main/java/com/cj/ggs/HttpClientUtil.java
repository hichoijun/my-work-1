package com.cj.ggs;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.*;

public class HttpClientUtil {

    public static String doGet(String url) {
        //1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //2.生成一个get请求
        HttpGet httpget = new HttpGet(url);


        httpget.setHeader("Header", "Header");
        httpget.setHeader("Accept-Encoding", "gzip, deflate, sdch");
        httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpget.setHeader("Connection", "keep-alive");
        httpget.setHeader("Host", "restapi.amap.com");
        httpget.setHeader("Referer", "http://lbs.amap.com/fn/iframe/?id=3556");



        CloseableHttpResponse response = null;
        try {
            //3.执行get请求并返回结果
            response = httpclient.execute(httpget);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = null;
        try {
            //4.处理结果，这里将结果返回为字符串
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String doPost(String url, Map params){

        BufferedReader in = null;
        try {
            // 定义HttpClient
//            HttpClient client = new DefaultHttpClient();
            HttpClient client = HttpClients.createDefault();

            // 实例化HTTP方法
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));

            request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
            request.addHeader("Referer", "https://www.lagou.com/jobs/list_java?city=%E5%85%A8%E5%9B%BD&cl=false&fromSearch=true&labelWords=&suginput=");
            request.addHeader("Origin", "https://www.lagou.com");
            request.addHeader("Cookie", "user_trace_token=20180408230834-a01760a6-ba4d-4a3a-9ecc-50d1fc15fa53; JSESSIONID=ABAAABAACBHABBI4668492B0E2C252E4926E72F4028B17F; _ga=GA1.2.1606387373.1523200003; _gat=1; _gid=GA1.2.1850720465.1523200003; LGSID=20180408230842-b99913c3-3b3e-11e8-b740-5254005c3644; PRE_UTM=; PRE_HOST=; PRE_SITE=; PRE_LAND=https%3A%2F%2Fwww.lagou.com%2F; LGUID=20180408230842-b9991682-3b3e-11e8-b740-5254005c3644; index_location_city=%E5%85%A8%E5%9B%BD; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1523200004; TG-TRACK-CODE=index_search; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1523200020; LGRID=20180408230859-c3c74619-3b3e-11e8-b71c-525400f775ce; SEARCH_ID=b5b549337e204a9da076fec676605541");

            //设置参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));

                //System.out.println(name +"-"+value);
            }
            request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));

            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if(code == 200){    //请求成功
                in = new BufferedReader(new InputStreamReader(response.getEntity()
                        .getContent(),"utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }

                in.close();

                return sb.toString();
            }
            else{   //
                System.out.println("状态码：" + code);
                return null;
            }
        }
        catch(Exception e){
            e.printStackTrace();

            return null;
        }
    }

    public static void main(String[] args) {
        String url = "https://www.lagou.com/jobs/positionAjax.json?needAddtionalResult=false";

        Map params = new HashMap();
        params.put("first", false);
        params.put("pn", 20);

        params.put("kd", "苏州 java");
        String ret = HttpClientUtil.doPost(url, params);

        System.out.println(ret);
    }

}
