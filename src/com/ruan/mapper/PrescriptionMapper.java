package com.ruan.mapper;

import com.ruan.dao.BaseDao;

import java.sql.Connection;

public class PrescriptionMapper extends BaseDao {
    private final Connection conn; // 成员变量用于保存数据库连接

    public PrescriptionMapper() {
        this.conn = BaseDao.getConnection();
    }

    public Connection getConn() {
        return conn;
    }
}
