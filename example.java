import java.util.Scanner;
import java.util.Arrays;
public class Bai4 {
    static boolean laSoNguyenTo(int n) {
        if(n < 2) {
            return false;
        }
        for (int i =2;i<=Math.sqrt(n);i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
    static void sapXepTang(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    static int timkiemnhiphan(int[] a, int x) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(a[mid]==x) {
                return mid;
            }
            else if (a[mid] <x) {
                left = mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] arg)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap phan tu n: ");
        int n= sc.nextInt();
        if(n<=0) {
            System.out.println("So phan tu phai lon hon 0");
            return;
        }
        int[] a= new int[n];
        for(int i=0; i<n;i++) {
            System.out.print("a["+i+"]=");
            a[i]=sc.nextInt();
        }
        System.out.println("\nMang ban dau:"+Arrays.toString(a));
        int sum =0;
        for(int i=0;i<n;i++) {
            if(laSoNguyenTo(a[i])) {
                sum+=a[i];
            }
        }
        System.out.println("Tong so cac so nguyen to:"+sum);
        int duongMax=0;
        int amMin=0;
        boolean soduong = false;
        boolean soam = false;
        for(int i=0;i<n;i++) {
            if(a[i]>0) {
                if(!soduong ||a[i] > duongMax ) {
                    duongMax=a[i];
                }
                soduong=true;
            }
           else{
                if(!soam || a[i] < amMin) {
                    amMin = a[i];
                }
                soam = true;
            }
        }
        if(soduong) {
            System.out.println("So duong lon nhat: "+duongMax);
        }
        else {
            System.out.print("So duong lo nhat:*");
        }
        if(soam) {
            System.out.println("So am nho nhat:"+amMin);
        }
        else {
            System.out.println("So am nho nhat:*");
        }
        int nguyentoMin =0;
        boolean nguyento= false;
        for (int i=0;i<n;i++) {
            if(laSoNguyenTo(a[i])) {
                if(!nguyento||a[i]<nguyentoMin) {
                    nguyentoMin=a[i];
                }
                nguyento = true;
            }
        }
        if(nguyento) {
            System.out.println("So nguyen to nho nhat:"+nguyentoMin);
        }
        else{
            System.out.println("So nguyen to nho nhat:*");
        }
        int []b = new int[n];
        int dem=0;
        for (int i=0; i<n;i++)
        {
            if(laSoNguyenTo(a[i])){
                b[dem]=a[i];
                dem++;
            }
        }
        int[] nguyenTo= Arrays.copyOf(b,dem);
        sapXepTang(nguyenTo);
        int k=0;
        for(int i=0;i<n;i++){
            if(laSoNguyenTo(a[i])){
                a[i]=nguyenTo[k];
                k++;
            }
        }
        System.out.println("Mang sau khi sap xep:"+Arrays.toString(a));
        int[] c =Arrays.copyOf(a,n);
        Arrays.sort(c);
        System.out.print("Nhap x can tim;");
        int x = sc.nextInt();
        int vitri=timkiemnhiphan(c,x);
        if(vitri != -1){
            System.out.println("Tim thay x tai vi:"+vitri+" trong mang da sap xep");
        }
        else{
            System.out.println("Khong tim thay x trong mang");
        }
    }
}
