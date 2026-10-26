class Solution {
    public int compress(char[] chars) {
        int i=0;
        int wr=0;

        while(i<chars.length){

char ch=chars[i];
int cnt=0;
while(i<chars.length && chars[i]==ch){
    i++;
    cnt++;

}
chars[wr++]=ch;
if(cnt>1){
String s=String.valueOf(cnt);

for(char c1:s.toCharArray()){
chars[wr++]=c1;


}




}



        }
        return wr;
    }
}