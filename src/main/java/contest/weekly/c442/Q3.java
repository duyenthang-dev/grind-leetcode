package contest.weekly.c442;

public class Q3 {
    // approach: simulate theo dữ kiện và yêu cầu đề bài
    public long minTime(int[] skill, int[] mana) {
        int m = mana.length;
        int n = skill.length;

        long[] wizardEndTimes = new long[n];
        for (int i =0; i < m; i++) {
            int[] portion = new int[n];
            // cal portion each round
            for (int j =0; j < n; j++) {
                portion[j] = skill[j] * mana[i]; 
            }

            long startTime =0;
            long t = 0;
            // ensure  timing must be synchronized so that each wizard begins working on a potion exactly when it arrives. ​
            // phải đảm bảo start time sao cho khi wizard j bắt đầu làm thì các wizard trc đó phải xong rồi
            /*
             * Ví dụ  var skill = new int[] {1,3,4};
             * var mana = new int[] {2,3,3,3};
             * portion[] = {3, 9, 12}
             * portion	start	w0	w1	w2
                *   0	0	    2	8	16        
                *   1	2	    5	14	26
                *       3	    6   15  27
                *       4	    7	16	28
                *       5	    8	17	29
                -> Round 2:
                - start_for_w0 = wizardEndTimes[0] - t = 2 - 0 = 2 -> max = 2
                - start_for_w1 = wizardEndTimes[1] - t = 8 - (0 + 3) = 5 -> max = 5
               ...
                -> loop thru wizardEndTimes previous, tìm max để đảm bảo các wizard có thể hoàn thành lần chế tạo tiếp (t +=
                 portion[j])
             */
            for (int j =0; j < n; j++) {
                startTime = Math.max(startTime, wizardEndTimes[j] - t);
                t += portion[j];
            }

            t = startTime;

            // update new endtime
            for (int j =0; j < n; j++) {
                wizardEndTimes[j] = t + portion[j];
                t = wizardEndTimes[j];
            }

        }
        return wizardEndTimes[n - 1];
        
    }
    public static void main(String[] args) {
        var sol = new Q3();
        var skill = new int[] {1,3,4};
        var mana = new int[] {2,3,3,3};
        System.out.println(sol.minTime(skill, mana));   
    }
}
