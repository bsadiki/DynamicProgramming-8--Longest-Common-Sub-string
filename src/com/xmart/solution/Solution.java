package com.xmart.solution;

public class Solution {
    public static void main(String[] args) {
        String string1 = "EATBEEF";
        String string2 = "DEADBEEF";
        System.out.println(maxCommonSubString(string1, string2));
    }

    private static String maxCommonSubString(String sequence1, String sequence2) {
        String[][] maxSubStringEndingInIJ = initialiseDynamicMatrix(sequence1, sequence2);
        for (int i = 1 ; i <= sequence1.length(); i++)
            for (int j = 1 ; j <= sequence2.length(); j++) {
                char character1 = sequence1.charAt(i-1);
                char character2 = sequence2.charAt(j-1);
                if (character1 == character2){
                    addCharacterToString(maxSubStringEndingInIJ, i, j, character1);
                }
            }
        return maxSubStringEndingInIJ[sequence1.length()][sequence2.length()];
    }

    private static String[][] initialiseDynamicMatrix(String sequence1, String sequence2) {
        String[][] maxSubStringEndingInIJ = new String[sequence1.length() + 1][sequence2.length() + 1];
        for (int i = 0; i < maxSubStringEndingInIJ.length; i++) {
            maxSubStringEndingInIJ[i] = new String[sequence2.length() + 1];
            for (int j = 0; j < maxSubStringEndingInIJ[i].length; j++){
                maxSubStringEndingInIJ[i][j] = "";
            }
        } return maxSubStringEndingInIJ;
    }

    private static void addCharacterToString(String[][] maxSubStringEndingInIJ, int i, int j, char character1) {
        maxSubStringEndingInIJ [i][j] = maxSubStringEndingInIJ[i-1][j-1].concat(String.valueOf(character1));
    }
}