package com.company.Task12_12_12_17.dao;

import com.company.Task12_12_12_17.storage.Section;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectionDaoJDBC implements SectionDao {

    private Connection connection;

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void add(Section section) {
        try {
            String sql = "insert into section (name) values(?)";
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,section.getName());
            int affectedRows  = pst.executeUpdate();
            if(affectedRows ==0){
                throw new SQLException("Ошибка вставки в базу");
            }
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next())
                section.setId(generatedKeys.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Section section) {
        try {
            String sql = "update section set name=? where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,section.getName());
            pst.setInt(2,section.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Section delete(int id) {
        Section section = getById(id);
        try {
            String sql = "delete from section where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return section;
    }

    @Override
    public void deleteAll() {
        try {
            String sql = "delete from section";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    @Override
    public Section getById(int id) {
        Section section = null;
        try {
            String sql = "select id, name from section where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet resultSet = pst.executeQuery();
            if(resultSet.next())
                section = new Section(resultSet.getInt(1),
                        resultSet.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return section;
    }

    @Override
    public Section getByName(String name) {
        Section section = null;
        try {
            String sql = "select id, name from section where name=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,name);
            ResultSet resultSet = pst.executeQuery();
            if(resultSet.next())
                section = new Section(resultSet.getInt(1),
                        resultSet.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return section;
    }

    @Override
    public List<Section> getList() {
        List<Section> list = new ArrayList<>();
        Section section = null;
        try {
            String sql = "select id, name from section";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                section = new Section(resultSet.getInt(1),
                        resultSet.getString(2));
                list.add(section);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
