class Solution {
  public int kadane(int[] A,int n)
  {
    int best=A[0],sum=A[0];
    for(int i=1;i<n;i++)
    {
      sum=Math.max(sum+A[i],A[i]);
      if(best<sum)
        best=sum;
    }
    return best;
  }
  public int reverseKadane(int[] A,int n)
  {
    int sum=0;
    for(int i=0;i<n;i++)
    {
      sum+=A[i];
      A[i]=-A[i];
    }
    if(sum+kadane(A,n)==0)return Integer.MIN_VALUE;

    return (sum+kadane(A,n));
  }
    public int maxSubarraySumCircular(int[] A) {
      int n=A.length;
      if(n==1)
      return A[0];
      return Math.max(kadane(A,n),reverseKadane(A,n));
    }
  }