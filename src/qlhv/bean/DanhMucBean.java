/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qlhv.bean;

import javax.swing.*;

/**
 *
 * @author LENOVO
 */

// tạo lớp DanhMucBean.java gồm một số trường sau để nhằm hỗ trợ xử lý 
// bắt sự kiện khi nhấn vào mỗi Label.
public class DanhMucBean {
    private String kind;
    private JPanel jpn;
    private JLabel jlb;

    public DanhMucBean() {
    }

    public DanhMucBean(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
    
    
}
