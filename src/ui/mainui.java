package ui;

//******Author：zhiminzhang
//******Data:2022/12/8 15:01
/*
 * hide show  修改时间
 * hide
 * show
 * stringtolong
 * execuitl
 * log
 *
 * 移动文件 复制 删除
 * move
 * copy
 * topath
 *
 *
 * 初始化 增加txt 增加目录 搜索
 *frist
 * maketxt
 * makedir
 * sousuo
 * listtovecter
 *
 *
 *
 *
 *
 *
 *
 * */

import file.*;
import io.*;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;


public class mainui {
    TreePath yy;
    public JFrame jf = new JFrame("FileSystem");
    public JPanel jp = new JPanel();
    //    public JPanel jplb = new JPanel(new CardLayout());
    public JPanel jplb = new JPanel();
    String mkdirxiangpath;
    String mkdirname;
    TreePath copypath;

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public void init() {
//        声明顶级容器

        ImageIcon icojf = new ImageIcon("lib/dir.png");
        Image tempjf = icojf.getImage().getScaledInstance(50, 65, icojf.getImage().SCALE_DEFAULT);
        jf.setIconImage(tempjf);

//        声明面板,左右分，然后上下分


        jf.add(jp);
        jf.setBounds(400, 100, 1000, 700);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);


//        声明组件
//        左上
        JPanel jplt = new JPanel();
        jplt.setLocation(0, 0);
        int ss = (int) (jp.getWidth() * 0.6);
        int ff = (int) (jp.getHeight() * 0.1);
        jplt.setSize(ss, ff);
        //  jplt.setBackground(new Color(58806));
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setPreferredSize(new Dimension(jplt.getWidth(), jplt.getHeight()));
        // jMenuBar.setBackground(new Color(23444));
//          菜单
        JMenu xinjian = new JMenu("新建");
        int dd = (int) (jplt.getWidth() * 0.15);

        xinjian.setFont(new Font(null, Font.BOLD, 20));
        xinjian.setSize(dd, jplt.getHeight());
        JMenuItem xinjiantxt = new JMenuItem("文本文档");
        xinjiantxt.setFont(new Font(null, Font.BOLD, 20));
        JMenuItem xinjiandir = new JMenuItem("文件夹");
        xinjiandir.setFont(new Font(null, Font.BOLD, 20));


//          上一步按钮
        JButton shangyibubt = new JButton();

        //  System.out.println(dd+"///"+jplt.getHeight());
        shangyibubt.setSize(dd, jplt.getHeight());

        this.setIcon("lib/shangyibu.png", shangyibubt);//根据图片大小神啦
        shangyibubt.setContentAreaFilled(false);//透明
        shangyibubt.setBorderPainted(false);

//        路径显示文本框
        JTextField pathxianshi = new JTextField();
        int gg = (int) (jplt.getWidth() * 0.55);
        pathxianshi.setSize(gg, jplt.getHeight());
        pathxianshi.setFont(new Font(null, Font.BOLD, 20));
//          刷新按钮
        JButton flashbt = new JButton("刷新");
        flashbt.setSize(dd, jplt.getHeight());
        flashbt.setFont(new Font(null, Font.BOLD, 20));
        flashbt.setContentAreaFilled(false);
        flashbt.setBorderPainted(false);//无边框
//       右上
        JPanel jprt = new JPanel();
        int ssd = (int) (jp.getWidth() * 0.4);
        jprt.setSize(ssd, ff);
        jprt.setLocation(jplt.getWidth(), 0);
        // jprt.setBackground(new Color(214283));
        JMenuBar jMenuBar1 = new JMenuBar();
        jMenuBar1.setPreferredSize(new Dimension(jprt.getWidth(), jprt.getHeight()));
//        搜索框
        JTextField sousuokuang = new JTextField();
        int sk = (int) (jprt.getWidth() * 0.6);
        sousuokuang.setSize(sk, jprt.getHeight());
        sousuokuang.setFont(new Font(null, Font.BOLD, 20));

//        搜索按钮
        JButton suosuobt = new JButton("搜索");
        int sa = (int) (jprt.getWidth() * 0.2);
        suosuobt.setSize(sa, jprt.getHeight());
        suosuobt.setFont(new Font(null, Font.BOLD, 20));
        suosuobt.setContentAreaFilled(false);
        suosuobt.setBorderPainted(false);//无边框
//        工具按钮

        JMenu gongju = new JMenu("工具");
        gongju.setFont(new Font(null, Font.BOLD, 20));
        JMenuItem copyfile = new JMenuItem("复制文件");
        copyfile.setFont(new Font(null, Font.BOLD, 20));
        JMenuItem pastfile = new JMenuItem("粘贴文件");
        pastfile.setFont(new Font(null, Font.BOLD, 20));
        JMenuItem movefile = new JMenuItem("移动文件");
        movefile.setFont(new Font(null, Font.BOLD, 20));
        JMenuItem delefile = new JMenuItem("删除文件");
        delefile.setFont(new Font(null, Font.BOLD, 20));
        JMenuItem hidefile = new JMenuItem("隐藏文件");
        hidefile.setFont(new Font(null, Font.BOLD, 20));
        JMenuItem showfile = new JMenuItem("显示文件");
        showfile.setFont(new Font(null, Font.BOLD, 20));
        JMenuItem setdatafile = new JMenuItem("修改时间");
        setdatafile.setFont(new Font(null, Font.BOLD, 20));
        JMenuItem rename = new JMenuItem("重命名");
        rename.setFont(new Font(null, Font.BOLD, 20));
        JMenuItem editormenu = new JMenuItem("编辑内容");
        editormenu.setFont(new Font(null, Font.BOLD, 20));
//       左下，jtree布局管理

        // jplb.setBackground(new Color(334554675));
        jplb.setLocation(0, jplt.getHeight());
        int ffd = (int) (jp.getHeight() * 0.9);
        jplb.setSize(ss, ffd);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("filesystem");
        File fileroot = new File("filesystem");
        nodes(fileroot, root);
        DefaultTreeModel mode = new DefaultTreeModel(root);
        JTree jTree = new JTree(mode);
        JScrollPane jScrollPane = new JScrollPane(jTree) {
            private static final long serialVersionUID = -4915054862948428502L;//sp1滚动面板的大小

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(jplb.getWidth(), jplb.getHeight());//括号内参数，可以根据需要更改
            }
        };

        // jScrollPane.setViewportView(jTree);
        jplb.add(jScrollPane);
        jTree.setCellRenderer(new DefaultTreeCellRenderer() {
            private static final long serialVersionUID = 2039293913837780846L;

            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
                setMaximumSize(new Dimension(ss, jp.getHeight() - 50));
                setFont(new Font(null, Font.BOLD, 20));

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

                String st = node.toString();
                if (st.contains(".")) {
                    ImageIcon ic = new ImageIcon("lib/txt.png");
                    Image im = ic.getImage().getScaledInstance(45, 50, ic.getImage().SCALE_DEFAULT);
                    setIcon(new ImageIcon(im));
                } else {
                    ImageIcon ic = new ImageIcon("lib/dir.png");
                    Image im = ic.getImage().getScaledInstance(45, 50, ic.getImage().SCALE_DEFAULT);
                    setIcon(new ImageIcon(im));
                }
                return this;
            }
        });
        jTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath path = e.getPath();
                yy=path;
                System.out.println(path.toString());
                String qianxianduipath = topath.to(path.toString());
                String xiangduipath = qianxianduipath.replace(",", "\\").replace("[", "").replace("]", "").replace(" ", "");
                System.out.println(xiangduipath);
                pathxianshi.setText(xiangduipath);
                mkdirxiangpath = xiangduipath;

            }
        });

//        右下
        JPanel jprb = new JPanel();
        // jprb.setLayout(null);
        // jprb.setBackground(new Color(641586));
        jprb.setBounds(jplt.getWidth(), jplt.getHeight(), ssd, jp.getHeight() - 50);

        // 创建表的数据容器
        Vector<Vector<Object>> contextList = new Vector<>();
        // 创建表头的数据容器
        Vector<Object> titleList = new Vector<>();
        titleList.add("搜索内容如下......");


        final DefaultTableModel[] TableModel = {new DefaultTableModel(contextList, titleList)};

        JTable sousuobiao = new JTable(TableModel[0]);
        //   sousuobiao.setBackground(new Color(646565));
        sousuobiao.setRowHeight(55);
        //  sousuobiao.setFont(new Font(null, Font.BOLD, 20));
        sousuobiao.setDefaultRenderer(Object.class, new TableViewRenderer());//红色标记部分是用来渲染JTable的自定义绘制器

      /* sousuobiao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       // AUTO_RESIZE_OFF  不自动调整列的宽度；使用滚动条。*/
        JTableHeader tableHeader = sousuobiao.getTableHeader();//得到表头对象
        tableHeader.setFont(new Font(null, Font.BOLD, 30));//设置表头字体
        // tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 35));// 设置表头大小
     /*   sousuobiao.setLocation(jplt.getWidth(), jplt.getHeight());
        sousuobiao.setSize(ssd, jp.getHeight() - 50);*/
        JScrollPane jScrollPane1 = new JScrollPane(sousuobiao) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(jprb.getWidth(), jprb.getHeight());
            }
        };
        jprb.add(jScrollPane1);
        //监听表格
/*        sousuobiao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent e) {//仅当鼠标双击时响应
                if (e.getClickCount() == 2) {
                 *//*   //得到选中的行列的索引值
                    int r = sousuobiao.getSelectedRow();
                    int c = sousuobiao.getSelectedColumn();
                    //得到选中的单元格的值，表格中都是字符串
                    Object value = sousuobiao.getValueAt(r, c);
                    String zhanpath = value.toString().replace("\\", ",").trim();

                    System.out.println(zhanpath);
                    String[] split = zhanpath.split(",");
                    System.out.println();*//*
// 创建路径  [filesystem, 而同仁堂{创建时间2023-01-08 21:39:59}, gjm{创建时间2023-01-07 10:38:46}]
                    TreePath path = new TreePath(new Object[]{"filesystem", "而同仁堂{创建时间2023-01-08 21:39:59}", "gjm{创建时间2023-01-07 10:38:46}"});

                }
            }


        });*/
//        组装   左上


        jp.setLayout(null);
        jp.add(jplt);
        jp.add(jprt);
        //jprt.setLocation();
        jp.add(jplb);
        jp.add(jprb);

        jplt.add(jMenuBar);
        jMenuBar.add(xinjian);
        jMenuBar.add(shangyibubt);
        jMenuBar.add(pathxianshi);
        jMenuBar.add(flashbt);
        xinjian.add(xinjiantxt);
        xinjian.add(xinjiandir);

//              右上
        jprt.add(jMenuBar1);
        jMenuBar1.add(sousuokuang);
        jMenuBar1.add(suosuobt);
        jMenuBar1.add(gongju);
        gongju.add(copyfile);
        gongju.add(pastfile);
        gongju.add(movefile);
        gongju.add(delefile);
        gongju.add(hidefile);
        gongju.add(showfile);


//            显示
        jp.updateUI();

//    动作
        xinjiandir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog = new JDialog(new Frame(), "请输入新建文件夹名称");
                jDialog.setBounds(600, 200, 300, 140);
                JPanel jPanelt = new JPanel();
                jPanelt.setLayout(null);
                jDialog.add(jPanelt);
                jDialog.setVisible(true);
                JTextField jTextField = new JTextField();
                jTextField.setBounds(0, 0, 300, 50);
                jTextField.setFont(new Font(null, Font.BOLD, 20));
                JButton queding = new JButton("确定");
                queding.setBounds(0, 50, 150, 50);
                queding.setFont(new Font(null, Font.BOLD, 20));
                JButton quxiao = new JButton("取消");
                quxiao.setBounds(150, 50, 150, 50);
                quxiao.setFont(new Font(null, Font.BOLD, 20));
                jPanelt.add(jTextField);
                jPanelt.add(queding);
                jPanelt.add(quxiao);
                jPanelt.updateUI();
//              动作
                queding.addActionListener(e1 -> {
                    mkdirname = jTextField.getText();
                    makedir makedir = new makedir(mkdirxiangpath, mkdirname);
                    root.removeAllChildren();
                    nodes(fileroot, root);
                    //  mode.reload(root);
                    jTree.updateUI();
                    jDialog.setVisible(false);

                });
                quxiao.addActionListener(e12 -> {
                    jDialog.setVisible(false);
                });

            }
        });
        shangyibubt.addActionListener(e -> {
            TreePath selectionPath = jTree.getSelectionPath();
            TreePath parentPath = selectionPath.getParentPath();
            //System.out.println(parentPath);
            jTree.collapsePath(parentPath);
        });
        flashbt.addActionListener(e -> {
            root.removeAllChildren();
            nodes(fileroot, root);
            mode.reload(root);
            jp.updateUI();

        });
        xinjiantxt.addActionListener(e -> {
            JDialog jDialog = new JDialog(new Frame(), "请输入新建文本文件名称");
            jDialog.setBounds(600, 200, 300, 140);
            JPanel jPanelt = new JPanel();
            jPanelt.setLayout(null);
            jDialog.add(jPanelt);
            jDialog.setVisible(true);
            JTextField jTextField = new JTextField();
            jTextField.setBounds(0, 0, 300, 50);
            jTextField.setFont(new Font(null, Font.BOLD, 20));
            JButton queding = new JButton("确定");
            queding.setBounds(0, 50, 150, 50);
            queding.setFont(new Font(null, Font.BOLD, 20));
            JButton quxiao = new JButton("取消");
            quxiao.setBounds(150, 50, 150, 50);
            quxiao.setFont(new Font(null, Font.BOLD, 20));
            jPanelt.add(jTextField);
            jPanelt.add(queding);
            jPanelt.add(quxiao);
            jPanelt.updateUI();
//              动作
            queding.addActionListener(e1 -> {
                mkdirname = jTextField.getText();
                try {
                    maketxt maketxt = new maketxt(mkdirxiangpath, mkdirname);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                root.removeAllChildren();
                nodes(fileroot, root);
                //  mode.reload(root);
                jTree.updateUI();
                jDialog.setVisible(false);

            });
            quxiao.addActionListener(e12 -> {
                jDialog.setVisible(false);
            });

        });

        suosuobt.addActionListener(e -> {
            String text = sousuokuang.getText();
            sousuo sousuo = new sousuo(text);
            List<String> filesspath = sousuo.getFilesspath();
            contextList.clear();
            new ListTOVector(filesspath, contextList);
            TableModel[0] = new DefaultTableModel(contextList, titleList) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            sousuobiao.setModel(TableModel[0]);
        });
        copyfile.addActionListener(e -> {
            TreePath selectionPath = jTree.getSelectionPath();
            this.copypath = selectionPath;
        });

        pastfile.addActionListener(e -> {
            TreePath pastpath = jTree.getSelectionPath();
            String targetpath = topath.to(pastpath.toString()).replace(",", "\\").replace("[", "").replace("]", "").trim().replace(" ", "");
            System.out.println("目标路径" + targetpath);
            String rootpath = topath.to(this.copypath.toString()).replace(",", "\\").replace("[", "").replace("]", "").trim().replace(" ", "");
            System.out.println("原路径" + rootpath);
            copydirall.copdir(rootpath, targetpath);
            root.removeAllChildren();
            nodes(fileroot, root);
            mode.reload(root);
            jp.updateUI();
        });

        delefile.addActionListener(e -> {
            TreePath delepath = jTree.getSelectionPath();
            System.out.println(delepath.toString());
            String delest = topath.to(delepath.toString()).replace(",", "\\").replace("[", "").replace("]", "").trim().replace(" ", "");
            File file = new File(delest);
            boolean isdelefile = file.delete();
            System.out.println("文件删除" + isdelefile);

            root.removeAllChildren();
            nodes(fileroot, root);
            mode.reload(root);
            jp.updateUI();
        });
        movefile.addActionListener(e -> {
            final String rootpath = this.mkdirxiangpath;
            jTree.addTreeSelectionListener(new TreeSelectionListener() {
                @Override
                public void valueChanged(TreeSelectionEvent e) {
                    TreePath targetmovepath = e.getPath();
                    String tarmovest = topath.to(targetmovepath.toString()).replace(",", "\\").replace("[", "").replace("]", "").trim().replace(" ", "");
                    System.out.println("移动目标路径" + tarmovest);
                    System.out.println("移动原路径" + rootpath);
                    boolean move = movefiles.move(rootpath, tarmovest);

                    System.out.println("移动" + move);
                    //更新tree
                    root.removeAllChildren();
                    nodes(fileroot, root);
                    jTree.removeTreeSelectionListener(this);
                    mode.reload(root);
                    jp.updateUI();

                }
            });
        });
        hidefile.addActionListener(e -> {
            TreePath hidepath = jTree.getSelectionPath();
            String hidexiangdui = topath.to(hidepath.toString()).replace(",", "\\").replace("[", "").replace("]", "").trim().replace(" ", "");
            ;
            File file = new File(hidexiangdui);
            String absolutePath = file.getAbsolutePath();
            try {
                boolean hide = hidefiles.hide(absolutePath);
                System.out.println(absolutePath + "隐藏" + hide);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            //更新tree
            root.removeAllChildren();
            nodes(fileroot, root);
            mode.reload(root);
            jp.updateUI();
        });
        showfile.addActionListener(e -> {
            TreePath showpath = jTree.getSelectionPath();
            String showxiangdui = topath.to(showpath.toString()).replace(",", "\\").replace("[", "").replace("]", "").trim().replace(" ", "");
            ;
            File file = new File(showxiangdui);
            if (file.isHidden()) {
                String showabsolutePath = file.getAbsolutePath();
                try {
                    boolean show = showfiles.show(showabsolutePath);
                    System.out.println(showabsolutePath + "设置显示" + show);
                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                }
                //更新tree
                root.removeAllChildren();
                nodes(fileroot, root);
                mode.reload(root);
                jp.updateUI();
            }
        });
        final JPopupMenu[] jpop = {null};
        setdatafile.addActionListener(e -> {
            jpop[0].setVisible(false);
            JDialog jDialog = new JDialog(new Frame(), "请输入更改时间");
            jDialog.setBounds(600, 200, 320, 180);
            JPanel jPanelt = new JPanel();
            jPanelt.setLayout(null);
            jDialog.add(jPanelt);
            jDialog.setVisible(true);
            JLabel jLabel = new JLabel("  年     月     日     时     分     秒");
            jLabel.setFont(new Font(null, Font.BOLD, 20));
            jLabel.setBounds(0, 0, 320, 40);
            JTextField nian = new JTextField();
            nian.setBounds(0, 40, 50, 50);
            nian.setFont(new Font(null, Font.BOLD, 20));
            JTextField yu = new JTextField();
            yu.setBounds(51, 40, 50, 50);
            yu.setFont(new Font(null, Font.BOLD, 20));
            JTextField ri = new JTextField();
            ri.setBounds(102, 40, 50, 50);
            ri.setFont(new Font(null, Font.BOLD, 20));
            JTextField shi = new JTextField("00");
            shi.setBounds(153, 40, 50, 50);
            shi.setFont(new Font(null, Font.BOLD, 20));
            JTextField fen = new JTextField("00");
            fen.setBounds(204, 40, 50, 50);
            fen.setFont(new Font(null, Font.BOLD, 20));
            JTextField miao = new JTextField("00");
            miao.setBounds(255, 40, 50, 50);
            miao.setFont(new Font(null, Font.BOLD, 20));
            JButton queding = new JButton("确定");
            queding.setBounds(0, 90, 150, 50);
            queding.setFont(new Font(null, Font.BOLD, 20));
            JButton quxiao = new JButton("取消");
            quxiao.setBounds(150, 90, 152, 50);
            quxiao.setFont(new Font(null, Font.BOLD, 20));
            jPanelt.add(jLabel);
            jPanelt.add(nian);
            jPanelt.add(yu);
            jPanelt.add(ri);
            jPanelt.add(shi);
            jPanelt.add(fen);
            jPanelt.add(miao);
            jPanelt.add(queding);
            jPanelt.add(quxiao);
            jPanelt.updateUI();
//动作
            queding.addActionListener(e13 -> {
                if (isNumeric(nian.getText()) && isNumeric(yu.getText()) && isNumeric(ri.getText()) && isNumeric(shi.getText()) && isNumeric(fen.getText()) && isNumeric(miao.getText())) {
                    String date = nian.getText() + "-" + yu.getText() + "-" + ri.getText() + " " + shi.getText() + ":" + fen.getText() + ":" + miao.getText();
                    long to = 0;
                    try {
                        to = stringtolong.to(date);

                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    TreePath selectionPath = jTree.getSelectionPath();
                    String replace = topath.to(selectionPath.toString()).replace(",", "\\").replace("[", "").replace("]", "").trim().replace(" ", "");
                    File file = new File(replace);
                    boolean b = file.setLastModified(to);
                    System.out.println(replace + "更改" + b);
                    jDialog.setVisible(false);
                    //更新tree
                    root.removeAllChildren();
                    nodes(fileroot, root);
                    mode.reload(root);
                    jp.updateUI();
                }
            });
            quxiao.addActionListener(e14 -> {
                jDialog.setVisible(false);
            });
        });


        jTree.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 3) {
                    if (jpop[0] != null) {
                        jpop[0].setVisible(false);
                    }

                    jpop[0] = new JPopupMenu();
                    jpop[0].setLocation(e.getXOnScreen(), e.getYOnScreen());
                    jpop[0].add(rename);
                    jpop[0].add(setdatafile);
                    jpop[0].add(editormenu);
                    System.out.println(e.getX() + "nnnn" + e.getY());
                    jpop[0].setVisible(true);

                }
                if (e.getButton() == 1) {
                    if (jpop[0] != null) {
                        jpop[0].setVisible(false);
                    }

                }
            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        rename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpop[0].setVisible(false);
                JDialog jDialog = new JDialog(new Frame(), "请输入名称");
                jDialog.setBounds(600, 200, 300, 140);
                JPanel jPanelt = new JPanel();
                jPanelt.setLayout(null);
                jDialog.add(jPanelt);
                jDialog.setVisible(true);
                JTextField jTextField = new JTextField();
                jTextField.setBounds(0, 0, 300, 50);
                jTextField.setFont(new Font(null, Font.BOLD, 20));
                JButton queding = new JButton("重命名");
                queding.setBounds(0, 50, 150, 50);
                queding.setFont(new Font(null, Font.BOLD, 20));
                JButton quxiao = new JButton("取消");
                quxiao.setBounds(150, 50, 150, 50);
                quxiao.setFont(new Font(null, Font.BOLD, 20));
                jPanelt.add(jTextField);
                jPanelt.add(queding);
                jPanelt.add(quxiao);
                jPanelt.updateUI();
//              动作
                queding.addActionListener(e1 -> {
                    String rn = jTextField.getText();
                    TreePath sp = jTree.getSelectionPath();
                    String rp = topath.to(sp.toString()).replace(",", "\\").replace("[", "").replace("]", "").trim().replace(" ", "");
                    File refile = new File(rp);
                    String rpr = refile.getAbsolutePath().substring(0, refile.getAbsolutePath().length() - refile.getName().length()) + rn;
                    System.out.println(rpr);
                    refile.renameTo(new File(rpr));

                    root.removeAllChildren();
                    nodes(fileroot, root);

                    jTree.updateUI();
                    jDialog.setVisible(false);

                });
                quxiao.addActionListener(e12 -> {
                    jDialog.setVisible(false);
                });


            }
        });
        editormenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpop[0].setVisible(false);
                TreePath sp = jTree.getSelectionPath();
                String edp = topath.to(String.valueOf(sp)).replace(",", "\\").replace("[", "").replace("]", "").trim().replace(" ", "");
                System.out.println("编辑路径" + edp);
                editor editor = new editor();
                editor.edit(new File(edp));

            }
        });
    }

    public void nodes(File fileroot, DefaultMutableTreeNode nodes) {

        File[] files = fileroot.listFiles();
        if (files != null) {
            for (File filenode : files) {
                DefaultMutableTreeNode rootnode = null;
                if (filenode.isHidden()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    //日期格式化
                    String format = simpleDateFormat.format(filenode.lastModified());
                    rootnode = new DefaultMutableTreeNode(filenode.getName() + "{" + "创建时间" + format + "隐藏文件}");
                    nodes.add(rootnode);

                }
                if (!filenode.isHidden()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    //日期格式化
                    String format = simpleDateFormat.format(filenode.lastModified());
                    rootnode = new DefaultMutableTreeNode(filenode.getName() + "{" + "创建时间" + format + "}");
                    nodes.add(rootnode);
                }
                if (filenode.isDirectory()) {
                    nodes(filenode, rootnode);
                }
            }
        }
    }

    public void setIcon(String file, JButton com) {

        ImageIcon ico = new ImageIcon(file);
        Image temp = ico.getImage().getScaledInstance(50, 65, ico.getImage().SCALE_DEFAULT);
        ico = new ImageIcon(temp);
        com.setIcon(ico);
    }

    /*  public JPanel getzuoxia(){

          return
      }*/
    static class filecre extends JPanel {


    }

    class move implements TreeSelectionListener {


        @Override
        public void valueChanged(TreeSelectionEvent e) {

        }
    }

    //自定义的表格绘制器
    class TableViewRenderer extends JTextArea implements TableCellRenderer {
        public TableViewRenderer() {
            //将表格设为自动换行
            setLineWrap(true); //利用JTextArea的自动换行方法
        }

        public Component getTableCellRendererComponent(JTable jtable, Object obj, //obj指的是单元格内容
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setFont(new Font(null, Font.BOLD, 18));
            setText(obj == null ? "" : new String((String) obj)); //利用JTextArea的setText设置文本方法
            return this;
        }
    }

}
