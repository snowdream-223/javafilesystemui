package ui;

import io.inputtxt;
import io.outputtxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;


//******Author：zhiminzhang
//******Data:2023/1/8 14:03
public class editor {


    public void edit(File file ) {

        if (file.isFile()) {
            String input = inputtxt.input(file.getAbsolutePath());
            JDialog jDialog = new JDialog(new Frame(), file.getName());
            jDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            jDialog.setBounds(500, 100, 600, 800);
            JPanel jPanelt = new JPanel();
            jPanelt.setLayout(null);
            jDialog.add(jPanelt);
            jDialog.setVisible(true);
            JTextArea jTextArea = new JTextArea();
            jTextArea.setText(input);

            //   jTextArea.setBounds(0, 0, 600, 700);
            jTextArea.setFont(new Font(null, Font.BOLD, 18));
            JButton queding = new JButton("保存");
            queding.setBounds(0, 700, 100, 60);
            queding.setFont(new Font(null, Font.BOLD, 20));
            queding.setContentAreaFilled(false);//透明
            queding.setBorderPainted(false);
            JButton quxiao = new JButton("取消");
            quxiao.setBounds(100, 700, 100, 60);
            quxiao.setFont(new Font(null, Font.BOLD, 20));
            quxiao.setContentAreaFilled(false);//透明
            quxiao.setBorderPainted(false);
            JScrollPane jScrollPane = new JScrollPane(jTextArea) {
                private static final long serialVersionUID = -4743617237000188715L;//sp1滚动面板的大小

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(600, 700);//括号内参数，可以根据需要更改
                }
            };
            jScrollPane.setBounds(0, 0, 600, 700);
            jPanelt.add(jScrollPane);
            jPanelt.add(queding);
            jPanelt.add(quxiao);
            jPanelt.updateUI();
            queding.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = jTextArea.getText();
                    try {
                        new outputtxt(file.getAbsolutePath(), text);
                        jDialog.dispose();

                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                }
            });
            quxiao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jDialog.dispose();
                }
            });
        }else {
            JOptionPane.showMessageDialog(null,new JLabel( "<html><h1>请选择文本文件!</h1></html>"), "系统信息", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
