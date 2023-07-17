package com.ruan.util;



import com.ruan.dao.BaseDao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 工具类，处理从数据库查询到的结果集转化为实体类
 * 使用反射机制完成实体映射
 */
public class CRUDUtil extends BaseDao {
    /**
     * @param sql:sql语句
     * @param clazz：映射的实体类
     * @param list：所带的参数
     * @return object: 返回的对象
     */
    public static Object CRUD(String sql, Class clazz,List<Object> list,boolean isExtends,boolean isList){
        // 动态sql语句执行对象
        PreparedStatement ps = null;
        // 返回结果
        Object object = null;
        try {
            // 获取数据库连接
//            getConnection();
            final Connection conn = BaseDao.getConnection();
            // 参数赋值进行预编译
            assert conn != null;
            ps = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            if(list != null){
                // 给参数进行循环赋值
                for (int i = 1; i <= list.size(); i++) {
                    ps.setObject(i, list.get(i - 1));
                }
            }
            // 获取查询到的结果集
            ResultSet rs = ps.executeQuery();
            object = getBean(rs,clazz,isExtends,isList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     *
     * @param rs:数据库查询到的结果集
     * @param clazz：映射的实体类
     * @return
     * @throws Exception
     */
    public static Object getBean(ResultSet rs, Class clazz,boolean isExtends,boolean isList) throws Exception {
        // 获取要封装的javabean声明的属性
        Field[] fields = clazz.getDeclaredFields();
        List<Field> fieldList = new ArrayList<>();
        // 是否需要读取父类属性信息,true读取
        if(isExtends){
            Class clazz2 = clazz;
            while (clazz2 != null){
                fieldList.addAll(new ArrayList<>(Arrays.asList(clazz2.getDeclaredFields())));
                clazz2 = clazz2.getSuperclass();
            }
            Field[] fieldss = new Field[fieldList.size()];
            fields = fieldList.toArray(fieldss);
        }
        // 获取ResultSetMetaData里rs中列的名称和类型信息
        ResultSetMetaData metaData = rs.getMetaData();
        // 光标移动到最后
        rs.last();
        // 获取结果集数据总条数
        int rows = rs.getRow();
        // 光标移动到第一行数据前
        rs.beforeFirst();
        // 获取结果集的列数
        int columnCount = metaData.getColumnCount();
        // 当是多行数据时，使用集合封装返回，否则直接返回对象
        if(rows > 1 || isList){
            // 实例化一个集合
            List<Object> list = new ArrayList<>();
            // 循环读取结果集中的每行数据
            while (rs.next()) {
                // 使用映射调用无参构造实例化对象
                Object object = clazz.newInstance();
                // 循环每一列
                for (int i = 1; i <= columnCount; i++) {
                    // 获取当前列的列名
                    String columnName = metaData.getColumnName(i);
                    // 匹配列的属性
                    for (Field field : fields) {
                        // 暴力反射，可以访问私有属性的值
                        field.setAccessible(true);
                        // 匹配列名是否一致，忽略大小写
                        if(field.getName().equalsIgnoreCase(columnName)){
                            // 将结果集中的数据使用set方法赋值给对应的属性
                            if(rs.getObject(columnName)!=null){
                                field.set(object,rs.getObject(columnName));
                            }
                        }
                    }
                }
                // 将封装好的对象存入集合
                list.add(object);
            }
            return list;
        }else {
            // 使用映射调用无参构造实例化对象
            Object object = clazz.newInstance();
            // 循环读取结果集中的每行数据
            while (rs.next()){
                // 循环每一列
                for (int i = 1; i < columnCount; i++) {
                    // 获取当前列的列名
                    String columnName = metaData.getColumnName(i);
                    // 匹配列的属性
                    for (Field field : fields) {
                        // 暴力反射，可以访问私有属性的值
                        field.setAccessible(true);
                        // 匹配列名是否一致，忽略大小写
                        if(field.getName().equalsIgnoreCase(columnName)){
                            // 将结果集中的数据使用set方法赋值个对应的属性
                            if(rs.getObject(columnName)!=null){
                                field.set(object,rs.getObject(columnName));
                            }
                        }
                    }
                }
            }
            return object;
        }
    }
}
