package task5;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    Map<List<Integer>, List<Subject>> result = null;
    List<Subject> listSubjects = null;
    SafetyBox safetyBox = null;

    public Solution(List<Subject> listSubjects, SafetyBox safetyBox) {
        this.listSubjects = listSubjects;
        this.safetyBox = safetyBox;
    }

    public void methodDynamicProgramming() {
        int[][] tableResult = new int[listSubjects.size() + 1][safetyBox.getVolume() + 1];
        result = new LinkedHashMap<>();
        for (int i = 1; i < tableResult.length; i++) {
            int capacity = listSubjects.get(i - 1).getVolume();
            int value = listSubjects.get(i - 1).getValue();
            for (int j = 1; j < tableResult[0].length; j++) {
                if (i == 1) {
                    if (capacity <= j) {
                        tableResult[i][j] = value;
                        result.put(List.of(i, j), List.of(listSubjects.get(i - 1)));
                    }
                } else {
                    if (capacity <= j) {
                        tableResult[i][j] = Integer.max(tableResult[i - 1][j], value + tableResult[i - 1][j - capacity]);
                        if (tableResult[i][j] == tableResult[i - 1][j]) {
                            if (result.get(List.of(i - 1, j)) == null)
                                result.put(List.of(i, j), List.of(listSubjects.get(i - 1)));
                            else {
                                List<Subject> temp = result.get(List.of(i - 1, j))
                                        .stream()
                                        .collect(Collectors.toList());
                                result.put(List.of(i, j), temp);
                            }
                        } else {
                            if (result.get(List.of(i - 1, j - capacity)) == null)
                                result.put(List.of(i, j), List.of(listSubjects.get(i - 1)));
                            else {
                                List<Subject> temp = result.get(List.of(i - 1, j - capacity))
                                        .stream()
                                        .collect(Collectors.toList());
                                temp.add(listSubjects.get(i - 1));
                                result.put(List.of(i, j), temp);
                            }
                        }
                    } else {
                        tableResult[i][j] = tableResult[i - 1][j];
                        if (result.get(List.of(i - 1, j)) != null) {
                            List<Subject> temp = result.get(List.of(i - 1, j))
                                    .stream()
                                    .collect(Collectors.toList());
                            result.put(List.of(i, j), temp);
                        }

                    }
                }
            }
        }
        safetyBox.setSubjectInSafetyBox(result.get(List.of(listSubjects.size(), safetyBox.getVolume())));
    }

}
