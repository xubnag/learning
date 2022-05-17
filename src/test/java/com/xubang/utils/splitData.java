package com.xubang.utils;

import com.alibaba.schedulerx.common.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/4/11 10:02 PM
 * @Description 数据分割转化工具类
 */
public class splitData {
    public static void main(String[] args) {
        String relationUserIds = "   ";
        List<Long> longs = splitDataConversion(relationUserIds);
        System.out.println(longs);
    }

    /**
     * 数据类型转化(终极版)
     *
     * @param data
     * @return
     */
    private static List<Long> splitDataConversion(String data) {
        if (StringUtils.isEmpty(data) || data.equals("") || data.contains(" ")) {
            return null;
        }
        //正则表达式：同时兼容中英文逗号
        String regex = ",|，";
        List<Long> collect = new ArrayList<>();
        try {
            collect = Arrays.stream(data.trim().split(regex)).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        } catch (Exception e) {
//            logger.warn("splitRelationUserIdsToList,data={},collect={}",data,collect);
            e.printStackTrace();
        }
        return collect;
    }






}


