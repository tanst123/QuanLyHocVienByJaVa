/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.dao;

import java.util.List;
import qlhv.model.HocVien;

/**
 *
 * @author LENOVO
 */
//Tạo lớp thực hiện truy vấn dữ liệu từ cơ sở dữ liệu:
public interface HocVienDAO {
    public List<HocVien> getList();
    public int createOrUpdate(HocVien hocVien);
}
