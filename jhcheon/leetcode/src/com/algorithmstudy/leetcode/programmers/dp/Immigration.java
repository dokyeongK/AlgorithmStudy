package com.algorithmstudy.leetcode.programmers.dp;

import sun.reflect.generics.tree.Tree;

import java.util.*;

//입국심사
public class Immigration {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long max = (long) n * (long) times[0];
        long min = 1;
        long answer = max;

        while (min <= max) {
            long mid = (min + max) / 2;
            long available = getTime(times, mid);
            if (available < n) min = mid + 1;
            else {
                answer = mid;
                max = mid - 1;
            }
        }
        return answer;
    }

    public long getTime(int[] times, long time) {
        long sum = 0;
        for (int i = 0; i < times.length; i++) {
            sum += (int) (time / times[i]);
        }
        return sum;
    }


    public long solution_time_limited(int n, int[] times) {
        long answer = 0;
        int[] cloneTimes = times.clone();
//        Arrays.sort(cloneTimes);

        TreeMap<Long, ArrayList<TimeState>> tsMap = new TreeMap<>();
        for (int i = 0; i < cloneTimes.length; i++) {
            if (tsMap.containsKey((long) cloneTimes[i])) {
                tsMap.get((long) cloneTimes[i]).add(new TimeState(i, cloneTimes[i]));
            } else {
                ArrayList<TimeState> temp = new ArrayList<>();
                temp.add(new TimeState(i, cloneTimes[i]));
                tsMap.put((long) cloneTimes[i], temp);
            }

        }

        int tempN = n;
        long curTime = 0;

        while (tempN != 0) {
            System.out.println(tsMap);
            Map.Entry<Long, ArrayList<TimeState>> entry = tsMap.firstEntry();
            ArrayList<TimeState> intervalList = entry.getValue();
            TimeState ts = intervalList.get(0);
            curTime = entry.getKey();
            tempN--;
            int interval = ts.interval;
            long nextTime = entry.getKey() + interval;

            if (tsMap.containsKey(nextTime)) {
                ArrayList<TimeState> temp = tsMap.get(nextTime);
                temp.add(ts);
                temp.sort(null);
                tsMap.replace(nextTime, temp);
            } else {
                ArrayList<TimeState> temp = new ArrayList<>();
                temp.add(ts);
                tsMap.put(nextTime, temp);
            }
            intervalList.remove(0);
            if (intervalList.isEmpty()) tsMap.remove(entry.getKey());
            else tsMap.replace(entry.getKey(), intervalList);
        }
        answer = curTime;
        return answer;
    }

    class TimeState implements Comparable<TimeState> {
        int idx;
        int interval;

        public TimeState(int idx, int interval) {
            this.idx = idx;
            this.interval = interval;
        }

        @Override
        public String toString() {
            String str = "{idx=" + idx + ", interval="+interval + "}";
            return str;
        }
        @Override
        public int compareTo(TimeState timeState) {
            if (this.interval > timeState.interval) return 1;
            else return -1;
        }
    }


//    public long solution_backup(int n, int[] times) {
//        long answer = 0;
//        int[] cloneTimes = times.clone();
//        Arrays.sort(cloneTimes);
//
//        TreeMap<Long, ArrayList<Long>> tsMap = new TreeMap<>();
//        for (int i = 0; i < cloneTimes.length; i++) {
//            ArrayList<Long> temp = new ArrayList<>();
//            temp.add((long) cloneTimes[i]);
//            tsMap.put((long) cloneTimes[i], temp);
//        }
//
//        int tempN = n;
//        long curTime = 0;
//
//        while (tempN != 0) {
//            System.out.println(tsMap);
//            Map.Entry<Long, ArrayList<Long>> entry = tsMap.firstEntry();
//            ArrayList<Long> intervalList = entry.getValue();
//            curTime = entry.getKey();
//            tempN--;
//            long interval = intervalList.get(0);
//            long nextTime = entry.getKey() + interval;
//
//            if (tsMap.containsKey(nextTime)) {
//                ArrayList<Long> temp = tsMap.get(nextTime);
//                temp.add(interval);
//                temp.sort(null);
//                tsMap.replace(nextTime, temp);
//            } else {
//                ArrayList<Long> temp = new ArrayList<>();
//                temp.add(interval);
//                tsMap.put(nextTime, temp);
//            }
//            intervalList.remove(0);
//            if (intervalList.isEmpty()) tsMap.remove(entry.getKey());
//            else tsMap.replace(entry.getKey(), intervalList);
//        }
//        answer = curTime;
//        return answer;
//    }


}
