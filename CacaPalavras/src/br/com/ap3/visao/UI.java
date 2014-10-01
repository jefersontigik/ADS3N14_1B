package br.com.ap3.visao;

import java.applet.*;
import java.awt.*;
import java.util.ArrayList;

import br.com.ap3.controle.ManipulaTabua;


public class UI extends Applet{
	private List lstPalavras;
	private Button btnAdiciona;
	private Button btnGera;
	private Button btnLimpa;
	private Label lblLista;
	private Label lblPalavra;
	private Label lblWidth;
	private Label lblHeight;
	private Label lblTabua;
	private TextField txtWidth;
	private TextField txtHeight;
	private TextField txtPalavra;
	private TextArea txtTabua;
	private Panel pnlWidth;
	private Panel pnlPalavras;	
	private Panel pnlBotoes;
	private Panel pnlTopo;

	public void init(){
		inicializaControles();
	}

	private void inicializaControles(){
//		this.setBounds(400, 300, 400,300);
		this.setSize(400, 300);
//		this.setLocation(300, 300);

		lstPalavras = new List(5,false);
		btnAdiciona = new Button("Adicionar");
		btnGera     = new Button("Gera Matriz");
		btnLimpa    = new Button("Reinicia");
		txtWidth    = new TextField();
		txtHeight   = new TextField();
		txtPalavra  = new TextField();
		txtTabua    = new TextArea();
		pnlWidth    = new Panel();
		pnlPalavras = new Panel();
		pnlBotoes   = new Panel();
		pnlTopo     = new Panel();
		lblLista    = new Label("Lista de Palavras:");
		lblWidth    = new Label("Largura:");
		lblHeight   = new Label("Altura:");
		lblTabua    = new Label("Caça Palavra");
		lblPalavra  = new Label("Palavra:");

		GridLayout grd1 = new GridLayout(2,2,4,4);
		pnlWidth.setLayout(grd1);
		pnlWidth.add(lblWidth);
		pnlWidth.add(txtWidth);
		pnlWidth.add(lblHeight);
		pnlWidth.add(txtHeight);

		pnlPalavras.setLayout(grd1);
		pnlPalavras.add(lblPalavra);
		pnlPalavras.add(txtPalavra);
		pnlPalavras.add(btnAdiciona);
		
//		GridLayout grd2 = new GridLayout(2,1,4,4);

		pnlBotoes.add(btnGera);
		pnlBotoes.add(btnLimpa);

		pnlTopo.add(pnlWidth);
		pnlTopo.add(pnlPalavras);
		pnlTopo.add(lstPalavras);


		BorderLayout b = new BorderLayout();
		setLayout(b);
		add("North",pnlTopo);
		add("West",pnlBotoes);
		add("Center",txtTabua);

		txtTabua.setFont(new Font("Courier",Font.PLAIN,12));
	}


	public boolean action(Event evt, Object arg){
		if (evt.target instanceof Button){
			if (((String)arg).equals("Adicionar")){
				if (!txtPalavra.getText().equals(""))
					lstPalavras.add(txtPalavra.getText());
				txtPalavra.setText("");
			}
			
			if (((String)arg).equals("Gera Matriz"))
				geraTabua();
			
			if (((String)arg).equals("Reinicia")){
				txtWidth.setText("");
				txtHeight.setText("");
				txtPalavra.setText("");
				txtTabua.setText("");
				lstPalavras.removeAll();
			}			
		}
		return false;
	}

	private void geraTabua(){
		txtTabua.setText("");
		int w = new Integer(txtWidth.getText()).intValue();
		int h = new Integer(txtHeight.getText()).intValue();
		ArrayList<String> v = new ArrayList<String>();
		for (int i = 0; i < lstPalavras.getItemCount(); i++){
			v.add(lstPalavras.getItem(i));
		}
		ManipulaTabua tabua = new ManipulaTabua(v,w,h);
		char t[][] = tabua.getTabua();
		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				txtTabua.setText(txtTabua.getText().concat(new Character(t[i][j]).toString()));
				txtTabua.setText(txtTabua.getText().concat(" "));
			}
			txtTabua.setText(txtTabua.getText().concat("\n"));		
		}
	}
}
