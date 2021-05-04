package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.745 Prefix and Suffix Search
 *
 */
public class PrefixAndSuffixSearch {

    Map<String, List<Integer>> prefixMap = new HashMap<>();
    Map<String, List<Integer>> suffixMap = new HashMap<>();

    public PrefixAndSuffixSearch(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            for (int j = 1; j <= len; j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(len - j);
                if (prefixMap.get(prefix) == null) {
                    prefixMap.put(prefix, new ArrayList<>());
                }
                if (suffixMap.get(suffix) == null) {
                    suffixMap.put(suffix, new ArrayList<>());
                }
                prefixMap.get(prefix).add(i);
                suffixMap.get(suffix).add(i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        if (!prefixMap.containsKey(prefix) || !suffixMap.containsKey(suffix)) {
            return -1;
        }

        List<Integer> prefixIndexList = prefixMap.get(prefix);
        List<Integer> suffixIndexList = suffixMap.get(suffix);

        int preIdx = prefixIndexList.size() - 1;
        int sufIdx = suffixIndexList.size() - 1;
        while (preIdx >= 0 || sufIdx >= 0) {
            while (prefixIndexList.get(preIdx) > suffixIndexList.get(sufIdx)) {
                preIdx--;
            }
            while (prefixIndexList.get(preIdx) < suffixIndexList.get(sufIdx)) {
                sufIdx--;
            }
            if (prefixIndexList.get(preIdx).equals(suffixIndexList.get(sufIdx))) {
                return prefixIndexList.get(preIdx);
            }
        }
        return -1;
    }
}

