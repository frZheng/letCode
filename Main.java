import java.util.*;


public class Main {


    static public int maxScore (int energy, int[][] actions) {
        int[] dp = new int[energy + 1];
        int N = actions.length;
        for (int i = 0;i<N;i++){
            for (int j = energy;j>=actions[i][0];j--){
                dp[j]=Math.max(dp[j],dp[j-actions[i][0]]+actions[i][1]);
            }
        }

        return dp[energy];
    }
    static public int Decrypt (int encryptedNumber, int decryption, int number) {
        // write code here
        long res = 1;
        for (int i = 0; i < decryption;++i){
            res*=encryptedNumber;
        }
        System.out.println(res);
        res = res%number;
        return (int)res;
    }
/*

HuangJiaTongHuaShun
TongHuaShun
SiTiao
HuLu
TongHua
ShunZi
SanTiao
LiangDui
YiDui
 */
    static public String showDown (String inHand) {
        // write code here
        HashMap<Character, Integer> mapColor = new HashMap<>();
        mapColor.put('S',0);
        mapColor.put('H',1);
        mapColor.put('C',2);
        mapColor.put('D',3);
        HashMap<Character, Integer> mapNumber = new HashMap<>();
        mapNumber.put('J',10);
        mapNumber.put('Q',11);
        mapNumber.put('K',12);
        mapNumber.put('A',0);
        int[][] hb52= new int[4][13];
        int[] h4 = new int[4];
        int[] d13 = new int[13];


        String[] s = inHand.split(" ");
        int N = s.length;
        for (int n = 0; n<N;++n){
            int i = mapColor.get(s[n].charAt(0));
            String dian = s[n].substring(1);
            char c = dian.charAt(0);
            Integer j = mapNumber.get(c);
            if (j==null) {
                j=Integer.valueOf(dian)-1;
            }
//            System.out.println(i + " "+j);
            hb52[i][j]++;
            h4[i]++;
            d13[j]++;
        }
        for (int i = 0; i< 4;++i){
            int j = 9;
            for (;j<13;++j){
                if(hb52[i][j]==0){
                    break;
                }
            }
            if(j==13 && hb52[i][0]>0){
                return "HuangJiaTongHuaShun";
            }
        }
        for (int i = 0; i< 4;++i){
            int count = 0;
            for (int j = 0;j<13;++j){
                if(hb52[i][j]>0){
                    count++;
                } else {
                    if (count>=5){
                        return "TongHuaShun";
                    }
                    else {
                        count=0;
                    }
                }
            }
        }

        HashMap<Integer, Integer> cmap = new HashMap<>();
        for (int i =0; i<13;++i){
            Integer count = cmap.getOrDefault(d13[i], 0);
            cmap.put(d13[i],count+1);
        }
        if (cmap.containsKey(4)){
            return "SiTiao";
        }
        if (cmap.containsKey(3)&&cmap.containsKey(2)){
            return "HuLu";
        }
        for (int i =0; i < 4;++i){
            if(h4[i]>=5){
                return "TongHua";
            }
        }

        int count = 0;
        for (int i =0;i<13;++i){
            if(d13[i]>0)count++;
            else {
                if (count>=5){
                    return "ShunZi";
                }
                else {
                    count=0;
                }
            }
        }

        if (cmap.containsKey(3)){
            return "SanTiao";
        }
        if (cmap.get(2)>=2){
            return "LiangDui";
        }
        if (cmap.get(2)==1){
            return "YiDui";
        }
        return "";

    }
    public static void main(String[] args) {
//        int energy=10;
////        10,[[1,1],[2,3],[3,5],[5,10],[7,9],[8,10]]
//        int[][] actions={{1,1},{2,3},{3,5},{5,10},{7,9},{8,10}};
//        int i = maxScore(energy, actions);
//        System.out.println(i);

//        String s = showDown("SA SK SQ SJ S10 H10 C9");
        String s = showDown("SA SK SQ SJ S10");
        System.out.println(s);
//        int decrypt = Decrypt(4296, 1601, 4757);
//        System.out.println(decrypt);

//        Scanner sc = new Scanner(System.in);
//        String next = sc.nextLine();
//        int n = Integer.parseInt(next);
//
//        StringBuilder data = new StringBuilder();
//        next = sc.nextLine();
//        String[] s = next.split(" ");
//        for (int i = 0; i < n; ++i) {
//            data.append(s[i]);
//        }
//
//        int radius = romanToInt(data.toString());
//        System.out.println(radius);

    }
}
