import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TextEditorGUI extends JFrame {
    // file explorer
    private JFileChooser fileChooser;

    public TextEditorGUI() {
        super("TextEditor");
        setSize(480, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // fileChooser set up
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("src/assets"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        addGuiComponents();
    }

    private void addGuiComponents() {
        addToolBar();
        addTextArea();
    }

    private void addToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        // ADD MENU BAR
        JMenuBar menuBar = new JMenuBar();
        toolBar.add(menuBar);

        // ADD MENUS
        menuBar.add(addFileMenu());

        add(toolBar, BorderLayout.NORTH);
    }

    private JMenu addFileMenu() {
        JMenu fileMenu = new JMenu("File");

        // "new file" functionality
        executeNewFunctionality(fileMenu);

        // "open file" functionality
        executeOpenFunctionality(fileMenu);

        // "save" functionality
        executeSaveFunctionality(fileMenu);

        // "save as" functionality
        executeSaveAsFunctionality(fileMenu);

        // "exit" functionality
        executeExitFunctionality(fileMenu);

        return fileMenu;
    }

    private void addTextArea() {
        JTextArea textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);
    }

    private void executeNewFunctionality(JMenu fileMenu) {
        JMenuItem newMenuItem = new JMenuItem("New");
        fileMenu.add(newMenuItem);
    }

    private void executeOpenFunctionality(JMenu fileMenu) {
        JMenuItem openMenuItem = new JMenuItem("Open");
        fileMenu.add(openMenuItem);
    }

    private void executeSaveFunctionality(JMenu fileMenu) {
        JMenuItem saveMenuItem = new JMenuItem("Save");
        fileMenu.add(saveMenuItem);
    }

    private void executeSaveAsFunctionality(JMenu fileMenu) {
        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        fileMenu.add(saveAsMenuItem);

        saveAsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.showSaveDialog(TextEditorGUI.this);
            }
        });
    }

    private void executeExitFunctionality(JMenu fileMenu) {
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
    }

}
