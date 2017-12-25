package com.company.Task12_12_12_17.dao;

import com.company.Task12_12_12_17.storage.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoJDBC implements GoodsDao {

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
    public void add(Goods goods) {
        try {
            String sql = "insert into goods (name, sectionId) values(?,?)";
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,goods.getName());
            pst.setInt(2,goods.getSectionID());
            int affectedRows  = pst.executeUpdate();
            if(affectedRows ==0){
                throw new SQLException("Ошибка вставки в базу");
            }
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next())
                goods.setId(generatedKeys.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Goods goods) {
        try {
            String sql = "update goods set name=?, sectionId=? where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,goods.getName());
            pst.setInt(2,goods.getSectionID());
            pst.setInt(3,goods.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Goods delete(int id) {
        Goods goods = getById(id);
        try {
            String sql = "delete from goods where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public void deleteAll() {
        try {
            String sql = "delete from goods";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Goods getById(int id) {
        Goods goods=null;
        try {
            String sql = "select id, name, sectionId from goods where id=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet resultSet = pst.executeQuery();
            if(resultSet.next())
                goods = new Goods(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public Goods getByName(String name) {
        Goods goods=null;
        try {
            String sql = "select id, name, sectionId from goods where name=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,name);
            ResultSet resultSet = pst.executeQuery();
            if(resultSet.next())
                goods = new Goods(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public List<Goods> getList() {
        List<Goods> list = new ArrayList<>();
        Goods employee=null;
        try {
            String sql = "select id, name, sectionId from goods";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                employee = new Goods(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3));
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Goods> getList(int sectionId) {
        List<Goods> list = new ArrayList<>();
        Goods goods=null;
        try {
            String sql = "select id, name, sectionId from goods where sectiontId=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,sectionId);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                goods = new Goods(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3));
                list.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
