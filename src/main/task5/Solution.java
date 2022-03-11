package main.task5;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    Map<List<Integer>, List<Subject>> result = new LinkedHashMap<>();
    ;
    List<Subject> listSubjects = null;
    SafetyBox safetyBox = null;

    public Solution(List<Subject> listSubjects, SafetyBox safetyBox) {
        this.listSubjects = listSubjects;
        this.safetyBox = safetyBox;
    }

    public void methodDynamicProgramming() {
        int[][] tableResult = new int[listSubjects.size() + 1][safetyBox.getVolume() + 1];
        for (int i = 1; i < tableResult.length; i++) {
            int capacity = listSubjects.get(i - 1).getVolume();
            int value = listSubjects.get(i - 1).getValue();
            for (int j = 1; j < tableResult[0].length; j++) {
                if (i == 1) {
                    if (capacity <= j) {
                        tableResult[i][j] = value;
                        setResultList(i, j, 0);
                    }
                } else {
                    if (capacity <= j) {
                        tableResult[i][j] = Integer.max(tableResult[i - 1][j], value + tableResult[i - 1][j - capacity]);
                        if (tableResult[i][j] == tableResult[i - 1][j]) {
                            setResultList(i, j, 0);
                        } else {
                            setResultList(i, j, capacity);
                        }
                    } else {
                        tableResult[i][j] = tableResult[i - 1][j];
                        setResultList(i, j, 0);
                    }
                }
            }
        }
        safetyBox.setSubjectInSafetyBox(result.get(List.of(listSubjects.size(), safetyBox.getVolume())));
    }

    private void setResultList(Integer i, Integer j, Integer flag) {
        if (result.get(List.of(i - 1, j - flag)) == null)
            result.put(List.of(i, j), List.of(listSubjects.get(i - 1)));
        else {
            List<Subject> temp = result.get(List.of(i - 1, j - flag))
                    .stream()
                    .collect(Collectors.toList());
            if (flag != 0) {
                temp.add(listSubjects.get(i - 1));
            }
            result.put(List.of(i, j), temp);
        }
    }
}
