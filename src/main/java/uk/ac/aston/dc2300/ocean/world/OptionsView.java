package uk.ac.aston.dc2300.ocean.world;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;

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
		JSpinner spinSimulationLenth = new JSpinner(); 
		spinners.add(spinSimulationLenth);
		
		JSpinner spinRNGSeed = new JSpinner(); 
		spinners.add(spinRNGSeed);
		
		JSpinner spinOceanWidth = new JSpinner(); 
		spinners.add(spinOceanWidth);
		
		JSpinner spinOceanDepth = new JSpinner(); 
		spinners.add(spinOceanDepth);
				
		JSpinner spinSharkCreationOdds = new JSpinner(); 
		spinners.add(spinSharkCreationOdds);
		
		JSpinner spinSharkBreedingOdds = new JSpinner(); 
		spinners.add(spinSharkBreedingOdds);
		
		JSpinner spinSharkMaximumAge = new JSpinner(); 
		spinners.add(spinSharkMaximumAge);
		
		JSpinner spinSharkBreedingAge = new JSpinner(); 
		spinners.add(spinSharkBreedingAge);
				
		JSpinner spinSardineCreationOdds = new JSpinner(); 
		spinners.add(spinSardineCreationOdds);
		
		JSpinner spinSardineBreedingOdds = new JSpinner(); 
		spinners.add(spinSardineBreedingOdds);
		
		JSpinner spinSardineMaximumAge = new JSpinner(); 
		spinners.add(spinSardineMaximumAge);
		
		JSpinner spinSardineBreedingAge = new JSpinner(); 
		spinners.add(spinSardineBreedingAge);
		
		JSpinner spinSardineNutritionalValue = new JSpinner(); 
		spinners.add(spinSardineNutritionalValue);
		
		JSpinner spinPlanktonCreationOdds = new JSpinner(); 
		spinners.add(spinPlanktonCreationOdds);
		
		JSpinner spinPlanktonBreedingOdds = new JSpinner(); 
		spinners.add(spinPlanktonBreedingOdds);
		
		JSpinner spinPlanktonMaximumAge = new JSpinner(); 
		spinners.add(spinPlanktonMaximumAge);
		
		JSpinner spinPlanktonBreedingAge = new JSpinner(); 
		spinners.add(spinPlanktonBreedingAge);
		
		JSpinner spinPlanktonNutritionalValue = new JSpinner(); 
		spinners.add(spinPlanktonNutritionalValue);
		
		
	}
	
}
