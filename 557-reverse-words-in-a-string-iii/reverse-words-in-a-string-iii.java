class Solution {
    public String reverseWords(String s) {
        char [] arr=s.toCharArray();
        int i=0;
        int n=arr.length;


        while(i<n){
            int start=i;

            while(i<n && arr[i]!=' '){
                i++;
            }
            int left=start;
            int right=i-1;

            while(left<right){
char tmp=arr[left];
arr[left]=arr[right];
arr[right]=tmp;
left++;
right--;



            }

            i++;
        }
return new String(arr);

    }
}