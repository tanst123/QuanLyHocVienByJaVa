/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.service;

import java.util.List;
import qlhv.model.HocVien;

/**
 *
 * @author LENOVO
 */
public interface HocVienService {
    public List<HocVien> getList();
        public int createOrUpdate(HocVien hocVien);

}
