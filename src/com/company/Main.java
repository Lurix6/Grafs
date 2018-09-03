package com.company;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        JFrame f = new JFrame("TITLE");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(600 ,600));
        f.setLocationRelativeTo(null);
        f.setMinimumSize(new Dimension(600,300));
        f.setMaximumSize(new Dimension(900,1000));
        MainPanel panel = new MainPanel();
        JButton sin, cos, tan , ctan, plus, minus, plusPoint, minusPoint, unitSegmentPlus,unitSegmentMinus;
        JLabel label = new JLabel("Масштаб");
        JLabel howManyPoint = new JLabel("Кылькысть точок");


        plusPoint = new JButton("+");
        minusPoint = new JButton("-");
        plus = new JButton("+");
        minus = new JButton("-");

        sin = new JButton("sin");
        cos = new JButton("cos");
        tan = new JButton("tan");
        ctan = new JButton("ctan");
        JPanel panelForBtn = new JPanel();
        JPanel panelForChangSize = new JPanel();


        panelForBtn.add(sin);
        panelForBtn.add(cos);
        panelForBtn.add(tan);
        panelForBtn.add(ctan);
        panelForChangSize.add(label);
        panelForChangSize.add(plus);
        panelForChangSize.add(minus);
        panelForChangSize.add(howManyPoint);
        panelForChangSize.add(plusPoint);
        panelForChangSize.add(minusPoint);
        f.add(panelForBtn,BorderLayout.PAGE_END);
        f.add(panel,BorderLayout.CENTER);
        f.add(panelForChangSize,BorderLayout.PAGE_START);


        sin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setS("sin");
                panel.repaint();
            }
        });
        cos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setS("cos");
                panel.repaint();
            }
        });
        tan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setS("tng");
                panel.repaint();
            }
        });
        ctan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setS("ctng");
                panel.repaint();
            }
        });

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.mainColibr = panel.mainColibr -2;
                panel.repaint();

            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.mainColibr = panel.mainColibr +2;
                panel.repaint();

            }
        });

        plusPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setHowManiPoint(panel.howManiPoint-0.01);
                panel.repaint();

            }
        });

        minusPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setHowManiPoint(panel.howManiPoint+0.01);

                panel.repaint();
            }
        });

    }



}

class MainPanel extends JPanel {
    int width, height, X0,Y0;
    Graphics g;
    int mainColibr = 20;
    int secondColibrX, secondColibrY ;
    String s = "sin";
    double howManiPoint = 0.05;

    public void setHowManiPoint(double howManiPoint) {
        this.howManiPoint = howManiPoint;
    }

    public void setMainColibr(int mainColibr) {
        this.mainColibr = mainColibr;
    }
    public void setS(String s) {
        this.s = s;
    }

    public MainPanel() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.g = g;
        width = super.getWidth();
        height = super.getHeight();
        X0 = width/2;
        Y0 = height/2;


        g.drawLine(width/2,0,width/2, height);

        g.drawLine(0,height/2,width, height/2);
        secondColibrX = width/mainColibr;
        secondColibrY = height/mainColibr;
        drawSmallLine(X0,Y0,g);

        if (s.equalsIgnoreCase("sin"))drawGragiSin();
        if (s.equalsIgnoreCase("cos"))drawGragiCos();
        if (s.equalsIgnoreCase("tng"))drawGragiTng();
        if (s.equalsIgnoreCase("ctng"))drawGragiCtn();

    }

    public void drawGragiSin(){
        for (double i = -X0; i < X0; i+=howManiPoint) {
            g.drawOval((int) ((i*secondColibrX)+X0), (int) ((Math.sin(i)*(-1)*secondColibrY*3.14)+Y0),1,1);
        }
    }

    public void drawGragiCos(){
        for (double i = -X0; i < X0; i+=howManiPoint) {
            g.drawOval((int) ((i*secondColibrX)+X0), (int) ((Math.cos(i)*(-1)*secondColibrY*3.14)+Y0),1,1);
        }
    }


    public void drawGragiTng(){
        for (double i = -X0; i < X0; i+=howManiPoint) {
            g.drawOval((int) ((i*secondColibrX)+X0), (int) ((Math.tan(i)*(-1)*secondColibrY*3.14)+Y0),1,1);
        }
    }

    public void drawGragiCtn(){
        for (double i = -X0; i < X0; i+=howManiPoint) {
            g.drawOval((int) ((i*secondColibrX)+X0), (int) ((Math.atan(i)*(-1)*secondColibrY*3.14)+Y0),1,1);
        }
    }

    private void drawSmallLine(int X0, int Y0, Graphics g){


//   X  AXIS
        for (int i = - mainColibr/2 ; i < mainColibr/2+1; i++) {
            g.drawLine((int) (secondColibrX*3.14*i+X0), Y0-5, (int) (secondColibrX*3.14*i+X0), Y0+5);
        }


//   Y  AXIS
        for (int i = - mainColibr/2 ; i < mainColibr/2+1; i++) {
            g.drawLine(X0-5, (int) (secondColibrY*3.14*i+Y0),X0+5, (int) (secondColibrY*3.14*i+Y0));
        }
    }


}
