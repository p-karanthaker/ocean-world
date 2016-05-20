package uk.ac.aston.dc2300.ocean.world;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class OptionsView extends JDialog {
	
	private static final long serialVersionUID = -3474651107847519005L;
	private List<JLabel> labels = new ArrayList<JLabel>();
	private List<JSpinner> spinners = new ArrayList<JSpinner>();
	private JButton buttonOK = new JButton("OK");
	private JButton buttonCancel = new JButton("Cancel");
	
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
		
		setModal(true);
		setAlwaysOnTop (true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setLocation(100, 50);
		
		pack();
		setVisible(true);
	}
	
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
				
		
		// TODO add in SpinnerModels for default,min,max,step values
		JSpinner spinSimulationLenth = new JSpinner(new SpinnerNumberModel(ModelConstants.SIMULATION_LENGTH
																		  ,100		// min
																		  ,10000	// max
																		  ,1));		// step
		spinners.add(spinSimulationLenth);
		
		JSpinner spinRNGSeed = new JSpinner(new SpinnerNumberModel(ModelConstants.RNG_SEED
																  ,1
																  ,1000
																  ,1)); 
		spinners.add(spinRNGSeed);
		
		JSpinner spinOceanWidth = new JSpinner(new SpinnerNumberModel(ModelConstants.OCEAN_WIDTH
																	 ,50
																	 ,500
																	 ,10)); 
		spinners.add(spinOceanWidth);
		
		JSpinner spinOceanDepth = new JSpinner(new SpinnerNumberModel(ModelConstants.OCEAN_DEPTH
																	 ,50
																	 ,500
																	 ,10)); 
		spinners.add(spinOceanDepth);
				
		JSpinner spinSharkCreationOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.CREATION_ODDS_SHARK, 0.05, 1, 0.05));
		spinners.add(spinSharkCreationOdds);
		
		JSpinner spinSharkBreedingOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_ODDS_SHARK, 0.05, 1, 0.05)); 
		spinners.add(spinSharkBreedingOdds);
		
		JSpinner spinSharkMaximumAge = new JSpinner(new SpinnerNumberModel(ModelConstants.MAXIMUM_AGE_SHARK, 0, null, 1)); 
		spinners.add(spinSharkMaximumAge);
		
		JSpinner spinSharkBreedingAge = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_AGE_SHARK, 0, null, 1)); 
		spinners.add(spinSharkBreedingAge);
				
		JSpinner spinSardineCreationOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.CREATION_ODDS_SARDINE, 0.05, 1, 0.05)); 
		spinners.add(spinSardineCreationOdds);
		
		JSpinner spinSardineBreedingOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_ODDS_SARDINE, 0.05, 1, 0.05)); 
		spinners.add(spinSardineBreedingOdds);
		
		JSpinner spinSardineMaximumAge = new JSpinner(new SpinnerNumberModel(ModelConstants.MAXIMUM_AGE_SARDINE, 0, null, 1));
		spinners.add(spinSardineMaximumAge);
		
		JSpinner spinSardineBreedingAge = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_AGE_SARDINE, 0, null, 1));
		spinners.add(spinSardineBreedingAge);
		
		JSpinner spinSardineNutritionalValue = new JSpinner(new SpinnerNumberModel(ModelConstants.NUTRITIONAL_VALUE_SARDINE, 0, null, 1));
		spinners.add(spinSardineNutritionalValue);
		
		JSpinner spinPlanktonCreationOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.CREATION_ODDS_PLANKTON, 0.05, 1, 0.05));
		spinners.add(spinPlanktonCreationOdds);
		
		JSpinner spinPlanktonBreedingOdds = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_ODDS_PLANKTON, 0.05, 1, 0.05)); 
		spinners.add(spinPlanktonBreedingOdds);
		
		JSpinner spinPlanktonMaximumAge = new JSpinner(new SpinnerNumberModel(ModelConstants.MAXIMUM_AGE_PLANKTON, 0, null, 1));
		spinners.add(spinPlanktonMaximumAge);
		
		JSpinner spinPlanktonBreedingAge = new JSpinner(new SpinnerNumberModel(ModelConstants.BREEDING_AGE_PLANKTON, 0, null, 1));
		spinners.add(spinPlanktonBreedingAge);
		
		JSpinner spinPlanktonNutritionalValue = new JSpinner(new SpinnerNumberModel(ModelConstants.NUTRITIONAL_VALUE_PLANKTON, 0, null, 1));
		spinners.add(spinPlanktonNutritionalValue);
		
		
	}
	
}
