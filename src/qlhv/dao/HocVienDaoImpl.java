/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import qlhv.model.HocVien;

/**
 *
 * @author LENOVO
 */
public class HocVienDaoImpl implements HocVienDAO {

    @Override
    public List<HocVien> getList() {
        try {
            // Kết nối với SQL thông qua phương thức getConnection trong DBConnect
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM hocvien";
            List<HocVien> list = new ArrayList<>();

            //thực thi câu lệnh truy vấn SQL trong JDBC API
            PreparedStatement ps = cons.prepareCall(sql);

            // Lấy dữ liệu từ bảng
            ResultSet rs = ps.executeQuery();

            // rs.next() di chuyển con trỏ tới hàng tiếp theo
            while (rs.next()) {
                HocVien hocVien = new HocVien();
                hocVien.setMaHV(rs.getInt("maHV"));
                hocVien.setHoTen(rs.getString("hoTen"));
                hocVien.setNgaySinh(rs.getDate("ngaySinh"));
                hocVien.setSoDT(rs.getString("soDT"));
                hocVien.setGioiTinh(rs.getBoolean("gioiTinh"));
                hocVien.setDiaChi(rs.getString("diaChi"));
                hocVien.setTinhTrang(rs.getBoolean("tinhTrang"));
                list.add(hocVien);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
     
    @Override
    public int createOrUpdate(HocVien hocVien) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO hocvien(maHV, hoTen, ngaySinh, gioiTinh, soDT, diaChi, tinhTrang) VALUES(?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE hoTen = VALUES(hoTen), ngaySinh = VALUES(ngaySinh), gioiTinh = VALUES(gioiTinh), soDT = VALUES(soDT), diaChi = VALUES(diaChi), tinhTrang = VALUES(tinhTrang);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, hocVien.getMaHV());
            ps.setString(2, hocVien.getHoTen());
            ps.setDate(3, new Date(hocVien.getNgaySinh().getTime()));
            ps.setBoolean(4, hocVien.isGioiTinh());
            ps.setString(5, hocVien.getSoDT());
            ps.setString(6, hocVien.getDiaChi());
            ps.setBoolean(7, hocVien.isTinhTrang());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        HocVienDAO hocVienDAO = new HocVienDaoImpl();
        System.out.println(hocVienDAO.getList());
    }

}
