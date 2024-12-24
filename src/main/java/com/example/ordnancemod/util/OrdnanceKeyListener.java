package com.example.ordnancemod.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OrdnanceKeyListener implements KeyListener {
    public static boolean altKeyPressed;
    public static boolean spaceKeyPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ALT && !altKeyPressed) {
            altKeyPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !spaceKeyPressed) {
            spaceKeyPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ALT) {
            altKeyPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_ALT) {
            spaceKeyPressed = false;
        }
    }
}
