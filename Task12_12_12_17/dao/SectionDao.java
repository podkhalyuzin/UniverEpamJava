package com.company.Task12_12_12_17.dao;

import com.company.Task12_12_12_17.storage.Section;

import java.sql.Connection;
import java.util.List;

public interface SectionDao {
    void add(Section section);
    void save(Section section);
    Section delete(int id);
    void deleteAll();
    Section getById(int id);
    Section getByName(String name);
    List<Section> getList();
    void setConnection(Connection connection);
    Connection getConnection();
}
