public class Consecutive34 {

  public int[] searchRange(int[] arr, int target) {
    int start = binarySearch(arr, target, 0, arr.length - 1);
    int count = -1;
    int[] ans = new int[2];

    // count the frequency of target
    for (int i : arr) {
      if (i == target) {
        count++;
      }
    }

    // if target element is not found
    if (start == -1) {
      ans[0] = -1;
      ans[1] = -1;
    } 
    else {
      // if target element is found
      ans[0] = start;
      ans[1] = start + count;
    }
    return ans;
  }

  public static int binarySearch(int[] arr, int target, int left, int right) {
    int result = -1;
    if (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) {
        while (mid >= 0 && arr[mid] == target) {
          mid--;
        }
        return mid + 1;
      } 
      else if (arr[mid] > target) {
        return binarySearch(arr, target, left, mid - 1);
      } 
      else {
        return binarySearch(arr, target, mid + 1, right);
      }
    }
    return -1;
  }
}
//  public int[] searchRange(int[] nums, int target) {
//         Stack<Integer> stk = new Stack<>();
//         int[] ans = new int[2];
//         for(int i = 0; i<nums.length; i++){
//             if(stk.isEmpty() && nums[i] == target){
//                 stk.push(nums[i]);
//                 ans[0] = i;
//             }
//             else if(nums[i] == target){
//                 stk.push(nums[i]);
//             }
//         }
//         if(stk.isEmpty()){
//             ans[0] = -1;
//             ans[1] = -1;
//         }
//         if(stk.size() > 1){
//             ans[1] = ans[0] + stk.size() -1;
//         }
//         else{
//             ans[1] = ans[0];
//         }
//         return ans;
//     }
