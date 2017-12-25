package com.company.Task12_12_12_17.dao;

import com.company.Task12_12_12_17.storage.Goods;

import java.sql.Connection;
import java.util.List;

public interface GoodsDao {
    void add(Goods goods);
    void save(Goods goods);
    Goods delete(int id);
    void deleteAll();
    Goods getById(int id);
    Goods getByName(String name);
    List<Goods> getList();
    List<Goods> getList(int sectionId);
    void setConnection(Connection connection);
    Connection getConnection();
}
