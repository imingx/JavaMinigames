package com.gmm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    JButton button1 = null;
    JButton button2 = null;
    JButton button3 = null;
    CardLayout card = null;
    JPanel panel = null;

    GameFrame(){

        JPanel windows = new JPanel();

        GamePanelWithWall panelWithWall = new GamePanelWithWall();
        GamePanelWithoutWall panelWithoutWall = new GamePanelWithoutWall();
        GamePanelPongGame panelPongGame = new GamePanelPongGame();

        button1 = new JButton("贪吃蛇有边界");
        button2 = new JButton("贪吃蛇没有边界");
        button3 = new JButton("弹球游戏");

        card= new CardLayout();
        panel = new JPanel();
        panel.setLayout(card);

        windows.add(button1);
        windows.add(button2);
        windows.add(button3);

        panel.add(panelWithWall,"wall");
        panel.add(panelWithoutWall,"withoutWall");
        panel.add(panelPongGame,"PongGame");

        panel.add(windows,"01");
        card.show(panel,"01");


        this.add(panel);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panel,"wall");
                panelWithWall.setFocusable(true);
                panelWithWall.requestFocus();
                panelWithWall.startGame();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                card.show(panel,"withoutWall");
                panelWithoutWall.setFocusable(true);
                panelWithoutWall.requestFocus();
                panelWithoutWall.startGame();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panel,"PongGame");
                panelPongGame.setFocusable(true);
                panelPongGame.requestFocus();
            }
        });

        panelWithWall.button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panel,"01");
            }
        });
        panelWithoutWall.button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelWithoutWall.timer.stop();
                card.show(panel,"01");
            }
        });

        this.setBackground(Color.BLACK);
        this.setTitle("学习累了吗，玩点游戏歇一歇吧");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();//自动根据panel自动改变
        this.setVisible(true);//
        this.setLocationRelativeTo(null);
    }
}