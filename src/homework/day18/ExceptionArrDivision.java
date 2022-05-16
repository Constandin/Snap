package homework.day18;

public class ExceptionArrDivision {
    public static void main(String[] args) throws Exception {
        ExceptionArrDivision d = new ExceptionArrDivision();
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {0,2,3};
        try {
            for(int num: d.division(arr1,arr2)){
                System.out.println(num);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public int[] division (int[] arr1,int[] arr2) throws Exception {
        int[] arr3 = new int[Math.max(arr1.length,arr2.length)];
        for(int i=0;i<Math.max(arr1.length,arr2.length);i++){
            arr3[i] = arr1[i] / arr2[i];
        }
        return arr3;
    }
}
