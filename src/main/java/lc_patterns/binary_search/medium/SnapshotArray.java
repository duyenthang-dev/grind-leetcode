package lc_patterns.binary_search.medium;

import java.util.ArrayList;
import java.util.List;

class SnapshotArray {

    class Pair {
        private int snapId;
        private int val;
        public Pair(int snapId, int val) {
            this.snapId = snapId;
            this.val = val;
        }
        public int getSnapId() {
            return this.snapId;
        }

        public int getVal() {
            return this.val;
        }
    }

    private List<List<Pair>> history;
    private int snap;

    public SnapshotArray(int length) {
        history = new ArrayList<>();
        for (int i =0; i < length; i++) {
            history.add(new ArrayList<>(List.of(new Pair(0, 0))));
        }
        snap = 0;
    }
    
    public void set(int index, int val) {
        List<Pair> snapInfo = history.get(index);
        if (snapInfo == null) {
            snapInfo = new ArrayList<>();
        }
        var pair = new Pair(snap, val);
        snapInfo.add(pair);
        history.set(index, snapInfo);
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        var arr = history.get(index);
        int l = 0, r = arr.size() - 1;
        int pos = 0;
        while(l <= r) {
            int mid = (l + r)/2;
            if (arr.get(mid).getSnapId() <= snap_id) {
                pos = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return arr.get(pos).getVal();
    }

    public static void main(String[] args) {
       String[] commands = {"SnapshotArray","snap","snap","set","snap","get","set","get","snap","get"};
        Object[][] arguments = {
            {1}, {}, {}, {0,4}, {}, {0,1}, {0,12}, {0,1}, {}, {0,3}
        };

        List<Object> output = new ArrayList<>();
        SnapshotArray obj = null;

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "SnapshotArray":
                    obj = new SnapshotArray((int) arguments[i][0]);
                    output.add(null);
                    break;
                case "set":
                    obj.set((int) arguments[i][0], (int) arguments[i][1]);
                    output.add(null);
                    break;
                case "snap":
                    output.add(obj.snap());
                    break;
                case "get":
                    output.add(obj.get((int) arguments[i][0], (int) arguments[i][1]));
                    break;
            }
        }

        System.out.println(output);
    }
}