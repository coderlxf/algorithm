package com.za.leetcode;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 * 解法：哈希表或26字母数组存储
 */
public class LeetCode1160 {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> charMap = getCharNums(chars);
        int total = 0;
        for (int i = 0; i < words.length; i++) {
            HashMap<Character, Integer> wMap = getCharNums(words[i]);
            Iterator<Character> keys = wMap.keySet().iterator();
            int wNums = 0;
            while (keys.hasNext()) {
                char c = keys.next();
                if (!charMap.containsKey(c) || charMap.get(c) < wMap.get(c)) {
                    wNums = 0;
                    break;
                } else {
                    wNums+=wMap.get(c);
                }
            }
            total += wNums;
        }
        return total;
    }

    private HashMap<Character, Integer> getCharNums(String chars) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        return charMap;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        LeetCode1160 l1160 = new LeetCode1160();
        int total = l1160.countCharacters(words, chars);
        System.out.println(total);
    }
}
