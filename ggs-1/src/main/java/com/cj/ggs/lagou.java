package com.cj.ggs;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lagou {


    public void getInfo() {

        String hour = DateUtil.getNow();
        System.out.println(hour);

//        String url = "https://www.lagou.com/jobs/positionAjax.json?city=%E8%8B%8F%E5%B7%9E&needAddtionalResult=false";
        String url = "https://www.lagou.com/jobs/positionAjax.json?needAddtionalResult=false";


        Jedis jedis = JedisUtil.getJedis();
        int num = 100;
        if(jedis.exists("lagou-num")){
            num = Integer.parseInt(jedis.get("lagou-num"));
        }

        String key = "苏州 java";
        List<String> keys = new ArrayList<String>();
        if(jedis.exists("lagou-key")){
            keys = jedis.lrange("lagou-key", 0 ,-1);
        } else {
            keys.add(key);
        }


        for(int i=1; i<num; i++){
            Map params = new HashMap();
            params.put("first", i>1 ? false : true);
            params.put("pn", i);

            for(String key1 : keys){
                params.put("kd", key1);
                String ret = HttpClientUtil.doPost(url, params);
                jedis.rpush("jobs-lagou-" + hour + "-" + key1 , ret);

            }
        }

    }

}
