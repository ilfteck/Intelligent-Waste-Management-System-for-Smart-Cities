package com.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;


/**
* @author Evan
* @version 创建时间：2024年2月7日 下午9:37:05
*/

public class BaiduUtil {
	
    /**
     * Obtain provincial information according to latitude and longitude
     * @param lon 
     * @param lat 
     * @param coordtype 
     * @return
     */
    public static Map<String, String> getCityByLonLat(String key, String lng, String lat) {
        String location = lat + "," + lng;
        try {
            //url
            String url = "http://api.map.baidu.com/reverse_geocoding/v3/?ak="+key+"&output=json&coordtype=wgs84ll&location="+location;
            String result = HttpClientUtils.doGet(url);
            JSONObject o = new JSONObject(result);
            Map<String, String> area = new HashMap<>();
			area.put("province", o.getJSONObject("result").getJSONObject("addressComponent").getString("province"));
			area.put("city", o.getJSONObject("result").getJSONObject("addressComponent").getString("city"));
			area.put("district", o.getJSONObject("result").getJSONObject("addressComponent").getString("district"));
			area.put("street", o.getJSONObject("result").getJSONObject("addressComponent").getString("street"));
            return area;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
	        * Get API access token
		* This token has a certain validity period. You need to manage it by yourself. When the token expires, you need to obtain it again.
		* @param AK-API Key obtained from Baidu Cloud official website
		* @param sk - Securet Key obtained from Baidu Cloud official website
		* @return assess_token
	     */
    public static String getAuth(String ak, String sk) {
        // Get token address
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type is a fixed parameter
                + "grant_type=client_credentials"
                // 2. Obtained from the official website API Key
                + "&client_id=" + ak
                // 3. Obtained from the official website Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // Open the connection between and URL
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // Gets all response header fields
            Map<String, List<String>> map = connection.getHeaderFields();
            // Iterate over all response header fields
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // Define a BufferedReader input stream to read the response to the URL
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * Return result example
             */
            System.err.println("result:" + result);
            org.json.JSONObject jsonObject = new org.json.JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("Failed to obtain token！");
            e.printStackTrace(System.err);
        }
        return null;
    }

}
