package com.soulbrain.cicd.soulbrain.openapi.controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


@RestController
@RequestMapping("/api")
public class ApiController {


    @GetMapping("/v1")
    public StringBuffer openapi() {

        StringBuffer result = new StringBuffer();
        try {
            String apiUrl = "https://www.yuseong.go.kr/ys_api/ys_api/getPbctltSttusList/?";
            String queryParams = "&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=1";
            queryParams += "&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=10";
            queryParams += "&" + URLEncoder.encode("addr", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("대전광역시", StandardCharsets.UTF_8);
            queryParams += "&" + "rstTy=json";

            URL url = new URL(apiUrl + queryParams);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            System.out.println("v1 api : " + apiUrl + queryParams);

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;
//            result.append("<xmp>"); //XML 형식 출력시
            while ((returnLine = br.readLine())!=null) {
                result.append(returnLine + "\n");
            }
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return result + "</xmp>"; //xml 출력 형식
        return result;
    }


    //한전 전기차 API
    @GetMapping("/v2")
    public StringBuffer openapi2() {

        StringBuffer result = new StringBuffer();
        try {
            String service = "=aKEseb8DR13H90Wx4oNXUjjkvdhmhjFcB8Xp%2BcdolH4FPn5RNNMvWv8A6P7xszJAJaddq6tAQdPojLSB2gsEWg%3D%3D";
            String apiUrl = "https://api.odcloud.kr/api/EvInfoServiceV2/v1/getEvSearchList/?serviceKey" + service;
            String queryParams = "&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=1";
            queryParams += "&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=20";
//            queryParams += "&" + URLEncoder.encode("addr", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("대전광역시", StandardCharsets.UTF_8);
            queryParams += "&" + "rstTy=json";

            URL url = new URL(apiUrl + queryParams);
            System.out.println("v2 api : " + url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;
//            result.append("<xmp>"); //XML 형식 출력시
            while ((returnLine = br.readLine())!=null) {
                result.append(returnLine + "\n");
            }
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return result + "</xmp>"; //xml 출력 형식
        return result;
    }



    @GetMapping("/v3")
    public StringBuffer openapi3() {

        //https://www.yuseong.go.kr/ys_api/ys_api/getElctyChrstnSttusList/?
        // pageNo=1
        // &numOfRows=10
        // &rstTy=json

        StringBuffer result = new StringBuffer();
        try {
//            String service = "=aKEseb8DR13H90Wx4oNXUjjkvdhmhjFcB8Xp%2BcdolH4FPn5RNNMvWv8A6P7xszJAJaddq6tAQdPojLSB2gsEWg%3D%3D";
            String apiUrl = "https://www.yuseong.go.kr/ys_api/ys_api/getElctyChrstnSttusList/?";
            String queryParams = "&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=1";
            queryParams += "&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=30";
//            queryParams += "&" + URLEncoder.encode("addr", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("대전광역시", StandardCharsets.UTF_8);
            queryParams += "&" + "rstTy=json";

            URL url = new URL(apiUrl + queryParams);
            System.out.println("v3 api : " + url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;
//            result.append("<xmp>"); //XML 형식 출력시
            while ((returnLine = br.readLine())!=null) {
                result.append(returnLine + "\n");
            }
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return result + "</xmp>"; //xml 출력 형식
        return result;
    }
}

