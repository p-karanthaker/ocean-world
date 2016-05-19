package uk.ac.aston.dc2300.ocean.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import uk.ac.aston.dc2300.ocean.world.ModelConstants;

public class OptionsView extends JFrame {
	private static final long serialVersionUID = -3923021036043303514L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public OptionsView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		this.setDefaultCloseOperation(
			      WindowConstants.HIDE_ON_CLOSE);
		
		// Labels
		
		JLabel lblSimulationLength = new JLabel("Simulation Length: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSimulationLength, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSimulationLength, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblSimulationLength);
		
		JLabel lblRNGSeed = new JLabel("RNG Seed: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblRNGSeed, 6, SpringLayout.SOUTH, lblSimulationLength);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblRNGSeed, 0, SpringLayout.WEST, lblSimulationLength);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblRNGSeed, 101, SpringLayout.WEST, contentPane);
		contentPane.add(lblRNGSeed);
		
		JLabel lblOceanWidth = new JLabel("Ocean Width: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOceanWidth, 6, SpringLayout.SOUTH, lblRNGSeed);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOceanWidth, 0, SpringLayout.WEST, lblSimulationLength);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblOceanWidth, 101, SpringLayout.WEST, contentPane);
		contentPane.add(lblOceanWidth);

		JLabel lblOceanDepth = new JLabel("Ocean Depth: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOceanDepth, 6, SpringLayout.SOUTH, lblOceanWidth);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOceanDepth, 0, SpringLayout.WEST, lblSimulationLength);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblOceanDepth, 0, SpringLayout.EAST, lblSimulationLength);
		contentPane.add(lblOceanDepth);
		
		JLabel lblCreationOdds = new JLabel("Creation Odds");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblCreationOdds, -130, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblCreationOdds);
		
		JLabel lblBreedingOdds = new JLabel("Breeding Odds");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBreedingOdds, 147, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCreationOdds, -6, SpringLayout.WEST, lblBreedingOdds);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBreedingOdds, 0, SpringLayout.NORTH, lblCreationOdds);
		contentPane.add(lblBreedingOdds);
		
		JLabel lblMaxAge = new JLabel("Max Age");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMaxAge, 0, SpringLayout.NORTH, lblCreationOdds);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMaxAge, 6, SpringLayout.EAST, lblBreedingOdds);
		contentPane.add(lblMaxAge);
		
		JLabel lblBreedingAge = new JLabel("Breeding Age");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBreedingAge, 0, SpringLayout.NORTH, lblCreationOdds);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBreedingAge, 6, SpringLayout.EAST, lblMaxAge);
		contentPane.add(lblBreedingAge);
		
		JLabel lblNutritionalValue = new JLabel("Nutritional Value");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNutritionalValue, 6, SpringLayout.EAST, lblBreedingAge);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNutritionalValue, 0, SpringLayout.SOUTH, lblCreationOdds);
		contentPane.add(lblNutritionalValue);
		
		JLabel lblSardine = new JLabel("Sardine: ");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSardine, 0, SpringLayout.WEST, lblSimulationLength);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblSardine, 48, SpringLayout.WEST, lblSimulationLength);
		contentPane.add(lblSardine);
		
		JLabel lblShark = new JLabel("Shark: ");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblShark, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblShark, -105, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblShark, -366, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSardine, 6, SpringLayout.SOUTH, lblShark);
		contentPane.add(lblShark);
		
		JLabel lblPlankton = new JLabel("Plankton: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPlankton, 6, SpringLayout.SOUTH, lblSardine);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPlankton, 0, SpringLayout.WEST, lblSimulationLength);
		contentPane.add(lblPlankton);
		
		// Spinners
		
		JSpinner spinSimulationLength = new JSpinner();
		spinSimulationLength.setModel(new SpinnerNumberModel(ModelConstants.SIMULATION_LENGTH, new Integer(100), null, new Integer(50)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinSimulationLength, 6, SpringLayout.EAST, lblSimulationLength);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinSimulationLength, 0, SpringLayout.SOUTH, lblSimulationLength);
		contentPane.add(spinSimulationLength);
		
		JSpinner spinRNGSeed = new JSpinner();
		spinRNGSeed.setModel(new SpinnerNumberModel(ModelConstants.RNG_SEED, new Integer(20), null, new Integer(1)));
		sl_contentPane.putConstraint(SpringLayout.NORTH, spinRNGSeed, 0, SpringLayout.SOUTH, spinSimulationLength);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinRNGSeed, 0, SpringLayout.EAST, spinSimulationLength);
		contentPane.add(spinRNGSeed);
		
		JSpinner spinOceanWidth = new JSpinner();
		spinOceanWidth.setModel(new SpinnerNumberModel(ModelConstants.OCEAN_WIDTH, new Integer(50), null, new Integer(50)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinOceanWidth, 0, SpringLayout.WEST, spinSimulationLength);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinOceanWidth, 0, SpringLayout.SOUTH, lblOceanWidth);
		contentPane.add(spinOceanWidth);
		
		JSpinner spinOceanDepth = new JSpinner();
		spinOceanDepth.setModel(new SpinnerNumberModel(ModelConstants.OCEAN_DEPTH, new Integer(50), null, new Integer(50)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinOceanDepth, 0, SpringLayout.WEST, spinSimulationLength);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinOceanDepth, 0, SpringLayout.SOUTH, lblOceanDepth);
		contentPane.add(spinOceanDepth);
		
		JSpinner spinSharkCreationOdds = new JSpinner();
		spinSharkCreationOdds.setModel(new SpinnerNumberModel(ModelConstants.CREATION_ODDS_SHARK, new Float(0.05f), null, new Float(0.05f)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinSharkCreationOdds, -48, SpringLayout.EAST, lblCreationOdds);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinSharkCreationOdds, 0, SpringLayout.SOUTH, lblShark);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinSharkCreationOdds, 0, SpringLayout.EAST, lblCreationOdds);
		contentPane.add(spinSharkCreationOdds);
		
		JSpinner spinSardineCreationOdds = new JSpinner();
		spinSardineCreationOdds.setModel(new SpinnerNumberModel(ModelConstants.CREATION_ODDS_SARDINE, new Float(0.05f), null, new Float(0.05f)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinSardineCreationOdds, 0, SpringLayout.WEST, spinSharkCreationOdds);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinSardineCreationOdds, 0, SpringLayout.SOUTH, lblSardine);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinSardineCreationOdds, 0, SpringLayout.EAST, lblCreationOdds);
		contentPane.add(spinSardineCreationOdds);
		
		JSpinner spinPlanktonCreationOdds = new JSpinner();
		spinPlanktonCreationOdds.setModel(new SpinnerNumberModel(ModelConstants.CREATION_ODDS_PLANKTON, new Float(0.05f), null, new Float(0.05f)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinPlanktonCreationOdds, 0, SpringLayout.WEST, spinSharkCreationOdds);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinPlanktonCreationOdds, 0, SpringLayout.SOUTH, lblPlankton);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinPlanktonCreationOdds, 0, SpringLayout.EAST, lblCreationOdds);
		contentPane.add(spinPlanktonCreationOdds);
		
		JSpinner spinSharkBreedingOdds = new JSpinner();
		spinSharkBreedingOdds.setModel(new SpinnerNumberModel(ModelConstants.BREEDING_ODDS_SHARK, new Float(0.1f), null, new Float(0.1f)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinSharkBreedingOdds, -48, SpringLayout.EAST, lblBreedingOdds);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinSharkBreedingOdds, 0, SpringLayout.SOUTH, lblShark);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinSharkBreedingOdds, 0, SpringLayout.EAST, lblBreedingOdds);
		contentPane.add(spinSharkBreedingOdds);
		
		JSpinner spinSardineBreedingOdds = new JSpinner();
		spinSardineBreedingOdds.setModel(new SpinnerNumberModel(ModelConstants.BREEDING_ODDS_SARDINE, new Float(0.1f), null, new Float(0.1f)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinSardineBreedingOdds, 0, SpringLayout.WEST, spinSharkBreedingOdds);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinSardineBreedingOdds, 0, SpringLayout.SOUTH, lblSardine);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinSardineBreedingOdds, 0, SpringLayout.EAST, lblBreedingOdds);
		contentPane.add(spinSardineBreedingOdds);
		
		JSpinner spinPlanktonBreedingOdds = new JSpinner();
		spinPlanktonBreedingOdds.setModel(new SpinnerNumberModel(ModelConstants.BREEDING_ODDS_PLANKTON, new Float(0.1f), null, new Float(0.1f)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinPlanktonBreedingOdds, 0, SpringLayout.WEST, spinSharkBreedingOdds);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinPlanktonBreedingOdds, 0, SpringLayout.SOUTH, lblPlankton);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinPlanktonBreedingOdds, 0, SpringLayout.EAST, lblBreedingOdds);
		contentPane.add(spinPlanktonBreedingOdds);
		
		JSpinner spinSharkMaxAge = new JSpinner();
		spinSharkMaxAge.setModel(new SpinnerNumberModel(ModelConstants.MAXIMUM_AGE_SHARK, new Integer(1), null, new Integer(1)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinSharkMaxAge, 0, SpringLayout.WEST, lblMaxAge);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinSharkMaxAge, 0, SpringLayout.SOUTH, lblShark);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinSharkMaxAge, 0, SpringLayout.EAST, lblMaxAge);
		contentPane.add(spinSharkMaxAge);
		
		JSpinner spinSardineMaxAge = new JSpinner();
		spinSardineMaxAge.setModel(new SpinnerNumberModel(ModelConstants.MAXIMUM_AGE_SARDINE, new Integer(1), null, new Integer(1)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinSardineMaxAge, 0, SpringLayout.WEST, lblMaxAge);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinSardineMaxAge, 0, SpringLayout.SOUTH, lblSardine);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinSardineMaxAge, 0, SpringLayout.EAST, lblMaxAge);
		contentPane.add(spinSardineMaxAge);
		
		JSpinner spinPlanktonMaxAge = new JSpinner();
		spinPlanktonMaxAge.setModel(new SpinnerNumberModel(ModelConstants.MAXIMUM_AGE_PLANKTON, new Integer(1), null, new Integer(1)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinPlanktonMaxAge, 0, SpringLayout.WEST, lblMaxAge);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinPlanktonMaxAge, 0, SpringLayout.SOUTH, lblPlankton);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinPlanktonMaxAge, 0, SpringLayout.EAST, lblMaxAge);
		contentPane.add(spinPlanktonMaxAge);
		
		JSpinner spinSharkBreedingAge = new JSpinner();
		spinSharkBreedingAge.setModel(new SpinnerNumberModel(ModelConstants.BREEDING_AGE_SHARK, new Integer(0), null, new Integer(1)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinSharkBreedingAge, -48, SpringLayout.EAST, lblBreedingAge);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinSharkBreedingAge, 0, SpringLayout.SOUTH, lblShark);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinSharkBreedingAge, 0, SpringLayout.EAST, lblBreedingAge);
		contentPane.add(spinSharkBreedingAge);
		
		JSpinner spinSardineBreedingAge = new JSpinner();
		spinSardineBreedingAge.setModel(new SpinnerNumberModel(ModelConstants.BREEDING_AGE_SARDINE, new Integer(0), null, new Integer(1)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinSardineBreedingAge, 0, SpringLayout.WEST, spinSharkBreedingAge);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinSardineBreedingAge, 0, SpringLayout.SOUTH, lblSardine);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinSardineBreedingAge, 0, SpringLayout.EAST, lblBreedingAge);
		contentPane.add(spinSardineBreedingAge);
		
		JSpinner spinPlanktonBreedingAge = new JSpinner();
		spinPlanktonBreedingAge.setModel(new SpinnerNumberModel(ModelConstants.BREEDING_AGE_PLANKTON, new Integer(0), null, new Integer(1)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinPlanktonBreedingAge, 0, SpringLayout.WEST, spinSharkBreedingAge);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinPlanktonBreedingAge, 0, SpringLayout.SOUTH, lblPlankton);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinPlanktonBreedingAge, 0, SpringLayout.EAST, lblBreedingAge);
		contentPane.add(spinPlanktonBreedingAge);
		
		JSpinner spinSardineNutritionalValue = new JSpinner();
		spinSardineNutritionalValue.setModel(new SpinnerNumberModel(ModelConstants.NUTRITIONAL_VALUE_SARDINE, new Integer(1), null, new Integer(1)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinSardineNutritionalValue, -48, SpringLayout.EAST, lblNutritionalValue);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinSardineNutritionalValue, 0, SpringLayout.SOUTH, lblSardine);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinSardineNutritionalValue, 0, SpringLayout.EAST, lblNutritionalValue);
		contentPane.add(spinSardineNutritionalValue);
		
		JSpinner spinPlanktonNutritionalValue = new JSpinner();
		spinPlanktonNutritionalValue.setModel(new SpinnerNumberModel(ModelConstants.NUTRITIONAL_VALUE_PLANKTON, new Integer(1), null, new Integer(1)));
		sl_contentPane.putConstraint(SpringLayout.WEST, spinPlanktonNutritionalValue, 0, SpringLayout.WEST, spinSardineNutritionalValue);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, spinPlanktonNutritionalValue, 0, SpringLayout.SOUTH, lblPlankton);
		sl_contentPane.putConstraint(SpringLayout.EAST, spinPlanktonNutritionalValue, 0, SpringLayout.EAST, lblNutritionalValue);
		contentPane.add(spinPlanktonNutritionalValue);
		setVisible(true);
	}
}
