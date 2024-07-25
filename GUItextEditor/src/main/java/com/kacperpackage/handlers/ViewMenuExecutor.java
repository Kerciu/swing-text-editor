package main.java.com.kacperpackage.handlers;

import main.java.com.kacperpackage.GUI.TextEditorGUI;
import main.java.com.kacperpackage.menus.ZoomMenu;

import javax.swing.*;

public class ViewMenuExecutor implements Executor{
    private TextEditorGUI textEditorGUI;
    private JMenu viewMenu;

    public ViewMenuExecutor(TextEditorGUI textEditorGUI, JMenu viewMenu) {
        this.textEditorGUI = textEditorGUI;
        this.viewMenu = viewMenu;
    }

    @Override
    public void addMenuItems() {
        addZoomMenu();
    }

    private void addZoomMenu() {
        new ZoomMenu(textEditorGUI, viewMenu);
    }
}
