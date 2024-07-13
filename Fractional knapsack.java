class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
class Solution {
    class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            double r1 = (double) (a.value) / (double) (a.weight);
            double r2 = (double) (b.value) / (double) (b.weight);

            if (r1 < r2) return 1;
            else if (r1 > r2) return -1;
            else return 0;
        }
    }

    double fractionalKnapsack(int w, Item arr[], int n) {
        // Sort the array on the basis of value/weight
        Arrays.sort(arr, new ItemComparator());

        int currWt = 0;
        double finalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (currWt + arr[i].weight <= w) {
                currWt += arr[i].weight;
                finalValue += arr[i].value;
            } else {
                int remain = w - currWt;
                finalValue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
                break;
            }
        }
        return finalValue;
    }
}
