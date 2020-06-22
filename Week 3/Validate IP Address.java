import java.util.*;
import java.util.regex.*;
class Solution {
    public String validIPAddress(String IP) {
        
        String regex_4 = "^(([0-9])|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))$";
        if(IP.split("\\.", -1).length == 4 && IP.split("\\.").length == 4)
        {
            String[] reg = IP.split("\\.");
            Pattern pat = Pattern.compile(regex_4);
            for(int i = 0; i < 4; i++)
            {
                Matcher mat = pat.matcher(reg[i]);
                if(!mat.matches())
                    return "Neither";
            }
            return "IPv4";
        }
        String regex_6 = "^(([(0-9)(a-f)(A-F)])|([(0-9)(a-f)(A-F)]{2})|([(0-9)(a-f)(A-F)]{3})|([(0-9)(a-f)(A-F)]{4}))$";
        if(IP.split(":", -1).length == 8 && IP.split(":").length == 8)
        {
            String[] reg = IP.split(":");
            Pattern pat = Pattern.compile(regex_6);
            for(int i = 0; i < 8; i++)
            {
                Matcher mat = pat.matcher(reg[i]);
                if(!mat.matches())
                    return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }
}