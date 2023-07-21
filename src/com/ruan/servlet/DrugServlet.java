package com.ruan.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruan.mapper.DrugMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/drug")
public class DrugServlet extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();
    DrugMapper DrugMapper = new DrugMapper();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
    switch (action){
    case "selectIssueDrug":
    // 获取发药列表
        Integer register_id = Integer.valueOf(request.getParameter("register_id"));
        String json ;
        try {
            json = objectMapper.writeValueAsString(DrugMapper.selectIssueDrug(register_id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.getWriter().print(json);
        break;
        case "selectWithdrawDrug":
            // 获取退药列表
            Integer register_id2 = Integer.valueOf(request.getParameter("register_id"));
            String json2 ;
            try {
                json2 = objectMapper.writeValueAsString(DrugMapper.selectWithdrawDrug(register_id2));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.getWriter().print(json2);
            break;
        case "updateDrugState":
            // 更新发药状态
            Integer register_id1 = Integer.valueOf(request.getParameter("register_id"));
            Integer drug_id = Integer.valueOf(request.getParameter("drug_id"));
            try {
                boolean res = DrugMapper.updateDrugState(register_id1,drug_id);
                String json1=objectMapper.writeValueAsString(res);
                response.getWriter().print(json1);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            break;
        case "updateWithdrawDrugState":
            // 更新退药状态
            Integer register_id3 = Integer.valueOf(request.getParameter("register_id"));
            Integer drug_id1 = Integer.valueOf(request.getParameter("drug_id"));
            try {
                boolean res = DrugMapper.updateWithdrawDrugState(register_id3,drug_id1);
                String json1=objectMapper.writeValueAsString(res);
                response.getWriter().print(json1);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            break;
    default:
        throw new IllegalStateException("Unexpected value: " + action);
    }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }
}