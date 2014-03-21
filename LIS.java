public static void main(String[] args) {
        
        // LIS is 4 i.e 3,4,6,7
        int a[]={5,3,4,8,6,7};                            
        
        //s[i] gives longest increasing subsequnce at index i i.e s[2]=2
        int s[]=new int[a.length];
        
        int maxlength=0;
        int index=0;
        
        //every element is itself has LIS of length 1
        for(int i=0;i<s.length;i++)
            s[i]=1;
            
        //compare every element with all of its predecessors, find one with value lower than current element
        // and its LIS becomes one more than its predecessor.
        for(int i=1;i<a.length;i++)
            for(int j=i;j>=1;j--)
            {
              if(a[j-1]<a[i])
              {
                  s[i]=1+s[j-1];
                  break;
                }
            }
            
        for(int i=0;i<s.length;i++)
        {
          if(s[i]>maxlength)
          {
              maxlength=s[i];
              index=i;
        }
        }

        System.out.println("Longest Subsequence is of length "+maxlength+" at index "+index);
    }
    
    
/*
  consider above exmaple {5,3,4,8,6,7}
  first for loop makes s[0]...s[5] all equal to 1.
  we start i=1 i.e 3 now j-1=0 and 5 is not less than 3 so s[1] remains 1.
  we move on to 4 and since 3<4 s[2]=s[1]+1 so s[2]=2 and this is how we find the LIS
  Complexity of this DP algo is O(n^2). It can be solved in O(nlogn).
*/
