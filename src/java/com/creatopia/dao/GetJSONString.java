/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creatopia.dao;

import java.sql.*;
import java.util.*;
import javax.json.*;

import org.json.simple.JSONValue;

/**
 *
 * @author A
 */
public abstract class GetJSONString {

    public static String getJSONFromResultSet(ResultSet rs, String keyName) {
        Map json = new HashMap();
        List list = new ArrayList();
        if (rs != null) {
            try {
                ResultSetMetaData metaData = rs.getMetaData();
                while (rs.next()) {
                    Map<String, Object> columnMap = new HashMap<String, Object>();
                    for (int columnIndex = 1; columnIndex <= metaData.getColumnCount(); columnIndex++) {
                        if (rs.getString(metaData.getColumnName(columnIndex)).isEmpty()) {
                            columnMap.put(metaData.getColumnLabel(columnIndex), "");
                        } else if (rs.getString(metaData.getColumnName(columnIndex)).chars().allMatch(Character::isDigit)) {
                            columnMap.put(metaData.getColumnLabel(columnIndex), Integer.parseInt(rs.getString(metaData.getColumnName(columnIndex))));
                        } else {
                            columnMap.put(metaData.getColumnLabel(columnIndex), rs.getString(metaData.getColumnName(columnIndex)));
                        }
                    }
                    list.add(columnMap);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            json.put(keyName, list);
        }
        return JSONValue.toJSONString(json);
    }
}
