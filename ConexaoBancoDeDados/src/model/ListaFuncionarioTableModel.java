package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import control.FuncionarioController;

public class ListaFuncionarioTableModel extends AbstractTableModel{

    private List<String[]> dadosFuncionarios;
    private String[] titulos;

    public ListaFuncionarioTableModel(){
        titulos = new String[]{"Nome", "Cargo", "Salario"};
        dadosFuncionarios = new FuncionarioController().listarFuncionarios();
    }

    public ListaFuncionarioTableModel(List<String[]> dadosFuncionarios){
        titulos = new String[]{"Nome", "Cargo", "Salario"};
        this.dadosFuncionarios = dadosFuncionarios;
    }
    
	@Override
	public int getRowCount() {
        return dadosFuncionarios.size();
	}

	@Override
	public int getColumnCount() {
        return titulos.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
        String[] dadosFuncionario = dadosFuncionarios.get(rowIndex);        
        switch (columnIndex) {
            case 0: return dadosFuncionario[1];
            case 1: return dadosFuncionario[2];
            case 2: return dadosFuncionario[3];
            default:
                System.out.println("Erro ao apresentar os dados");
        }
        return "";
	}

}
