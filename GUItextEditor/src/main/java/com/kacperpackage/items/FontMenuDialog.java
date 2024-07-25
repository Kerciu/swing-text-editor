package main.java.com.kacperpackage.items;

import main.java.com.kacperpackage.GUI.TextEditorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FontMenuDialog extends JDialog {
    private TextEditorGUI textEditorGUI;

    public FontMenuDialog(TextEditorGUI textEditorGUI) {
        this.textEditorGUI = textEditorGUI;
        setTitle("Font Settings");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(425, 350);
        setLocationRelativeTo(textEditorGUI);
        setModal(true);

        setLayout(null);
        addFontMenuDialogComponents();
    }

    private void addFontMenuDialogComponents() {
        createFontLabel();

        // display current font and fonts available
        JPanel fontPanel = createFontPanel();

        // display current and available fonts
        addMenuComponents(fontPanel);
        add(fontPanel);
    }

    private void createFontLabel() {
        JLabel fontLabel = new JLabel("Font");
        fontLabel.setBounds(10, 5, 125, 10);
        add(fontLabel);
    }

    private JPanel createFontPanel() {
        JPanel fontPanel = new JPanel();
        fontPanel.setBounds(10, 15, 125, 250);
        return fontPanel;
    }

    private void addMenuComponents(JPanel fontPanel) {
        addFontChooser(fontPanel);
        addFontStyler();
        addFontSizer();
        addFontColorer();
        addActionButtons();
    }

    private void addFontChooser(JPanel fontPanel) {
        new FontChooser(textEditorGUI, fontPanel);
    }

    private void addFontStyler() {
        new FontStyler(textEditorGUI, this);
    }

    private void addFontSizer() {
        new FontSizer(textEditorGUI, this);
    }

    private void addFontColorer() {
        new FontColorer(textEditorGUI, this);
    }

    private void addActionButtons() {
        add(createApplyButton());
        add(createCancelButton());
    }

    private JButton createApplyButton() {
        JButton applyButton = new JButton("Apply");
        applyButton.setBounds(230, 265, 75, 25);
        return applyButton;
    }

    private JButton createCancelButton() {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(315, 265, 75, 25);
        return cancelButton;
    }

    private void addActionToApplyButton(JButton applyButton) {
        applyButton.addActionListener(
                createApplyButtonActionListener(applyButton)
        );
    }

    private ActionListener createApplyButtonActionListener(JButton applyButton) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
    }

    private void addActionToCancelButton(JButton cancelButton) {
        cancelButton.addActionListener(
                createCancelButtonActionListener(cancelButton)
        );
    }

    private ActionListener createCancelButtonActionListener(JButton cancelButton) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
    }
}
