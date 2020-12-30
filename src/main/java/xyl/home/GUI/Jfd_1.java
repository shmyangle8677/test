/*
 * Created by JFormDesigner on Tue Dec 29 22:25:33 CST 2020
 */

package xyl.home.GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import net.miginfocom.swing.*;
import xyl.service.SearchBs;
import xyl.service.impl.SearchBsImpl;

/**
 * @author 1
 */
public class Jfd_1 extends JFrame {
    public Jfd_1() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点windows的关闭后退出程序
    }

    private void ok_MouseClicked(MouseEvent e) {
        //tA_msg.setText("sussc");
        String par=tF_xm.getText();
        SearchBs sb = new SearchBsImpl();
        List<Object> list = sb.test(par);

        if (list!=null && list.size()>0){
            for(int i=0;i<list.size();i++){
                List<Object> list1= (List<Object>) list.get(i);
                for(int j=0;j<list1.size();j++){
                    tA_msg.setText(list1.toString());
                }
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        internalFrame1 = new JInternalFrame();
        lb_xm = new JLabel();
        tF_xm = new JTextField();
        lb_zjhm = new JLabel();
        tF_zjhm = new JTextField();
        ok_ = new JButton();
        scrollPane1 = new JScrollPane();
        tA_msg = new JTextArea();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setLayout(new BorderLayout());

            //======== internalFrame1 ========
            {
                internalFrame1.setVisible(true);
                internalFrame1.setTitle("design");
                Container internalFrame1ContentPane = internalFrame1.getContentPane();
                internalFrame1ContentPane.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[64,fill]" +
                    "[107,fill]" +
                    "[151,fill]" +
                    "[fill]" +
                    "[111,right]",
                    // rows
                    "[30]" +
                    "[30]" +
                    "[226]"));

                //---- lb_xm ----
                lb_xm.setText("\u59d3\u540d\uff1a");
                lb_xm.setHorizontalAlignment(SwingConstants.RIGHT);
                internalFrame1ContentPane.add(lb_xm, "cell 1 0");
                internalFrame1ContentPane.add(tF_xm, "cell 2 0");

                //---- lb_zjhm ----
                lb_zjhm.setText("\u8eab\u4efd\u8bc1\u53f7\u7801\uff1a");
                lb_zjhm.setHorizontalAlignment(SwingConstants.RIGHT);
                internalFrame1ContentPane.add(lb_zjhm, "cell 1 1");
                internalFrame1ContentPane.add(tF_zjhm, "cell 2 1");

                //---- ok_ ----
                ok_.setText("\u786e\u8ba4");
                ok_.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ok_MouseClicked(e);
                    }
                });
                internalFrame1ContentPane.add(ok_, "cell 3 1");

                //======== scrollPane1 ========
                {

                    //---- tA_msg ----
                    tA_msg.setRows(11);
                    scrollPane1.setViewportView(tA_msg);
                }
                internalFrame1ContentPane.add(scrollPane1, "cell 0 2 5 1");
            }
            dialogPane.add(internalFrame1, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JInternalFrame internalFrame1;
    private JLabel lb_xm;
    private JTextField tF_xm;
    private JLabel lb_zjhm;
    private JTextField tF_zjhm;
    private JButton ok_;
    private JScrollPane scrollPane1;
    private JTextArea tA_msg;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
