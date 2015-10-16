package view.menupanel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import model.BoardModel;

public class MenuArea extends JPanel{
	private InstructionPanel instructionPanel;
	private CommandPanel commandPanel;
	private OutputPanel outputPanel;
	
	public MenuArea(){
		this.setLayout(new BorderLayout());
		this.setSize(400,600);
		
		this.instructionPanel = new InstructionPanel();
		this.add(instructionPanel, BorderLayout.PAGE_START);
		
		this.commandPanel = new CommandPanel();
		this.add(commandPanel, BorderLayout.CENTER);
		
		this.outputPanel = new OutputPanel();
		this.add(outputPanel, BorderLayout.PAGE_END);
		
//		BoardModel.getInstance().setMenuArea(this);
	}
	
	public CommandPanel getCommandPanel(){
		return this.commandPanel;
	}
	public OutputPanel getOutputPanel(){
		return this.outputPanel;
	}
}
