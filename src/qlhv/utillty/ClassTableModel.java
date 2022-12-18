/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.utillty;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import qlhv.model.HocVien;

/**
 *
 * @author LENOVO
 */
public class ClassTableModel {
    public DefaultTableModel setTableHocVien(List<HocVien> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn); // đặt tiêu đề cột cho dtm
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0) {
            for(int i = 0; i < rows; i++) {
                HocVien hocVien = listItem.get(i);
                obj = new Object[columns];
                obj[0] = hocVien.getMaHV();
                obj[1] = (i + 1);
                obj[2] = hocVien.getHoTen();
                obj[3] = hocVien.getNgaySinh();
                obj[4] = hocVien.isGioiTinh() == true ? "Nam": "Nữ";
                obj[5] = hocVien.getSoDT();
                obj[6] = hocVien.getDiaChi();                
                obj[7] = hocVien.isTinhTrang();

                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
