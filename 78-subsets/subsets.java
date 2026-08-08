class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> finalans = new ArrayList<>(); 
        for(int i = 0; i <(1<< n) ; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0 ; j<nums.length; j++){
                if(((i>>j)&1)==1){
                    temp.add(nums[j]);
                }
            }
            finalans.add(temp);
        }
        return finalans;  
    }
}