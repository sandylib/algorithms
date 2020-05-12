public class PerfectSquare {
  public boolean isPerfectSquare(int num) {
    if(num < 2) return true;
    
    long l = 2, r = num / 2;
    while(l <= r){
        long mid = (l + (r - l) / 2);
        long guessedNo = mid * mid;
        if(guessedNo == num){
            return true;
        }
        else if(guessedNo < num){
            l = mid + 1;
        }
        else{
            r = mid - 1;
        }
    }
    return false;
}
  
}