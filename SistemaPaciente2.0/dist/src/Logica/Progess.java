/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author Desarrollo
 */
public class Progess extends SwingWorker<Integer, String> {

    private JLabel label;
    private JProgressBar jpbar;

    public Progess(JLabel label, JProgressBar jpbar) {
        this.label = label;
        this.jpbar = jpbar;

    }

    @Override
    protected Integer doInBackground() throws Exception {
        getLabel().setVisible(true);
        getJpbar().setVisible(true);
        getJpbar().setIndeterminate(true);
        //Proceso 
        try {
            for (int i = 0; i < 11; i++) {

                Thread.sleep(1000);
            }

        } catch (Exception e) {
        }

        getLabel().setVisible(false);
        getJpbar().setVisible(false);
        getJpbar().setIndeterminate(false);

        return 0;
    }

    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     * @return the jpbar
     */
    public JProgressBar getJpbar() {
        return jpbar;
    }

    /**
     * @param jpbar the jpbar to set
     */
    public void setJpbar(JProgressBar jpbar) {
        this.jpbar = jpbar;
    }

}
