class Solution {
    public int scheduleCourse(int[][] courses) {
        int n=courses.length;
        Arrays.sort(courses, (a,b) -> a[1]-b[1]);
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        int totalTime=0;

        for(int i=0 ; i<n; i++){
            int duration=courses[i][0];
            int deadline=courses[i][1];
            if(duration>deadline)  continue;
            if(totalTime+duration<=deadline){
                totalTime+=duration;
                maxHeap.offer(duration);
            }
            else if(maxHeap.size()>0 && maxHeap.peek()>duration ){
                   int pollDur=maxHeap.poll();
                   totalTime-=pollDur;
                   totalTime+=duration;
                   maxHeap.offer(duration);
            }

            
            
            
         
        }
        return maxHeap.size();
    }
}