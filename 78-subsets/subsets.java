class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       /* int n = nums.length;
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
        return finalans;  */
      
      List<List<Integer>> outer = new ArrayList<>();

      outer.add(new ArrayList());

      for (int num : nums) {
          int n = outer.size();
          for (int i = 0; i < n; i++) {
              List<Integer> internal = new ArrayList<>(outer.get(i));
              internal.add(num);
              outer.add(internal);
          }
      }
          return outer;
      }
  }
  