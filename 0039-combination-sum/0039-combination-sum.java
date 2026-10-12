class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        find(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void find(int[] coins, int target, int idx,
                     List<Integer> wallet,
                     List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(wallet));
            return;
        }
        for (int i = idx; i < coins.length; i++) {
            if (coins[i] <= target) {
                wallet.add(coins[i]);
                find(coins, target - coins[i], i, wallet, ans);
                wallet.remove(wallet.size() - 1);
            }
        }
    }
}
