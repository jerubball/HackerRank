import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/**
 * HackerRank Algorithms Strings 25
 * https://www.hackerrank.com/challenges/maximum-palindromes/problem
 * @author Hasol
 */
 /*
public class Solution {
    static final int MODULO = 1000000007;
    static final BigInteger BIGMODULO = BigInteger.valueOf(MODULO);
    static final int ALPHABET = 26;
    static String str = null;
    // Return the answer for this query modulo 1000000007.
    public static int answerQuery(int l, int r) {
        String s = str.substring(l-1, r);
        int[] f = frequency(s); // frequency list
        int[] even = new int[f.length]; // even flooring
        int odd = 0; // number of odd frequencies
        int count = 0; // number of nonzero frequencies
        for (int i=0; i<f.length; i++) {
            if (f[i] > 0)
                count++;
            if (f[i] % 2 == 0)
                even[i] = f[i];
            else {
                even[i] = f[i] - 1;
                odd++;
            }
        }
        if (count == 1) // escape for single character string
            return 1;
        int sum = 0;
        long product = 1;
        for (int i: even) { // half all even frequencies for half of palindrome string
            int j = i/2;
            sum += j;
            if (j > 1) { // divisor for permutation of repeated letters
                product *= BigInteger.valueOf(modFact(j, MODULO)).modInverse(BIGMODULO).intValue();
                product %= MODULO;
            }
        }
        product *= modFact(sum, MODULO);
        product %= MODULO;
        if (odd > 1) {
            product *= odd;
            product %= MODULO;
        }
        return (int)product;
    }
    
// Returns largest power of p that divides n! 
    static int largestPower(int n, int p) { 
        // Initialize result 
        int x = 0; 
  
        // Calculate x = n/p + n/(p^2) + n/(p^3) + .... 
        while (n > 0) { 
            n /= p; 
            x += n; 
        } 
        return x; 
    } 
  
// Utility function to do modular exponentiation. 
// It returns (x^y) % p 
    static int power(int x, int y, int p) { 
        int res = 1; // Initialize result 
        x = x % p; // Update x if it is more than or 
        // equal to p 
        while (y > 0) { 
            // If y is odd, multiply x with result 
            if (y % 2 == 1) { 
                res = (res * x) % p; 
            } 
  
            // y must be even now 
            y = y >> 1; // y = y/2 
            x = (x * x) % p; 
        } 
        return res; 
    } 
  
// Returns n! % p 
    static int modFact(int n, int p) { 
        if (n >= p) { 
            return 0; 
        } 
  
        int res = 1; 
  
        // Use Sieve of Eratosthenes to find all primes 
        // smaller than n 
        boolean isPrime[] = new boolean[n + 1]; 
        Arrays.fill(isPrime, true); 
        for (int i = 2; i * i <= n; i++) { 
            if (isPrime[i]) { 
                for (int j = 2 * i; j <= n; j += i) { 
                    isPrime[j] = false; 
                } 
            } 
        } 
  
        // Consider all primes found by Sieve 
        for (int i = 2; i <= n; i++) { 
            if (isPrime[i]) { 
                // Find the largest power of prime 'i' that divides n 
                int k = largestPower(n, i); 
  
                // Multiply result with (i^k) % p 
                res = (res * power(i, k, p)) % p; 
            } 
        } 
        return res; 
    }
    static int[] frequency(String s) {
        int[] freq = new int[ALPHABET];
        for (char c: s.toCharArray())
            freq[c-'a']++;
        return freq;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        str = bufferedReader.readLine();
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i=0; i<q; i++) {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int l = Integer.parseInt(firstMultipleInput[0]);
                int r = Integer.parseInt(firstMultipleInput[1]);
                int result = answerQuery(l, r);
                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
    static class Solution1 {
        static int answerQuery(int l, int r) {
            String s = str.substring(l-1, r);
            int[] f = frequency(s); // frequency list
            int[] even = new int[f.length]; // even flooring
            int odd = 0; // number of odd frequencies
            for (int i=0; i<f.length; i++)
                if (f[i] % 2 == 0)
                    even[i] = f[i];
                else {
                    even[i] = f[i] - 1;
                    odd++;
                }
            long sum = 0;
            BigInteger divisor = BigInteger.ONE;
            for (int i: even) { // half all even frequencies for half of palindrome string
                int j = i/2;
                sum += j;
                if (j > 1) // divisor for permutation of repeated letters
                    divisor = divisor.multiply(factorial (j));
            }
            BigInteger dividend = factorial(sum);
            BigInteger quotient = dividend.divide(divisor);
            if (odd > 1)
                quotient = quotient.multiply(BigInteger.valueOf(odd));
            return quotient.remainder(BigInteger.valueOf(MODULO)).intValue();
        }
        static BigInteger factorial(long l) {
            BigInteger val = BigInteger.ONE;
            for (long i=2l; i<=l; i++)
                val = val.multiply(BigInteger.valueOf(i));
            return val;
        }
    }
    static class Solution2 {
        static HashMap<Integer,Integer> modInvMap = null;
        static int answerQuery(int l, int r) {
            String s = str.substring(l-1, r);
            int[] f = frequency(s); // frequency list
            int[] even = new int[f.length]; // even flooring
            int odd = 0; // number of odd frequencies
            for (int i=0; i<f.length; i++)
                if (f[i] % 2 == 0)
                    even[i] = f[i];
                else {
                    even[i] = f[i] - 1;
                    odd++;
                }
            long sum = 0;
            long product = 1;
            modInvMap = new HashMap<>();
            for (int i: even) { // half all even frequencies for half of palindrome string
                int j = i/2;
                sum += j;
                if (j > 1) { // divisor for permutation of repeated letters
                    product *= modInverseFactorial(j);
                    product %= MODULO;
                    / *
                    for (int k=2; k<=j; k++) {
                        int v;
                        if (modInvMap.contains(k))
                            v = modInvMap.get(k);
                        else {
                            v = BigInteger.valueOf(k).modInverse(BIGMODULO).intValue();
                            modInvMap.put(k, v);
                        }
                        product *= v;
                        product %= MODULO;
                    }
                    for (int k=2; k<=j; k++) {
                        product *= BigInteger.valueOf(k).modInverse(BIGMODULO).intValue();
                        product %= MODULO;
                    }
                    * /
                }
            }
            for (int k=2; k<=sum; k++) {
                product *= k;
                product %= MODULO;
            }
            if (odd > 1) {
                product *= odd;
                product %= MODULO;
            }
            return (int)product;
        }
        static int modInverseFactorial(int l) {
            if (l == 1)
                return 1;
            if (modInvMap.containsKey(l))
                return modInvMap.get(l);
            long p = modInverseFactorial(l-1);
            p *= BigInteger.valueOf(l).modInverse(BIGMODULO).intValue();
            p %= MODULO;
            modInvMap.put(l, (int)p);
            return (int)p;
        }
    }
}
*/

class Scan
{
    private byte[] buf=new byte[1024];
    private int index;
    private InputStream in;
    private int total;
    public Scan()
    {
        in=System.in;
    }
    public int scan()throws IOException
    {
        if(total<0)
        throw new InputMismatchException();
        if(index>=total)
        {
            index=0;
            total=in.read(buf);
            if(total<=0)
            return -1;
        }
        return buf[index++];
    }
    public int scanInt()throws IOException
    {
        int integer=0;
        int n=scan();
        while(isWhiteSpace(n))
        n=scan();
        int neg=1;
        if(n=='-')
        {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n))
        {
            if(n>='0'&&n<='9')
            {
                integer*=10;
                integer+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        return neg*integer;
    }
    public double scanDouble()throws IOException
    {
        double doub=0;
        int n=scan();
        while(isWhiteSpace(n))
        n=scan();
        int neg=1;
        if(n=='-')
        {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n)&&n!='.')
        {
            if(n>='0'&&n<='9')
            {
                doub*=10;
                doub+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        if(n=='.')
        {
            n=scan();
            double temp=1;
            while(!isWhiteSpace(n))
            {
                if(n>='0'&&n<='9')
                {
                    temp/=10;
                    doub+=(n-'0')*temp;
                    n=scan();
                }
                else throw new InputMismatchException();
            }
        }
        return doub*neg;
    }
    public String scanString()throws IOException
    {
        StringBuilder sb=new StringBuilder();
        int n=scan();
        while(isWhiteSpace(n))
        n=scan();
        while(!isWhiteSpace(n))
        {
            sb.append((char)n);
            n=scan();
        }
        return sb.toString();
    }
    private boolean isWhiteSpace(int n)
    {
        if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
        return true;
        return false;
    }
} 
public class GFG {
    static long fac[] = new long[50001];
    static int m = 1000000007;
    public static void main(String args[]) throws IOException
    {
        fact();
        Scan s1 = new Scan();
        StringBuilder sb = new StringBuilder();
        String s = s1.scanString();
        int n=s.length();
        int ar[][]=new int[26][n];
        ar[s.charAt(0)-'a'][0]=1;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<26;j++)
            {
                ar[j][i]=ar[j][i-1];
            }
            ar[s.charAt(i)-'a'][i]++;
        }
//        for(int p[]:ar)
//        {
//            for(int y:p)
//                System.out.print(y+" ");
//            System.out.println("");
//        }
        int q = s1.scanInt();
        while(q--!=0)
        {
            int l = s1.scanInt()-1;
            int r = s1.scanInt()-1;
            long count=0;
            long counte=0;
            long repeat=1;
            ArrayList<Long> fe = new ArrayList<>();
            for(int i=0;i<26;i++)
            {
                int temp=0;
                if(l>0)
                {
                    temp=ar[i][r]-ar[i][l-1];
                }
                else
                temp=ar[i][r];
              //  System.out.println("temp "+temp);
                if(temp%2!=0){
                count++;
                counte+=temp-1;
                }
                else{
                counte+=temp;
                }
                if(temp>1)
                {
                    fe.add(power(fac[temp/2], m-2, m));
                }
            }
            long ans=(fac[(int)(counte/2)])%m;
            if(count>0)
            {
                ans=(ans*(count%m))%m;
            }
            for(int i=0;i<fe.size();i++)
            {
                ans=(ans*(fe.get(i)))%m;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static void fact()
    {
        int n=50000;
        int m=1000000007;
        fac[0]=1;
        fac[1]=1;
        for(int i=2;i<=n;i++)
        {
            fac[i]=(fac[i-1]*(long)i)%m;
        }
    }
    static long power(long x, int y, int m)  
    { 
        if (y == 0) 
            return 1; 
          
        long p = power(x, y / 2, m) % m; 
        p = (p * p) % m; 
      
        if (y % 2 == 0) 
            return p; 
        else
            return (x * p) % m; 
    } 
}
