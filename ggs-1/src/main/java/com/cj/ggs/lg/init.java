package com.cj.ggs.lg;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cj.ggs.HttpClientUtil;
import com.cj.ggs.lg.bean.Recity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class init {

    public static void main(String[] args) {
        
        
        initCity();
    }

    private static void initCity() {

        List cities = new ArrayList();

        String[] provinces = {"北京市", "天津市", "河北省", "山西省", "内蒙古自治区", "辽宁省", "吉林省","黑龙江省", "上海市", "江苏省", "浙江省", "安徽省", "福建省", "江西省", "山东省","河南省", "湖北省", "湖南省", "广东省", "广西壮族自治区", "海南省", "重庆市","四川省", "贵州省", "云南省", "**自治区", "陕西省", "甘肃省", "青海省", "宁夏回族自治区", "新疆维吾尔自治区", "台灣", "香港特别行>政区", "澳门特别行政区"};

        cities.addAll(Arrays.asList(provinces));





        String province = provinces[2];

        String pre = "jsonp_";


        String jsonp = pre + getJsonP(0);

        String url = "http://restapi.amap.com/v3/config/district?subdistrict=1&extensions=all&level=province&key=608d75903d29ad471362f8c58c550daf&s=rsv3&output=json&callback=" + jsonp + "&keywords=" + province;


        String re = HttpClientUtil.doGet(url);

        System.out.println(jsonp);
        System.out.println(jsonp);

        re = re.substring(jsonp.length()+1, re.length()-1);

        System.out.println(re);

        Recity recity = JSON.parseObject(re, new TypeReference<Recity>() {});

        System.out.println(recity.getInfocode());

    }

    private static int getJsonP(int jsonp) {

        if(jsonp==0){
            jsonp = 9999;
        }
        jsonp = jsonp + 1;
        if (jsonp > 99999){
            jsonp = 10000;
        }
        return jsonp;

    }


}
