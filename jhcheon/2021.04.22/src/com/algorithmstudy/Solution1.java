package com.algorithmstudy;

import java.util.ArrayList;

public class Solution1 {
    public int solution(int[] A) {
        int answer = 0;
        int N = A.length;
        if (N <= 2) return 0;
        ArrayList<Integer> peakList = new ArrayList<>();

        //find peak of A.
        for (int i = 1; i < N - 1; ) {
            if (A[i-1] < A[i] && A[i+1] < A[i]) {
                peakList.add(i);
                i += 2;
            } else i++;
        }

        if (peakList.isEmpty()) return 0;

        int flagNum = peakList.size();
        int max = 0;
//        flagNum = (int) (Math.ceil(Math.sqrt(N)) > flagNum ? flagNum : Math.ceil(Math.sqrt(N)));
        int distance = peakList.get(peakList.size()-1) - peakList.get(0);
        flagNum = (int) (Math.sqrt(distance) + 1 > flagNum ? flagNum : Math.sqrt(distance) + 1);
        for (int i = flagNum; i > 0; i--) {
            int curFlagNum = 1;
            int curPeakIdx = 0;
            for (int j = 1; j < peakList.size(); j++) {
                if (curFlagNum == i) break;
                if (peakList.get(j) - peakList.get(curPeakIdx) >= i) {
                    curPeakIdx = j;
                    curFlagNum++;
                }
            }
            max = (curFlagNum >= max) ? curFlagNum : max;
            if (max == i) break;
        }
        answer = max;
        return answer;
    }

}

//reference
//https://github.com/BaeMinCheon/study-101/tree/master/Workspace/2020/06/26
