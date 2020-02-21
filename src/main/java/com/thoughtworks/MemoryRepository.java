package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class MemoryRepository<E> implements Repository<E> {
    private Map<String, E> map = new HashMap<String, E>();

    @Override
    public void save(String id, E entity) {
        if (this.map.containsKey(id)) {
            System.out.println("添加了id重复的实体， 重复信息为：\n" + this.map.get(id) + "\n" + entity
                    + "\n后者实体将替换前者。");
        }
        this.map.put(id, entity);
    }

    @Override
    public E get(String id) {
        return this.map.get(id);
    }

    @Override
    public void delete(String id) {
        this.map.remove(id);
    }

    /**
     * 通过name搜索id，        这个函数是不是不应该出现在这里(ー`´ー)
     *
     * @param id
     * @param entity
     */
//    public String searchIdByName(String name) {
//        for (Map.Entry<String, E> entry : this.map.entrySet()) {
//            if (entry.getValue().toString().equals("学生姓名 ： " +name + "  学生id : " + entry.getKey())) {
//                return entry.getKey();
//            }
//        }
//        return "not found";
//    }
    @Override
    public void update(String id, E entity) {
        if (this.map.containsKey(id)) {
            this.map.put(id, entity);
        } else {
            System.out.println("id : " + id + " 没有可用于替换的对象，替换失败！将新建该实体并保存！");
            this.save(id, entity);
        }
    }

    @Override
    public List<E> list() {
        return new ArrayList<E>(this.map.values());
    }
}
