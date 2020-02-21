package com.thoughtworks;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        handRepository();
    }

    public static <E> void handRepository() {
        MemoryRepository<Student> memoryRepository = new MemoryRepository<Student>();
        ArrayList<Student> students = new ArrayList<Student>() {{
            add(new Student("3", "张三"));
            add(new Student("4", "李四"));
            add(new Student("5", "王五"));
            add(new Student("6", "赵六"));
            add(new Student("7", "钱七"));
        }};
        for (Student student : students) {
            memoryRepository.save(student.getId(), student);
        }
        memoryRepository.delete(searchIdByName(students, "李四"));

        Student newStudent = new Student("5", "冯五");
        students.add(newStudent);
        memoryRepository.update(newStudent.getId(), newStudent);

        RepositoryUtil.printList(memoryRepository.list());
    }

    public static String searchIdByName(ArrayList<Student> students, String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student.getId();
            }
        }
        return null;
    }
}
