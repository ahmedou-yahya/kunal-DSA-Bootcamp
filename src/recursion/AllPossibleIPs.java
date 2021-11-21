package recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleIPs {

    public static void main(String[] args) {
//        String str = "025";
//        System.out.println(Integer.valueOf(str));
        System.out.println(restoreIpAddresses("00020").toString());
    }

    public static List<String> restoreIpAddresses(String ip) {
        List<String> ans = new ArrayList<>();
        int[] path = new int[4];
        possibleIPs(ans, ip, 0, path, 0);
        return ans;
    }

    private static void possibleIPs(List<String> ans, String ip, int builderIndex, int[] path, int segement) {

        if (segement==4 && builderIndex==ip.length()){
            ans.add(path[0]+"."+path[1]+"."+path[2] + '.' + path[3]);
            return;
        }
        else if (segement==4 || builderIndex==ip.length())
            return;

        for (int len=1; len<=3 && builderIndex+len<=ip.length(); len++){
            String snapshot = ip.substring(builderIndex, builderIndex+len);
            int value = Integer.valueOf(snapshot);
            if (value>255 || (len>=2 && snapshot.charAt(0)=='0'))
                break;

            path[segement] = value;
            possibleIPs(ans, ip, builderIndex+len, path, segement+1);
            path[segement]=-1;
        }

    }
}
