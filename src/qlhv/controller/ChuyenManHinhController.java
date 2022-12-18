/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlhv.bean.DanhMucBean;
import qlhv.view.*;


/**
 *
 * @author LENOVO
 */

// Tạo mới lớp ChuyenManHinhController.java trong gói controller để xử lý 
// chuyển qua lại các màn hình với nhau.

public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";

    private List<DanhMucBean> listItem = null;
    
    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    // Hiển thị mặc định TrangChu
    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();// Ktra hợp lệ
        root.repaint(); // Cập nhật lại vị trí mới của mỗi điểm
    }

    //Hàm xử lý sự kiện khi nhấn vào Label bao gồm sự kiện nhấn chuột, di chuyển chuột 
    // vào và ra khỏi Label sẽ thay đổi màu nền của Panel.
    public void setEvent(List<DanhMucBean> ListItem) {
        this.listItem = ListItem;
        for (DanhMucBean item : ListItem) {
           item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
     }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "HocVien":
                    node = new HocVienJPanel();
                    break;
                case "KhoaHoc":
                    node = new KhoaHocJPanel();
                    break;
                default:
                    node = new TrangChuJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        //Sự kiến nhấn chuột
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
           jpnItem.setBackground(new Color(96, 100, 191));
           jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        // Bỏ nhấn chuột
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        // Rê chuột vào
        public void mouseEntered(MouseEvent e) {
           jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        //Thoát khỏi phần tử 
        public void mouseExited(MouseEvent e) {
             if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(76, 175, 80));
                jlbItem.setBackground(new Color(76, 175, 80));
          }
        }

    }
    
    //Phương thức thay đổi màu nền của panel và label
    private  void setChangeBackground(String kind) {
        // Duyệt qua từng phần tử trong danh sách
        for(DanhMucBean item: listItem) {
            if(item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96, 100, 191));                
                item.getJlb().setBackground(new Color(96, 100, 191));
            }
            else {
                item.getJpn().setBackground(new Color(76, 175, 80));               
                item.getJlb().setBackground(new Color(76, 175, 80));
            }
        }
    }
}
