import java.util.Scanner;

public class groupSum {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("����Ŀ��ֵ");
		int target = scanner.nextInt();
		System.out.println("���������е�Ԫ����:");
		int [] nums = new int[scanner.nextInt()];
		System.out.println("������ֵ");
		for (int i = 0; i < nums.length; i++) {
			nums[i]=scanner.nextInt();
		}
		System.out.println(groupSum(0, nums, target));
	}

	public static  boolean groupSum(int start, int[] nums, int target) {
		if(start>=nums.length)	
		return false;
		if(nums[start]==target)
			return true;
		else if(nums[start]<target){
			if(groupSum(start+1,nums,target-nums[start]))
				return true;
			else return(groupSum(start+1,nums,target));
		}
		else{
			return groupSum(start+1,nums,target);
	}
	}

}