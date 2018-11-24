/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingermath_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Corvette
 */
public class SettingDialog extends JDialog implements ActionListener{
    
    private String[] screenSize;
    private JPanel main = new JPanel(new BorderLayout());
    private JPanel mid = new JPanel(new GridLayout(4, 1));
    private JPanel tp = new JPanel();
    private JPanel sp = new JPanel();
    private JPanel rp = new JPanel();
    private JPanel bt = new JPanel();
    
    private JPanel titlePanel = new JPanel(new BorderLayout());
    private JPanel resoPanel = new  JPanel(new GridLayout(1, 2));
    private JPanel soundPanel = new JPanel(new GridLayout(1, 2));
    private JPanel btPanel = new JPanel(new GridLayout(1, 2));
    private JPanel up = new JPanel();
    private JPanel down = new JPanel();
    private JPanel left = new JPanel();
    private JPanel right = new JPanel();
    
    private JButton btOK = new JButton("Apply");
    private JButton btCC = new JButton("Cancel");
    private JComboBox<String> box = new JComboBox<>();
    private JLabel name = new JLabel("Setting");
    private JLabel resLabel = new JLabel("Resolution  ");
    private GridBagConstraints gbc = new GridBagConstraints();
    private JLabel soundLabel = new JLabel("Sound  ");
    
    public SettingDialog(Frame frame, int width, int height){
        super(frame, true);
        
        setUndecorated(true);
        setSize((int)(width), (int)(height));
        setLocationRelativeTo(frame);
        setBackground(new Color(0, 0, 0, 70));
        main.setSize(width, height);
        main.setBackground(new Color(0, 0, 0, 0));
        
        mid.setSize(width/2, (int) (height/1.4));
        mid.setBackground(new Color(255,185,50));
        
        int fontBig = (getWidth() * getHeight()) / (854*480) * 64;
        int fontSmall = (getWidth() * getHeight()) / (854*480) * 16;
        
        name.setFont(new Font("Sweet Sensations Personal Use", 3, fontBig));
        name.setForeground(Color.white);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        
        box.setFont(new java.awt.Font("Kanit", 0, fontSmall));
        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "800 x 600", "854 x 480", "1280 x 720", "1920 x 1080" }));
        
        btOK.setFont(new java.awt.Font("Kanit", 2, fontSmall));
        btCC.setFont(new java.awt.Font("Kanit", 2, fontSmall));
        
        resLabel.setFont(new java.awt.Font("Kanit", 0, fontSmall));
        resLabel.setForeground(Color.white);
        resLabel.setHorizontalAlignment(JLabel.CENTER);
        soundLabel.setFont(new java.awt.Font("Kanit", 0, fontSmall));
        soundLabel.setForeground(Color.white);
        soundLabel.setHorizontalAlignment(JLabel.CENTER);
        
        
        btOK.addActionListener(this);
        btCC.addActionListener(this);
        
        titlePanel.add(name);
        soundPanel.add(soundLabel);
        resoPanel.add(resLabel);
        resoPanel.add(box);
        btPanel.add(btOK);
        btPanel.add(btCC);
        
        titlePanel.setBackground(new Color(0, 0, 0, 0));
        soundPanel.setBackground(new Color(0, 0, 0, 0));
        resoPanel.setBackground(new Color(0, 0, 0, 0));
        btPanel.setBackground(new Color(0, 0, 0, 0));
        
        
        mid.add(titlePanel);
        mid.add(soundPanel);
        mid.add(resoPanel);
        mid.add(btPanel);
        
        
        up.setPreferredSize(new Dimension(width, (int)((height - mid.getSize().getHeight()) / 2)));
        down.setPreferredSize(new Dimension(width, (int)((height - mid.getSize().getHeight()) / 2)));
        left.setPreferredSize(new Dimension((int)((width - mid.getSize().getWidth()) / 2), height));
        right.setPreferredSize(new Dimension((int)((width - mid.getSize().getWidth()) / 2), height));
        
        up.setBackground(new Color(0, 0, 0, 0));
        down.setBackground(new Color(0, 0, 0, 0));
        left.setBackground(new Color(0, 0, 0, 0));
        right.setBackground(new Color(0, 0, 0, 0));
        
        main.add(up, BorderLayout.NORTH);
        main.add(down, BorderLayout.SOUTH);
        main.add(left, BorderLayout.WEST);
        main.add(right, BorderLayout.EAST);
        main.add(mid);
        
        getContentPane().add(main);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("Apply")){
            String item = (String)box.getSelectedItem();
            String[] parts = item.split(" x ");
            screenSize = parts;
            System.out.println("OK");
            dispose();
            this.setVisible(false);
        }else{
            dispose();
        }
    }
    
    public String[] run(){
        this.setVisible(true);
        return screenSize;
    }
    
    
    
    
}
