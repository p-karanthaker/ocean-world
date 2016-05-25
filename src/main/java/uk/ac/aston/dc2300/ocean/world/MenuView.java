package uk.ac.aston.dc2300.ocean.world;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuView {

	private MenuView () {
		
	}
	
	public static JMenuBar createMenuBar(final JFrame parent) {
    	JMenu menu;
        JMenuItem optionsItem;
        JMenuItem restartSimulationItem;
        
        // Create the menu bar.
        JMenuBar menuBar = new JMenuBar();
        
    	// Menu
        menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        menu.getAccessibleContext().setAccessibleDescription(
                "Options Menu");
        menuBar.add(menu);
        
        // Options menu item
        optionsItem = new JMenuItem("Options", KeyEvent.VK_O);
        optionsItem.getAccessibleContext().setAccessibleDescription(
                "Configure simulation options.");
        menu.add(optionsItem);
        
        // Restart Simulation menu item
        restartSimulationItem = new JMenuItem("Restart Simulation", KeyEvent.VK_R);
        restartSimulationItem.getAccessibleContext().setAccessibleDescription(
                "Restart the simulation.");
        menu.add(restartSimulationItem);
        
        optionsItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new OptionsView();
				// TODO Add dialog which tells you to restart the simulation
			}
		});
        
        restartSimulationItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				final Simulator sim = Simulator.getInstance();
				new Thread() {
					@Override
					public void run() {
						sim.init(ModelConstants.OCEAN_WIDTH, ModelConstants.OCEAN_DEPTH);
						sim.startSimulation();
					}
				}.start();
				
				
			}
		});
        
		return menuBar;
    }
	
}
