import java.util.Arrays;

class Folder2 {
    public static int V1(int n) {
        // no of digits
        int res = 0;
        while (n != 0) {
            res++;
            n = n / 10;
        }
        return res;
        // TC== Theta(d) where d is no of digits in input;
    }

    public static int V1_2(int n) {
        // no of digits by recursion
        if (n == 0) {
            return 0;
        }
        return 1 + V1_2(n / 10);
        // Auxilliary SC== log(d)/log(10) where d is no of digits in input; ASC for
        // function calls;

    }

    public static int V1_3(int n) {
        return (int) Math.floor(Math.log(n) / Math.log(10) + 1);
        // TC== Theta(1);
    }

    public static void V1_4() {
        // 2,4,6,8,10..
        // a=2; d=2;
        // ST=a+d, TT=a+2d,... nth term(NT)=a+(n-1)d;
        // avg=sum/n;
        // sum=avg*n; avg=(FT+LT )/2;
        // sum=((a+a+(n-1)d)/2)*n;
        // sum=n/2(2a+(n-1)d);

        int FT = 2;
        int d = 2;
        int LT = 10;
        double sum = (double) (2.5) * (double) (2 * FT + (5 - 1) * d); // 5/2= 2.5;
        System.out.println(sum);

    }

    public static int reverse(int n) {
        int res = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            res = res * 10 + lastDigit;
            n = n / 10;
        }
        return res;

        // TC== Theta(d) where d is no of digits in input;
    }

    public static boolean V3(int n) {
        // first find reverse
        int revNum = reverse(n);
        return revNum == n;

        // TC== Theta(d) where d is no of digits in input;

    }

    public static int V4(int n) {
        // factorial by iteration
        if (n == 0 || n == 1)
            return 1;
        int i = 2;
        int ans = 1;
        while (i <= n) {
            ans *= i;
            i++;
        }
        return ans;

        // TC== Theta(n)
    }

    public static int V4_2(int n) {
        // factorial by recursion
        if (n == 0 || n == 1)
            return 1;
        return n * V4_2(n - 1);
        // TC== Theta(n) and ASC is Theta(n);
    }

    public static int V5(int n) {
        // trailing zeroes;
        int res = 0;
        for (int i = 5; i <= n; i = i * 5) {
            res += (n / i);
        }
        return res;
        // TC=Theta(log(n))/log(5),5^1,5^2,5^3,...5^k<=n; k=log(n)/log(5);
    }

    public static int V6(int a, int b) {
        int i = Math.min(a, b);
        if (i <= 0)
            return 0;
        for (int j = i; j >= 0; j--) {
            if (a % j == 0 && b % j == 0) {
                return j;
            }
        }

        return -1;

        // TC=O(Math.min(a,b))
    }

    public static int V6_1(int a, int b) {
        // optimized euclidean algorithm
        return (b == 0) ? a : V6_1(b, a % b);
        // TC=log(min(a,b))

    }

    public static int V6_2(int a, int b) {
        // Euclidean Algorithm
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int V7(int a, int b) {
        // LCM
        int res = Math.max(a, b);
        while (true) {
            if (res % a == 0 && res % b == 0) {
                return res;
            }
            res++;
        }

        // TC=O(a*b -Max(a,b));

    }

    public static int V7_2(int a, int b) {
        // a*b=gcd(a,b)*lcm(a,b);
        // lcm=a*b/gcd(a,b);
        int g = V6_1(a, b);
        return (a * b) / g;
        // TC=TC(g)=Log(min(a,b));
    }

    public static boolean V8(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;

        // TC-O(n)
    }

    public static boolean V8_2(int n) {
        // if(n<=1){
        // return false;
        // }
        // for(int i=2;i<=Math.sqrt(n);i++){
        // if(n%i==0)return false;
        // }
        // return true;
        // TC-O(n)

        if (n == 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % i + 2 == 0) {
                return false;
            }
        }
        return true;

    }

    public static void V9(int n) {
        if (n <= 1)
            return;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.println(i);
                n = n / i;
            }
        }
        // TC -Theta sqrt(n)
    }

    public static void V9_2(int n) {
        if (n <= 1)
            return;
        while (n % 2 == 0) {
            System.out.println(2);
            n = n / 2;
        }
        while (n % 3 == 0) {
            System.out.println(3);
            n = n / 3;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            while (n % i == 0) {
                System.out.println(i);
                n = n / i;
            }
            while (n % (i + 2) == 0) {
                System.out.println(i + 2);
                n = n / (i + 2);
            }
        }
        if (n > 3)
            System.out.println(n);
        // TC=Thetasqrt(n)
    }

    public static void V10(int n) {
        int i;
        for (i = 1; i * i < n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
        for (i = (int) Math.sqrt(n); i >= 1; i--) {
            if (n % i == 0) {

                System.out.println(n / i);
            }
        }
        // TC=Theta sqrt(n);
    }

    public static void V11(int n) {
        // print all primes
        for (int i = 2; i <= n; i++) {
            if (V8_2(i)) {
                System.out.println(i);
            }
        }
        // TC-O(n*sqrt(n));
    }

    public static void V11_2(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        for (int i = 2; i * i <= n; i++) {
            if (arr[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    arr[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }

    public static int V12(int x, int n) {
        if (n == 0)
            return 1;
        int temp = V12(x, n / 2);
        temp = temp * temp;
        if (n % 2 == 0) {
            return temp;
        } else {
            return temp * x;
        }
        // TC-log(n) AS=log(n);
    }

    public static int V13(int x, int n) {
        int res = 1;
        while (n > 0) {
            if (n % 2 != 0) { // n's last bit is 1 or not
                res = res * x;
            }
            x = x * x;
            n = n >> 1;// n=n/2;
        }
        return res;
        // O(log n) ASC O(1)
    }

    public static void main(String[] args) {

        // no of digits
        // int n=987;
        // int ans=V1(n);
        // int ans=V1_2(n);
        // int ans=V1_3(n);

        // AP
        // V1_4();
        // GP
        // 2,4,8,16,32,..t
        // a,ar,ar^2.ar^3....ar^(n-1);
        // sum=a(1-r^n)/1-r

        // PERMUTATIONS AND COMBINATIONS
        // P=n!/(n-r)! C=n!/(r!*(n-r)!)

        // V3 --palindrome
        // int n=2345432;
        // boolean ans=V3(n);

        // V4 --recursion
        // int n = 5;
        // int ans=V4(n);
        // int ans = V4_2(n);

        // V5--trailing zeros
        /// naive-get factorial and then count 0's
        // int n = 100;
        // int ans =V5(n);

        // V6--GCD
        // int a=8;int b=12;
        // int ans=V6(a,b);
        // int ans=V6_2(a, b);

        // V7 --LCM
        // int a = 8;
        // int b = 7;
        // int ans = V7(a, b);
        // int ans = V7_2(a, b);

        // V8 --prime
        // int n=1031;
        // boolean ans=V8(n);
        // boolean ans=V8_2(n);

        // V9 --prime factors
        // int n = 462;
        // V9(n);
        // V9_2(n);

        // V10 --all divisors
        // int n = 100;
        // V10(n);

        // V11 -Sieve of Erastothenes
        // int n=10;
        // V11(n);
        // V11_2(n);

        // V12--power
        // if(n%2)power(x,n)=power(x,n/2)*power(x,n/2) else power(x,n)=power(x,n-1)*x;
        int x = 2;
        int n = 5;
        // int ans = V12(x, n);

        // V13 --power (iterative )
        int ans = V13(x, n);

        System.out.println(ans);
    }
}
