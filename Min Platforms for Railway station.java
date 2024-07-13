Brute force approach
class Solution{
    static int findPlatform(int arr[], int dep[], int n){
        int ans = 1;
        
        for(int i = 0; i <= n - 1; i++){
            int cnt = 1;
            for(int j = i + 1; j < n- 1; j++){
                if(arr[i] >= arr[j] && arr[i] <= dep[j] || arr[j] >= arr[i]  &&arr[j] <= dep[i]){
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }    
}

Optimal solution
Approach:  At first we need to sort both arrays. When the events will be sorted, it will be easy to track the count of trains that have arrived but not departed yet.
  The total platforms needed at one time can be found by taking the difference of arrivals and departures at that time and the maximum value of all times will be the final answer.
  If(arr[i]<=dep[j]) means if arrival time is less than or equal to the departure time then- we need one more platform. So increment count as well as increment i.
  If(arr[i]>dep[j]) means the arrival time is more than the departure time then- we have one extra platform which we can reduce. So decrement count but increment j. 
  Update the ans with max(ans, count) after each iteration of the while loop.

  public static int platformsNeeded(int arr[], int dep[], int n){
      int platforms = 1;
      int res = 1;

      int i = 1, j = 0;

      // Sort both the arrays
      Arrays.sort(arr);
      Arrays.sort(dep);
      while(i < n && j < n){
          if(arr[i] <= dep[j]){
            platforms++;
            i++;
          }else if(arr[i] > dep[j]){
            platforms--;
            j++;
          }

          if(platforms > res){
            res = platform;
          }
      }
      return res;
  }

