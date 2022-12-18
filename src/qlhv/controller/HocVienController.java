/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import qlhv.model.HocVien;
import qlhv.service.HocVienService;
import qlhv.service.HocVienServiceImpl;

/**
 *
 * @author LENOVO
 */
public class HocVienController {

    private JButton btn_Luu;
    private JTextField txt_MaHV;
    private JTextField txt_HoTen;
    private JDateChooser jdc_NgaySinh;
    private JRadioButton rdb_Nam;
    private JRadioButton rdb_Nu;
    private JTextField txt_SoDT;
    private JTextArea txtA_DiaChi;
    private JCheckBox chk_TinhTrang;
    private JLabel lbl_Msg;
    private HocVien hocVien = null;
    private HocVienService hocVienService = null;
    
    public HocVienController(JButton btn_Luu, JTextField txt_MaHV, JTextField txt_HoTen, JDateChooser jdc_NgaySinh, JRadioButton rdb_Nam, JRadioButton rdb_Nu, JTextField txt_SoDT, JTextArea txtA_DiaChi, JCheckBox chk_TinhTrang, JLabel lbl_Msg) {
        this.btn_Luu = btn_Luu;
        this.txt_MaHV = txt_MaHV;
        this.txt_HoTen = txt_HoTen;
        this.jdc_NgaySinh = jdc_NgaySinh;
        this.rdb_Nam = rdb_Nam;
        this.rdb_Nu = rdb_Nu;
        this.txt_SoDT = txt_SoDT;
        this.txtA_DiaChi = txtA_DiaChi;
        this.chk_TinhTrang = chk_TinhTrang;
        this.lbl_Msg = lbl_Msg;
        this.hocVienService = new HocVienServiceImpl();
    }

    public void setView(HocVien hocVien) {
        this.hocVien = hocVien;
        txt_MaHV.setText("#" + hocVien.getMaHV());
        txt_HoTen.setText(hocVien.getHoTen());
        jdc_NgaySinh.setDate(hocVien.getNgaySinh());
        if (hocVien.isGioiTinh()) {
            rdb_Nam.setSelected(true);
            rdb_Nu.setSelected(false);
        } else {
            rdb_Nam.setSelected(false);
            rdb_Nu.setSelected(true);
        }
        txt_SoDT.setText(hocVien.getSoDT());
        txtA_DiaChi.setText(hocVien.getDiaChi());
        chk_TinhTrang.setSelected(hocVien.isTinhTrang());
    }

    public void setEvent() {
        btn_Luu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(txt_HoTen.getText().trim().length() == 0 || jdc_NgaySinh.getDate() == null) {
                    lbl_Msg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }
                else {
                    hocVien.setHoTen(txt_HoTen.getText());
                    hocVien.setNgaySinh(jdc_NgaySinh.getDate());
                    hocVien.setGioiTinh(rdb_Nam.isSelected());
                    hocVien.setSoDT(txt_SoDT.getText());
                    hocVien.setDiaChi(txtA_DiaChi.getText());
                    hocVien.setTinhTrang(chk_TinhTrang.isSelected());
                    
                    int lastId = hocVienService.createOrUpdate(hocVien);
                    if(lastId > 0) {
                        hocVien.setMaHV(lastId);
                        txt_MaHV.setText("#" + lastId);
                        lbl_Msg.setText("Cập nhật dữ liệu thành công");
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn_Luu.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn_Luu.setBackground(new Color(0, 51, 255));

            }

        });

    }
}
