import java.util.ArrayList;

public class Main {

    public static Contador c = new Contador();

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>()
        {{
            add(-7);
            add(-3);
            add(-2);
            add(5);
            add(7);
            add(-10);
            add(10);
            add(4);
            add(1);
            add(-9);
            add(-4);
            add(8);
        }};

        ArrayList<Integer> subarray = existsSubarrayWithSumZero(nums);

        System.out.println(subarray + " " + c.getCounter());

        c = new Contador();

        ArrayList<ArrayList<Integer>> allSubarrays = findAllSubarraysWithSumZero(nums);

        System.out.println(allSubarrays + " " + c.getCounter());
        
    }

    public static ArrayList<Integer> existsSubarrayWithSumZero(ArrayList<Integer> nums) {
        ArrayList<Integer> subarray = new ArrayList<>();

        if (findSubarray(nums, subarray, 0, 0)) {
            return subarray;
        }

        return new ArrayList<>();

        }

    private static boolean findSubarray(ArrayList<Integer> nums, ArrayList<Integer> subarray, int start, int currentSum) {
        if (currentSum == 0 && !subarray.isEmpty()) {
            return true;
        }

        for (int i = start; i < nums.size(); i++) {
            c.add(1);
            subarray.add(nums.get(i));
            if (findSubarray(nums, subarray, i + 1, currentSum + nums.get(i))) {
                return true;
            }
            subarray.remove(subarray.size() - 1);
        }

        return false;
    }


    public static ArrayList<ArrayList<Integer>> findAllSubarraysWithSumZero(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> allSubarrays = new ArrayList<>();
        findAllSubarrays(nums, new ArrayList<>(), 0, 0, allSubarrays);
        return allSubarrays;
    }

    private static void findAllSubarrays(ArrayList<Integer> nums, ArrayList<Integer> subarray, int start, int currentSum, ArrayList<ArrayList<Integer>> allSubarrays) {
        if (currentSum == 0 && !subarray.isEmpty()) {
            allSubarrays.add(new ArrayList<>(subarray));
        }

        for (int i = start; i < nums.size(); i++) {
            c.add(1);
            subarray.add(nums.get(i));
            findAllSubarrays(nums, subarray, i + 1, currentSum + nums.get(i), allSubarrays);
            subarray.remove(subarray.size() - 1);
        }
    }
}