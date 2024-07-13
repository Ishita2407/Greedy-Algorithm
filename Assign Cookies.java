class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Greedy soln

        // Sort the greed factor of children and cookie size
        Arrays.sort(g);
        Arrays.sort(s);

        // ptr for child's greed and another ptr for cookie size
        int i = 0, j = 0;
        int happyChild = 0;
        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                happyChild++;
                i++;
            }
            j++;
        }
        return happyChild;
    }
}
