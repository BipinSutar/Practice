package com.bipin.practice.hackerearrth._18Nov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class EventTimeinInt implements Comparable<EventTimeinInt> {
	int time;
	char eventType;

	EventTimeinInt(int time, char eventType) {
		this.time = time;
		this.eventType = eventType;
	}

	@Override
	public int compareTo(EventTimeinInt o) {
		return this.time - o.time;

	}

	@Override
	public String toString() {
		return "time = " + this.time + " type = " + this.eventType;
	}
}

public class UbonaTest {

	public static void main(String[] args) {
		getMaxPlatform();
	}

	public static void getMaxPlatform() {
		// String arrivals[] = { "1:00", "1:40", "1:50", "2:00", "2:15", "4:00"
		// };
		// String departurs[] = { "1:10", "3:00", "2:20", "2:30", "3:15", "6:00"
		// };
		int arrivals[] = {900, 940, 950, 1100, 1500, 1800};
		int departurs[] = {910, 1200, 1120, 1130, 1900, 2000};
		ArrayList<EventTimeinInt> al = new ArrayList<EventTimeinInt>();
		for (int i = 0; i < arrivals.length; i++) {
			al.add(new EventTimeinInt(arrivals[i], 'A'));
			al.add(new EventTimeinInt(departurs[i], 'D'));
		}
		Collections.sort(al);
		int platforcount = 0;
		int maxPltcount = Integer.MIN_VALUE;
		for (EventTimeinInt a : al) {
			System.out.println(a);
			if (a.eventType == 'A')
				platforcount++;
			else if (a.eventType == 'D')
				platforcount--;
			maxPltcount = (maxPltcount < platforcount)
					? platforcount
					: maxPltcount;
		}
		System.out.println(maxPltcount);

	}
	static long[] solve(int Q, int[][] Queries){
		TreeMap<Integer,Integer> tm = new TreeMap<>();
        TreeMap<Integer,Map<Integer,Integer>> tmr = new TreeMap<>();
        
        List<Integer> op = new ArrayList<>();
        int p = 0;
        for(int i = 0 ; i < Q ; i++){
            if(Queries[i][0]==1){
                p ++;
                tm.put(p, Queries[i][1]);
                if(!tmr.containsKey(Queries[i][1])){
                    tmr.put(Queries[i][1], new HashMap<>());
                }
                tmr.get(Queries[i][1]).put(p,0);

            }else if(Queries[i][0]==2){
                tmr.get(Queries[i][1]).remove(p);
                if(tmr.get(Queries[i][1]).isEmpty()){
                    tmr.remove(Queries[i][1]);
                }
                tm.remove(p);

            }else if(Queries[i][0]==3){
                int dis1 = Math.abs(tmr.firstKey()-Queries[i][1]);
                int dis2 = Math.abs(Queries[i][1]-tmr.lastKey());
                op.add(Math.max(dis1,dis2));

            }
        } 
        long ans[] = new long[op.size()];      
        for(int i = 0 ; i < ans.length ; i++){
            ans[i]=  op.get(i);
        }
        return ans;
	}

}
