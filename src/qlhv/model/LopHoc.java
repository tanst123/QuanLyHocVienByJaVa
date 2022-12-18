/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.model;
import  java.util.*;
/**
 *
 * @author LENOVO
 */
public class LopHoc {
    private int maLopHoc;
    private KhoaHoc makhoaHoc;
    private HocVien maHV;
    private Date ngayDangKy;
    private boolean tinhTrang;

    public int getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(int maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public KhoaHoc getMakhoaHoc() {
        return makhoaHoc;
    }

    public void setMakhoaHoc(KhoaHoc makhoaHoc) {
        this.makhoaHoc = makhoaHoc;
    }

    public HocVien getMaHV() {
        return maHV;
    }

    public void setMaHV(HocVien maHV) {
        this.maHV = maHV;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    

    
    
    

}
