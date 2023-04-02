//package com.soulbrain.cicd.soulbrain.openapi;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.nio.charset.StandardCharsets;
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//public class ElectricCarChargingStationExample {
//    public static void main(String[] args) throws IOException {
//        String apiUrl = "https://www.yuseong.go.kr/ys_api/ys_api/getPbctltSttusList/?";
//        String queryParams =  "&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=1";
//        queryParams += "&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=10";
//        queryParams += "&" + URLEncoder.encode("addr", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("대전광역시", StandardCharsets.UTF_8);
//        queryParams += "&" +  "rstTy=json";
//
//        URL url = new URL(apiUrl + queryParams);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type", "application/json");
//        System.out.println("Response code: " + conn.getResponseCode());
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        String line;
//        StringBuffer response = new StringBuffer();
//        while ((line = br.readLine()) != null) {
//            response.append(line);
//        }
//        br.close();
//
//        System.out.println("API 주소 URL : " + apiUrl + queryParams);
//        System.out.println("로그체크 " + conn.getResponseCode());
//
//
//        JsonParser parser = new JsonParser();
//        JsonObject jsonObj = parser.parse(response.toString()).getAsJsonObject();
//        System.out.println("jsonObj : " + jsonObj);
//        JsonObject bodyObj = jsonObj.getAsJsonObject("body");
//        System.out.println("bodyObj" + bodyObj);
//
//        JsonArray itemArr = bodyObj.getAsJsonArray("items");
//
//        for (JsonElement item : itemArr) {
//            JsonObject obj = item.getAsJsonObject();
//            System.out.println("Toilet Name: " + obj.get("toilet_nm").getAsString());
//            System.out.println("Address: " + obj.get("addr").getAsString());
//            System.out.println();
//        }
//    }
//}
//
//class Station {
//    private String name;
//    private String status;
//
//    public Station(String name, String status) {
//        this.name = name;
//        this.status = status;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//}
//
