class Solution{
    
    int[] JobScheduling(Job arr[], int n){
        // Sort the arr wrt max profit
        Arrays.sort(arr, (a,b) -> (b.profit - a.profit));
        
        int profit = 0; int cnt = 0;
        int maxi = 0;
        
        // Find max deadline from entire arr 
        for(int i = 0; i < n; i++){
            if(arr[i].deadline > maxi){
                maxi = arr[i].deadline;
            }
        }
        
        
        // create result arr and initialize it with -1
        int res[] = new int[maxi + 1];
        for(int i = 1; i < res.length; i++){
            res[i] = -1;
        }
        
        
        for(int i = 0; i < n; i++){
            for(int j = arr[i].deadline; j > 0; j--){
                if(res[j] == -1){
                    res[j] = i;
                    cnt++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }
        
        int ans[] = new int[2];
        ans[0] = cnt;
        ans[1] = profit;
        return ans;
    }
}
