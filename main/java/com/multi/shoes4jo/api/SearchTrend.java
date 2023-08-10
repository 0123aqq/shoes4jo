package com.multi.shoes4jo.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api")
public class SearchTrend {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchTrend.class);

	@RequestMapping(value = "/searchtrend", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
    public String getSearchData(@RequestParam String keyword) throws Exception {
		logger.info("getSearchData() called");
		
    	String clientId = "JzcrBZHimsCICRuNqbzk"; // ���ø����̼��� Client ID
		String clientSecret = "9fgwNuy1pM"; // ���ø����̼��� Client Secret

        String apiUrl = "https://openapi.naver.com/v1/datalab/search";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        requestHeaders.put("Content-Type", "application/json");
        
        String today = LocalDate.now().toString();
        System.out.println("keyword: " + keyword);

        String requestBody = 
        "{\"startDate\":\"2017-01-01\"," +
        "\"endDate\": \"" + today + "\"," +
        "\"timeUnit\":\"month\"," +
        "\"keywordGroups\":[{\"groupName\":\"�ѱ�\"," + "\"keywords\":[\"�ѱ�\",\"korean\"]}," +
        "{\"groupName\":\"����\"," + "\"keywords\":[\"����\",\"english\"]}]," +
        "\"device\":\"pc\"," +
        "\"ages\":[\"1\",\"2\"]," +
        "\"gender\":\"f\"}";
        
        String responseBody = post(apiUrl, requestHeaders, requestBody);
        System.out.println(responseBody);
		return responseBody;
	}

	private static String post(String apiUrl, Map<String, String> requestHeaders, String requestBody) {
        HttpURLConnection con = connect(apiUrl);

        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(requestBody.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // ���� ����
                return readBody(con.getInputStream());
            } else {  // ���� ����
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API ��û�� ���� ����", e);
        } finally {
            con.disconnect(); // Connection�� ��Ȱ���� �ʿ䰡 ���� ���μ����� ���
        }
    }

    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL�� �߸��Ǿ����ϴ�. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("������ �����߽��ϴ�. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body, StandardCharsets.UTF_8);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API ������ �дµ� �����߽��ϴ�.", e);
        }
    }
}