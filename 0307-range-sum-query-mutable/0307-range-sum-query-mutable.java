class NumArray {
    int[] segTree;
    int n;

    public void buildSegTree(int i, int l, int r, int[] nums){
        if(l == r){
            segTree[i] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegTree(2*i+1, l, mid, nums);
        buildSegTree(2*i+2, mid+1, r, nums);
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }

    public NumArray(int[] nums) {
        n = nums.length;
        if(n == 0) return;
        segTree = new int[4*n];
        buildSegTree(0, 0, n-1, nums);
    }

    public void updateIndex(int index, int val, int i, int l, int r){
        if(l == r){
            segTree[i] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if(index <= mid){
            updateIndex(index, val, 2*i+1, l, mid);
        } else {
            updateIndex(index, val, 2*i+2, mid+1, r);
        }
        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }

    public int querySum(int start, int end, int i, int l, int r){
        if(l > end || r < start) return 0;

        if(l >= start && r <= end)
            return segTree[i];

        int mid = l + (r - l) / 2;
        return querySum(start, end, 2*i+1, l, mid) +
               querySum(start, end, 2*i+2, mid+1, r);
    }

    public void update(int index, int val) {
        if(n == 0) return;
        updateIndex(index, val, 0, 0, n-1);
    }

    public int sumRange(int left, int right) {
        if(n == 0) return 0;
        return querySum(left, right, 0, 0, n-1);
    }
}