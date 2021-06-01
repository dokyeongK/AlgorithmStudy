package com.algorithmstudy.leetcode.programmers.dp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ChuseokTraffic {
    public int solution(String[] lines) {
        int answer = Integer.MIN_VALUE;
        int n = lines.length;

        LocalDate[] date = new LocalDate[n];
        LocalTime[] completeTime = new LocalTime[n];
        int[] processingTime = new int[n];
        LocalTime[] startTime = new LocalTime[n];
        Map<LocalTime, LocalTime> timeMap = new TreeMap<>();

//        for (int i = 0; i < n; i++) {
//            String[] temp = lines[i].split(" ");
//            date[i] = LocalDate.parse(temp[0]);
//            completeTime[i] = LocalTime.parse(temp[1], DateTimeFormatter.ISO_LOCAL_TIME);
//            StringBuilder temp2 = new StringBuilder(temp[2]);
//            temp2.deleteCharAt(temp2.length()-1);
//            processingTime[i] = (int) (Double.parseDouble(temp2.toString())*1000);
//            startTime[i] = completeTime[i].minusNanos((long) (processingTime[i]*Math.pow(10, 6)) - (long) Math.pow(10, 6));
//            timeMap.put(startTime[i], completeTime[i]);
//        }
        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];
        for (int i = 0; i < n; i++) {
            String[] temp = lines[i].split(" ");
            String[] temp2 = temp[1].split(":");
            endTimes[i] = 1000*((Integer.parseInt(temp2[0])*60*60) + (Integer.parseInt(temp2[1])*60));
            endTimes[i] += (int) (Double.parseDouble(temp2[2])*1000);
            StringBuilder temp3 = new StringBuilder(temp[2]);
            temp3.deleteCharAt(temp3.length()-1);
            processingTime[i] = (int) (Double.parseDouble(temp3.toString())*1000);
            startTimes[i] = endTimes[i] - processingTime[i] + 1;
        }

        for (int i = 0; i < lines.length; i++) {
            int count = 1;
            for (int j = i+1; j < lines.length; j++) {
                if (startTimes[j] <= endTimes[i] + 1000) count++;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
