package uk.ac.aston.dc2300.ocean.world;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * OptionView sets up a JDialog in a GridLayout and displays
 * all JSpinner items which allow the user to edit the ModelConstants
 * in a friendly way.
 * 
 * @author Karan Thaker / Orry Edwards
 *
 */
public class OptionsView extends JDialog {
	
	/**
	 * Auto generated serialVersionUID
	 */
	private static final long serialVersionUID = -3474651107847519005L;
	
	/**
	 * List to hold all JLabel objects for each ModelConstants field
	 */
	private List<JLabel> labels = new ArrayList<JLabel>();
	
	/**
	 * List to hold all JSpinner objects which allow editing to all ModelConstants fields
	 */
	private List<JSpinner> spinners = new ArrayList<JSpinner>();
	
	/**
	 * JButton to confirm/save configuration settings
	 */
	private JButton buttonOK = new JButton("OK");
	
	/**
	 * JButton to cancel out of the configuration
	 */
	private JButton buttonCancel = new JButton("Cancel");
	
	/**
	 * Constructor to create the OptionsView object.
	 * Sets the layout, adds all items, and configures JDialog settings.
	 */
	public OptionsView() {
		setTitle("Simulator Options");
		
		GridLayout layout = new GridLayout(0, 2);
		setLayout(layout);
		buildComponents();
		for(int i=0; i < labels.size(); i++) {
			add(labels.get(i));
			add(spinners.get(i));
		}
		add(buttonCancel);
		add(buttonOK);
		
		setButtonListeners(this);
		
		setModal(true);
		setAlwaysOnTop (true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setLocation(100, 50);
		
		pack();
		setVisible(true);
	}
	
	/**
	 * Sets listeners for the JButtons
	 * @param frame the frame in which to pop up message dialogs
	 */
	private void setButtonListeners(final JDialog frame) {
		buttonOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setConfigParams();
				JOptionPane.showMessageDialog(frame, "Press Menu > Restart Simulation for the new changes to take effect.");
				dispose();
			}
		});
		
		buttonCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	/**
	 * Sets the configuration fields in ModelConstants with new values input by user
	 */
	private void setConfigParams() {
		ModelConstants.SIMULATION_LENGTH = (Integer) spinners.get(0).getValue();
		ModelConstants.RNG_SEED = (Integer) spinners.get(1).getValue();
		ModelConstants.OCEAN_WIDTH = (Integer) spinners.get(2).getValue();
		ModelConstants.OCEAN_DEPTH = (Integer) spinners.get(3).getValue();
		ModelConstants.CREATION_ODDS_SHARK = (Double) spinners.get(4).getValue();
		ModelConstants.BREEDING_ODDS_SHARK = (Double) spinners.get(5).getValue();
		ModelConstants.MAXIMUM_AGE_SHARK = (Integer) spinners.get(6).getValue();
		ModelConstants.BREEDING_AGE_SHARK = (Integer) spinners.get(7).getValue();
		ModelConstants.CREATION_ODDS_SARDINE = (Double) spinners.get(8).getValue();
		ModelConstants.BREEDING_ODDS_SARDINE = (Double) spinners.get(9).getValue();
		ModelConstants.MAXIMUM_AGE_SARDINE = (Integer) spinners.get(10).getValue();
		ModelConstants.BREEDING_AGE_SARDINE = (Integer) spinners.get(11).getValue();
		ModelConstants.NUTRITIONAL_VALUE_SARDINE = (Integer) spinners.get(12).getValue();
		ModelConstants.CREATION_ODDS_PLANKTON = (Double) spinners.get(13).getValue();
		ModelConstants.BREEDING_ODDS_PLANKTON = (Double) spinners.get(14).getValue();
		ModelConstants.MAXIMUM_AGE_PLANKTON = (Integer) spinners.get(15).getValue();
		ModelConstants.BREEDING_AGE_PLANKTON = (Integer) spinners.get(16).getValue();
		ModelConstants.NUTRITIONAL_VALUE_PLANKTON = (Integer) spinners.get(17).getValue();
	}
	
	/**
	 * Create each JLabel and JSpinner object and add it to the List
	 */
	public void buildComponents() {
		JLabel lblSimulatorLength = new JLabel("Simulation Length"); 
		labels.add(lblSimulatorLength);
		
		JLabel lblRNGSeed = new JLabel("RNG Seed"); 
		labels.add(lblRNGSeed);
		
		JLabel lblOceanWidth = new JLabel("Ocean Width"); 
		labels.add(lblOceanWidth);
		
		JLabel lblOceanDepth = new JLabel("Ocean Depth"); 
		labels.add(lblOceanDepth);
		
		
		JLabel lblSharkCreationOdds = new JLabel("Shark Creation Odds"); 
		labels.add(lblSharkCreationOdds);
		
		JLabel lblSharkBreedingOdds = new JLabel("Shark Breeding Odds"); 
		labels.add(lblSharkBreedingOdds);
		
		JLabel lblSharkMaximumAge = new JLabel("Shark Maximum Age"); 
		labels.add(lblSharkMaximumAge);
		
		JLabel lblSharkBreedingAge = new JLabel("Shark Breeding Age"); 
		labels.add(lblSharkBreedingAge);
		
		
		JLabel lblSardineCreationOdds = new JLabel("Sardine Creation Odds"); 
		labels.add(lblSardineCreationOdds);
		
		JLabel lblSardineBreedingOdds = new JLabel("Sardine Breeding Odds"); 
		labels.add(lblSardineBreedingOdds);
		
		JLabel lblSardineMaximumAge = new JLabel("Sardine Maximum Age"); 
		labels.add(lblSardineMaximumAge);
		
		JLabel lblSardineBreedingAge = new JLabel("Sardine Breeding Age"); 
		labels.add(lblSardineBreedingAge);
		
		JLabel lblSardineNutritionalValue = new JLabel("Sardine Nutritional Value"); 
		labels.add(lblSardineNutritionalValue);
				
		
		JLabel lblPlanktonCreationOdds = new JLabel("Plankton Creation Odds"); 
		labels.add(lblPlanktonCreationOdds);
		
		JLabel lblPlanktonBreedingOdds = new JLabel("Plankton Breeding Odds"); 
		labels.add(lblPlanktonBreedingOdds);
		
		JLabel lblPlanktonMaximumAge = new JLabel("Plankton Maximum Age"); 
		labels.add(lblPlanktonMaximumAge);
		
		JLabel lblPlanktonBreedingAge = new JLabel("Plankton Breeding Age"); 
		labels.add(lblPlanktonBreedingAge);
		
		JLabel lblPlanktonNutritionalValue = new JLabel("Plankton Nutritional Value"); 
		labels.add(lblPlanktonNutritionalValue);
				
		
		JSpinner spinSimulationLenth = new JSpinner(new SpinnerNumberModel(ModelConstants.SIMULATION_LENGTH, 100, 10000, 1));
		spinners.add(spinSimulationLenth);
		
		JSpinner spinRNGSeed = new JSpinner(new SpinnerNumberModel(ModelConstants.RNG_SEED, 1, 1000, 1)); 
		spinners.add(spinRNGSeed);
		
		JSpinner spinOceanWidth = new JSpinner(new SpinnerNumberModel(ModelConstants.OCEAN_WIDTH, 50, 500, 5)); 
		spinners.add(spinOceanWidth);
		
		JSpinner spinOceanDepth = new JSpinner(new SpinnerNumberModel(ModelConstants.OCEAN_DEPTH, 50, 500, 5)); 
		spinners.add(spinOceanDepth);
				
		JSpinner spinSharkCreationOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.CREATION_ODDS_SHARK, 0.01, 1, 0.01));
		spinners.add(spinSharkCreationOdds);
		
		JSpinner spinSharkBreedingOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_ODDS_SHARK, 0.01, 1, 0.01)); 
		spinners.add(spinSharkBreedingOdds);
		
		JSpinner spinSharkMaximumAge = new JSpinner(new SpinnerNumberModel(ModelConstants.MAXIMUM_AGE_SHARK, 0, null, 1)); 
		spinners.add(spinSharkMaximumAge);
		
		JSpinner spinSharkBreedingAge = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_AGE_SHARK, 0, null, 1)); 
		spinners.add(spinSharkBreedingAge);
				
		JSpinner spinSardineCreationOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.CREATION_ODDS_SARDINE, 0.01, 1, 0.01)); 
		spinners.add(spinSardineCreationOdds);
		
		JSpinner spinSardineBreedingOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_ODDS_SARDINE, 0.01, 1, 0.01)); 
		spinners.add(spinSardineBreedingOdds);
		
		JSpinner spinSardineMaximumAge = new JSpinner(new SpinnerNumberModel(ModelConstants.MAXIMUM_AGE_SARDINE, 0, null, 1));
		spinners.add(spinSardineMaximumAge);
		
		JSpinner spinSardineBreedingAge = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_AGE_SARDINE, 0, null, 1));
		spinners.add(spinSardineBreedingAge);
		
		JSpinner spinSardineNutritionalValue = new JSpinner(new SpinnerNumberModel(ModelConstants.NUTRITIONAL_VALUE_SARDINE, 0, null, 1));
		spinners.add(spinSardineNutritionalValue);
		
		JSpinner spinPlanktonCreationOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.CREATION_ODDS_PLANKTON, 0.01, 1, 0.01));
		spinners.add(spinPlanktonCreationOdds);
		
		JSpinner spinPlanktonBreedingOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_ODDS_PLANKTON, 0.01, 1, 0.01)); 
		spinners.add(spinPlanktonBreedingOdds);
		
		JSpinner spinPlanktonMaximumAge = new JSpinner(new SpinnerNumberModel(ModelConstants.MAXIMUM_AGE_PLANKTON, 0, null, 1));
		spinners.add(spinPlanktonMaximumAge);
		
		JSpinner spinPlanktonBreedingAge = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_AGE_PLANKTON, 0, null, 1));
		spinners.add(spinPlanktonBreedingAge);
		
		JSpinner spinPlanktonNutritionalValue = new JSpinner(new SpinnerNumberModel(ModelConstants.NUTRITIONAL_VALUE_PLANKTON, 0, null, 1));
		spinners.add(spinPlanktonNutritionalValue);
	}
	
}
