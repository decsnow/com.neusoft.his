package com.ruan.mapper;

import com.ruan.bean.dto.DrugDto;
import com.ruan.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugMapper {
    private final Connection conn; // 成员变量用于保存数据库连接

    public DrugMapper() {
        this.conn = BaseDao.getConnection();
    }
    public List<DrugDto> selectIssueDrug(Integer register_id) throws SQLException {
        String sql = "SELECT * FROM prescription p " +
                " left join drug_info d on p.drug_id=d.id " +
                "where register_id =? and drug_state='已缴费'";
        //不使用CRUDUtil，使用BaseDao
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,register_id);
        // 参数赋值进行预编译
        ResultSet rs = ps.executeQuery();
        List<DrugDto> list = new ArrayList<>();
        //循环为每个属性赋值
        while (rs.next()){
            String drugId = rs.getString("drug_id");
            String drugCode = rs.getString("drug_code");
            String drugName = rs.getString("drug_name");
            String drugFormat = rs.getString("drug_format");
            String drugUnit = rs.getString("drug_unit");
            String manufacturer = rs.getString("manufacturer");
            String drugPrice = rs.getString("drug_price");
            int drugNum = rs.getInt("drug_number");
            DrugDto drugDto = new DrugDto(Integer.parseInt(drugId),drugCode,  drugName,  drugFormat,  drugUnit,  manufacturer,  drugPrice,  drugNum);
            list.add(drugDto);
        }
        return list;
    }
    public boolean updateDrugState(Integer register_id,Integer drug_id) throws SQLException {
        boolean res;
        String sql = "update prescription set drug_state='已发药' where register_id=? and drug_id=? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,register_id);
        ps.setInt(2,drug_id);
        res = ps.executeUpdate() > 0;
        return res;
    }
}
