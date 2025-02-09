/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pethotelapp.Application;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Asus
 */
public class headerRenderer extends DefaultTableCellRenderer {
    public headerRenderer() {
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        setForeground(Color.WHITE);
        setFont(new Font("SansSerif", Font.PLAIN, 12));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        JTableHeader header = table.getTableHeader();
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(Color.WHITE);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("SansSerif", Font.PLAIN, 12));
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }
}
