class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();

        for(int hh = 0;hh<=11;hh++){
            for(int mm = 0;mm<=59;mm++){
                if(Integer.bitCount(hh)+Integer.bitCount(mm) == turnedOn){
                    if(mm<10){
                        res.add(hh + ":0" + mm);
                    }else{
                        res.add(hh + ":" + mm);
                    }
                }
            }
        }
        return res;
    }
}