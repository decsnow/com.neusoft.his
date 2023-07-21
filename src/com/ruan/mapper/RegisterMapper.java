package com.ruan.mapper;

import com.ruan.bean.Register;
import com.ruan.dao.BaseDao;
//import com.ruan.util.CRUDUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterMapper extends BaseDao {
    private final Connection conn; // 成员变量用于保存数据库连接

    public RegisterMapper() {
        this.conn = BaseDao.getConnection();
    }
    public List<Register> getRegisterList() throws SQLException {
        String sql = "SELECT * FROM register where visit_state!=3 and visit_state!=4";
        //不使用CRUDUtil，使用BaseDao
        PreparedStatement ps = conn.prepareStatement(sql);
        // 获取数据库连接
        final Connection conn = BaseDao.getConnection();
        // 参数赋值进行预编译
        assert conn != null;
        ResultSet rs = ps.executeQuery();
        List<Register> list = new ArrayList<>();
        //循环为每个属性赋值
        while (rs.next()){
int id = rs.getInt("id");
String case_number = rs.getString("case_number");
String real_name = rs.getString("real_name");
String gender = rs.getString("gender");
String card_number = rs.getString("card_number");
java.util.Date birthday = rs.getDate("birthday");
int age = rs.getInt("age");
String age_type = rs.getString("age_type");
String home_address = rs.getString("home_address");
java.util.Date visit_date = rs.getDate("visit_date");
String noon = rs.getString("noon");
int deptment_id = rs.getInt("deptment_id");
int employee_id = rs.getInt("employee_id");
int regist_level_id = rs.getInt("regist_level_id");
int settle_category_id = rs.getInt("settle_category_id");
String is_book = rs.getString("is_book");
String regist_method = rs.getString("regist_method");
int visit_state = rs.getInt("visit_state");
Float regist_money = rs.getFloat("regist_money");
Register register = new Register(id,case_number,real_name,gender,card_number,birthday,age,age_type,home_address,visit_date,noon,deptment_id,employee_id,regist_level_id,settle_category_id,is_book,regist_method,visit_state,regist_money);
list.add(register);
        }
        return list;
    }

}
