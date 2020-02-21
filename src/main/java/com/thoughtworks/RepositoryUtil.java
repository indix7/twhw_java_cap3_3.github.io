package com.thoughtworks;

import java.util.List;

public class RepositoryUtil {
    public static void printList(List<?> list) {
        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
        }
    }


}
